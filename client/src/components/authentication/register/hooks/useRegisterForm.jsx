import { useToast } from "@/hooks/use-toast";
import { registerSchema } from "@/schemas/registerSchema";
import { AuthService } from "@/services/AuthService";
import { zodResolver } from "@hookform/resolvers/zod";
import { useState } from "react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";

export const useRegisterForm = () => {
    const [isLoading, setIsLoading] = useState(false);
    const navigate = useNavigate();
  
    const { toast } = useToast();

    const {registerUser} = AuthService();
  
    const form = useForm({
      resolver: zodResolver(registerSchema),
      defaultValues: {
        username: "",
        email: "",
        password: "",
        confirmPassword: "",
      },
    });
  
    async function onSubmit(values) {
      setIsLoading(true);
    
      try {
        const {response} = await registerUser(values);
        response;
        toast({
          title: "Registro exitoso",
          description: "Ahora puedes iniciar sesión",
          variant: "success",
        });
  
        navigate("/login");
  
      } catch (error) {
        toast({
          title: "Error",
          description: "Hubo un problema al crear la cuenta. Intenta más tarde.",
          variant: "destructive",
        });
        console.error(error);
        form.setError("root", {
          message: "Error al registrar el usuario",
        });
      } finally {
        setIsLoading(false);
      }
    }

    return {
        isLoading, onSubmit, form
    }
}
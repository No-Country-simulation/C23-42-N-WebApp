import { useState } from "react";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { useToast } from "@/hooks/use-toast";
import { AuthService } from "@/services/AuthService.js";
import { useNavigate } from "react-router-dom";
import { loginSchema } from "@/schemas/loginSchema";
import Cookies from "js-cookie";
import { saveTokenToCookies } from "@/lib/saveTokenToCookies";

export function useLoginForm() {
  const [isLoading, setIsLoading] = useState(false);
  const { toast } = useToast();
  const { loginUser } = AuthService();
  const navigate = useNavigate();

  const form = useForm({
    resolver: zodResolver(loginSchema),
    defaultValues: {
      email: "",
      password: "",
    },
  });

  const onSubmit = async (values) => {
    setIsLoading(true);

    try {
      const { data } = await loginUser(values);
      toast({
        title: "Inicio de sesión exitoso",
        description: "Bienvenido a la plataforma",
        variant: "successBtn",
      });
      console.log(data);
      saveTokenToCookies(data.token);

      navigate("/");
    } catch (error) {
      toast({
        title: "Error",
        description: "Hubo un problema al iniciar sesión. Intente más tarde.",
        variant: "destructive",
      });
    } finally {
      setIsLoading(false);
    }
  };

  return {
    form,
    isLoading,
    onSubmit,
  };
}

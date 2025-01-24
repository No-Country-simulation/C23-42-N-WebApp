import { useToast } from "@/hooks/use-toast";
import { AuthService } from "@/services/AuthService";
import { zodResolver } from "@hookform/resolvers/zod";
import { useState } from "react";
import { useForm } from "react-hook-form";
import { redirect } from "react-router-dom";
import { z } from "zod";

const authService = AuthService();

export const useRegisterForm = () => {
  const [isLoading, setIsLoading] = useState(false);
  const { toast } = useToast();

  const formSchema = z
    .object({
      username: z.string(),
      email: z.string().email({ message: "Formato de email incorrecto" }),
      password: z
        .string()
        .min(8, {
          message: "La contraseña debe tener al menos 8 caracteres",
        })
        .regex(/[A-Z]/, {
          message: "Debe incluir al menos una letra mayúscula",
        })
        .regex(/[a-z]/, {
          message: "Debe incluir al menos una letra minúscula",
        })
        .regex(/\d/, { message: "Debe incluir al menos un número" }),

      confirmPassword: z.string().min(8, {
        message: "La contraseña debe tener al menos 8 caracteres",
      }),
    })
    .refine((data) => data.password === data.confirmPassword, {
      path: ["confirmPassword"],
      message: "Las contraseñas no coinciden",
    });

  const form = useForm({
    resolver: zodResolver(formSchema),
    defaultValues: {
      username: "",
      email: "",
      password: "",
      confirmPassword: "",
    },
  });

  async function onSubmit(values) {
    setIsLoading(true);
    console.log(values, "here");
    try {
      const response = await authService().registerUser(values);

      toast({
        title: "Registro exitoso",
        description: "Ahora puedes iniciar sesión",
        variant: "success",
      });

      if (response.status === 200) redirect("/login");

      console.log(values);
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
    form,
    isLoading,
    onSubmit,
  };
};

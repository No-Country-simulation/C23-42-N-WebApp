import { useState } from "react";
import { useForm } from "react-hook-form";
import { Button } from "./ui/button";
import { Input } from "./ui/input";
import { Card, CardContent, CardHeader } from "./ui/card";
import { Link } from 'react-router-dom'
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "./ui/form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import axiosInstance from "../services/axiosInstance";
import { useToast } from "../hooks/use-toast";

export default function RegisterForm() {
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
    console.log(values);

    try {
      const response = await axiosInstance.post("/users", {
        data: {
          username: values.username,
          email: values.email,
          password: values.password,
        },
      });

      toast({
        title: "Registro exitoso",
        description: "Ahora puedes iniciar sesión",
        variant: "success",
      });

      if (response.status === 200) {
        window.location.href = "/login";
      }

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

  return (
    <div className="flex min-h-screen items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
      <Card className="w-full max-w-md">
        <CardHeader className="space-y-2 text-center">
          <div className="flex justify-center">
          <Link to="/">
            <img
              src="/logo-musync3.png"
              alt="Logo"
              width={48}
              height={48}
              className="h-12 w-12"
            />
            </Link>
          </div>
          <h1 className="text-2xl font-bold tracking-tight text-orangePrimary">
            Crear cuenta
          </h1>
          <p className="text-sm text-gray-600">
            ¿Ya tienes una cuenta?{" "}
            <a
              href="/login"
              className="text-indigo-500 font-bold  hover:underline"
            >
              Inicia sesión
            </a>
          </p>
        </CardHeader>
        <CardContent>
          <Form {...form}>
            <form
              onSubmit={form.handleSubmit(onSubmit)}
              className="space-y-4"
              noValidate
            >
              <FormField
                control={form.control}
                name="username"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel className="text-left w-full block font-medium">
                      Nombre de usuario
                    </FormLabel>
                    <FormControl>
                      <Input
                        className="focus:bg-white focus:text-black text-black placeholder:text-red-500 placeholder:opacity-50"
                        placeholder="john doe"
                        {...field}
                      />
                    </FormControl>
                    <FormMessage />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="email"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel className="text-left w-full block font-medium">
                      Email
                      <span className="text-red-500"> *</span>
                    </FormLabel>
                    <FormControl>
                      <Input
                        type="email"
                        {...field}
                        className="placeholder:text-gray-500 placeholder:opacity-50"
                        placeholder="jhon@example.com"
                      />
                    </FormControl>
                    <FormMessage className="text-left w-full block font-medium" />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="password"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel className="text-left w-full block font-medium">
                      Contraseña
                      <span className="text-red-500"> *</span>
                    </FormLabel>
                    <FormControl>
                      <Input type="password" {...field} minLength={6} />
                    </FormControl>
                    <FormMessage className="text-left w-full block font-medium" />
                  </FormItem>
                )}
              />
              <FormField
                control={form.control}
                name="confirmPassword"
                render={({ field }) => (
                  <FormItem>
                    <FormLabel className="text-left w-full block font-medium">
                      Confirmar Contraseña
                      <span className="text-red-500"> *</span>
                    </FormLabel>
                    <FormControl>
                      <Input
                        type="password"
                        {...field}
                        // pattern={password}
                        // onInvalid={(e) => {
                        //   e.target.setCustomValidity(
                        //     "Las contraseñas no coinciden",
                        //   );
                        // }}
                        // onInput={(e) => {
                        //   e.target.setCustomValidity("");
                        // }}
                      />
                    </FormControl>
                    <FormMessage className="text-left w-full block font-medium" />
                  </FormItem>
                )}
              />
              <Button
                type="submit"
                variant="btnOrange"
                className="w-full"
                disabled={isLoading}
              >
                {isLoading ? "Registrando..." : "Registrarse"}
              </Button>
            </form>
          </Form>
        </CardContent>
      </Card>
    </div>
  );
}

import { useState } from "react";
import { useForm } from "react-hook-form";
import { Button } from "./ui/button";
import { Input } from "./ui/input";
import { Card, CardContent, CardHeader } from "./ui/card";
import { Link, redirect } from "react-router-dom";
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
        redirect("/login");
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
  //test
  return (
    <div className="flex flex-col lg:flex-row min-h-screen h-screen items-center justify-center py-12 px-4 sm:px-6 lg:px-8 w-full gap-4 bg-orangePrimary/10">
      <div className="w-full flex justify-center">
        <Card className="w-[500px]">
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
              <Link
                to="/login"
                className="text-indigo-500 font-bold  hover:underline"
              >
                Inicia sesión
              </Link>
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
                        />
                      </FormControl>
                      <FormMessage
                        className={`text-left w-full block font-medium ${form.formState.errors.confirmPassword ? "" : "text-gray-500"} `}
                      >
                        Ingresar un email: ejemplo@gmail.com
                      </FormMessage>
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
                      <FormMessage
                        className={`text-left w-full block font-medium ${form.formState.errors.confirmPassword ? "" : "text-gray-500"}`}
                      >
                        Al menos 8 caracteres: una letra mayúscula, minúscula y
                        un número
                      </FormMessage>
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
                        <Input type="password" {...field} />
                      </FormControl>
                      <FormMessage
                        className={`text-left w-full block font-medium ${form.formState.errors.confirmPassword ? "" : "text-gray-500"}`}
                      >
                        Ingresar nuevamente la contraseña
                      </FormMessage>
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

      <div className="hidden lg:flex flex-col items-center justify-center p-8 w-full">
        <div className="relative w-80 h-80 rounded-full bg-white shadow-2xl flex items-center justify-center overflow-hidden">
          <img src="/images/musync1_720.jpg" />
        </div>
        <p className="mt-8 text-lg text-center text-muted-foreground max-w-md">
          Conecta, chatea, publica, comparte y sincroniza tu música con el mundo
        </p>
      </div>
    </div>
  );
}

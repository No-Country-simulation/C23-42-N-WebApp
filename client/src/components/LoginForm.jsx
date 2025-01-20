import { useState } from "react";
import { useForm } from "react-hook-form";
import { Button } from "./ui/button";
import { Input } from "./ui/input";
import { Card, CardContent, CardHeader } from "./ui/card";
import { Link } from "react-router-dom";
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

export default function LoginForm() {
  const [isLoading, setIsLoading] = useState(false);
  const { toast } = useToast();

  const formSchema = z.object({
    email: z.string().email({ message: "Formato de email incorrecto" }),
    password: z.string().min(1, { message: "Debe introducir su contraseña" }),
  });

  const form = useForm({
    resolver: zodResolver(formSchema),
    defaultValues: {
      email: "",
      password: "",
    },
  });

  async function onSubmit(values) {
    setIsLoading(true);
    try {
      const response = await axiosInstance.post("/login", {
        email: values.email,
        password: values.password,
      });

      if (response.status === 200) {
        // Successful login
        toast({
          title: "Inicio de sesión exitoso",
          description: "Bienvenido a la plataforma",
          variant: "success",
        });
        // Save login timestamp (optional)
        localStorage.setItem("lastLogin", new Date().toISOString());
        // Redirect to dashboard
        window.location.href = "/dashboard";
      }
    } catch (error) {
      if (error.response) {
        switch (error.response.status) {
          case 404:
            form.setError("email", {
              type: "manual",
              message: "No existe una cuenta con este correo",
            });
            break;
          case 401:
            form.setError("password", {
              type: "manual",
              message: "Contraseña incorrecta",
            });
            break;
          default:
            toast({
              title: "Error",
              description:
                "Hubo un problema al iniciar sesión. Intente más tarde.",
              variant: "destructive",
            });
        }
      } else {
        toast({
          title: "Error",
          description: "Hubo un problema al iniciar sesión. Intente más tarde.",
          variant: "destructive",
        });
      }
    } finally {
      setIsLoading(false);
    }
  }

  return (
    <div className="flex min-h-screen items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
      <Card className="w-full max-w-md">
        <CardHeader className="space-y-2 text-center">
          <div className="flex justify-center">
            {/* Agrega el componente Link envolviendo la imagen */}
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
            Iniciar sesión
          </h1>
          <p className="text-sm text-gray-600">
            ¿No tienes una cuenta?{" "}
            <Link
              to="/register"
              className="text-indigo-500 font-bold hover:underline"
            >
              Regístrate
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
                      <Input type="password" {...field} />
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
                {isLoading ? "Iniciando sesión..." : "Iniciar sesión"}
              </Button>
            </form>
          </Form>
        </CardContent>
      </Card>
    </div>
  );
}

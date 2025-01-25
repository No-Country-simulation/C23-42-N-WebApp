import { Button } from "../../ui/button";
import { Input } from "../../ui/input";
import { Card, CardContent, CardHeader } from "../../ui/card";
import { Link } from "react-router-dom";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "../../ui/form";

import { registerFormContent } from "./content/registerFormContent";
import { useRegisterForm } from "./hooks/useRegisterForm";

export default function RegisterForm() {
  const { isLoading, form, onSubmit } = useRegisterForm();
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

                {
                  registerFormContent.map((elem) => {
                    return (
                      <FormField
                        key={elem.name} 
                        control={form.control}
                        name={elem.name}
                        render={({ field }) => (
                          <FormItem>
                            <FormLabel className="text-left w-full block font-medium">
                              {elem.label}
                              <span className="text-red-500"> *</span>
                            </FormLabel>
                            <FormControl>
                              <Input
                                type={elem.type} 
                                {...field}
                                className="placeholder:text-gray-500 placeholder:opacity-50"
                              />
                            </FormControl>
                            <FormMessage
                              className={`text-left w-full block font-medium ${form.formState.errors[elem.name] ? "text-red-500" : "text-gray-500"
                                }`}
                            >
                              {elem.placeholder}
                            </FormMessage>
                          </FormItem>
                        )}
                      />
                    );
                  })
                }

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

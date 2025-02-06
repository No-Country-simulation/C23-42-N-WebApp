import { Link } from "react-router-dom"
import { Input } from "@/components/ui/input"
import { Card, CardContent, CardHeader } from "@/components/ui/card"
import { Form, FormControl, FormField, FormItem, FormLabel, FormMessage } from "@/components/ui/form"
import { Button } from "@/components/ui/button"
import { useLoginForm } from "./hooks/useLoginForm"
import { loginFormContent } from "./content/loginFormContent.js"

export default function LoginForm() {
  const { form, isLoading, onSubmit } = useLoginForm()

  return (
    <div className="flex flex-col lg:flex-row min-h-screen h-screen items-center justify-center py-12 px-4 sm:px-6 lg:px-8 w-full gap-4 bg-orangePrimary/10">
      <div className="w-full flex justify-center">
        <Card className="w-[500px]">
          <CardHeader className="space-y-2 text-center">
            <div className="flex justify-center">
              <Link to="/">
                <img src="/logo-musync3.png" alt="Logo" width={48} height={48} className="h-12 w-12" />
              </Link>
            </div>
            <h1 className="text-2xl font-bold tracking-tight text-orangePrimary">Iniciar sesión</h1>
            <p className="text-sm text-gray-600">
              ¿No tienes una cuenta?{" "}
              <Link to="/register" className="text-indigo-500 font-bold hover:underline">
                Regístrate
              </Link>
            </p>
          </CardHeader>
          <CardContent>
            <Form {...form}>
              <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4" noValidate>
                {loginFormContent.map((field) => (
                  <FormField
                    key={field.name}
                    control={form.control}
                    name={field.name}
                    render={({ field: formField }) => (
                      <FormItem>
                        <FormLabel className="text-left w-full block font-medium">
                          {field.label}
                          <span className="text-red-500"> *</span>
                        </FormLabel>
                        <FormControl>
                          <Input
                            type={field.type}
                            placeholder={field.placeholder}
                            className="placeholder:text-gray-500 placeholder:opacity-50"
                            {...formField}
                          />
                        </FormControl>
                        <FormMessage className="text-left w-full block font-medium" />
                      </FormItem>
                    )}
                  />
                ))}
                <Button type="submit" variant="btnOrange" className="w-full" disabled={isLoading}>
                  {isLoading ? "Iniciando sesión..." : "Iniciar sesión"}
                </Button>
              </form>
            </Form>
          </CardContent>
        </Card>
      </div>

      <div className="hidden lg:flex flex-col items-center justify-center p-8 w-full">
        <div className="relative w-80 h-80 rounded-full bg-white shadow-2xl flex items-center justify-center overflow-hidden">
          <img src="/images/musync1_720.jpg" alt="Musync" />
        </div>
        <p className="mt-8 text-lg text-center text-muted-foreground max-w-md">
          Conecta, chatea, publica, comparte y sincroniza tu música con el mundo
        </p>
      </div>
    </div>
  )
}






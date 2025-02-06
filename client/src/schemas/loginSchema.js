import { z } from "zod";

export const loginSchema = z.object({
    email: z.string().email({ message: "Formato de email incorrecto" }),
    password: z.string().min(1, { message: "Debe introducir su contraseña" }),
})


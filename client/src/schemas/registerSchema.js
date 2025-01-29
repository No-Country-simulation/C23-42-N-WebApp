import { z } from "zod";

export const registerSchema = z
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
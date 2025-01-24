export const registerFormContent = [
  {
    name: "username",
    label: "Nombre de usuario",
    required: false,
    type: "text",
    placeholder: false,
  },
  {
    name: "email",
    label: "Email",
    required: true,
    type: "email",
    placeholder: "Ingresar un email: ejemplo@gmail.com",
  },
  {
    name: "password",
    label: "Contraseña",
    required: true,
    type: "password",
    placeholder:
      "Al menos 8 caracteres: una letra mayúscula, minúscula y un número",
  },
  {
    name: "confirmPassword",
    label: "Confirmar Contraseña",
    required: true,
    type: "password",
    placeholder: "Ingresar nuevamente la contraseña",
  },
];

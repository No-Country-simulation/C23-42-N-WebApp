import axiosInstance from "@/lib/axiosInstance";

export const AuthService = () => {
  const registerUser = async (values) => {
    const response = await axiosInstance.post("/auth/register", {
      data: {
        username: values.username,
        email: values.email,
        password: values.password,
      },
    });
    return response;
  };

  return {
    registerUser,
  };
};

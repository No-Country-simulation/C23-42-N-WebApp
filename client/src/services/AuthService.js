import axiosInstance from "@/lib/axiosInstance";

export const AuthService = () => {

    const loginUser = async (values) => {
        const response = await axiosInstance.post("/auth/login", {
            email: values.email,
            password: values.password,
        });
        return response;
    };


    const registerUser = async (values) => {
        const response = await axiosInstance.post("/auth/register", {
            username: values.username,
            email: values.email,
            password: values.password,
        });
        return response;
    };

    return {
        loginUser,
        registerUser
    };
};
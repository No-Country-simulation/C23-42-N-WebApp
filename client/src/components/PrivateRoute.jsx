import { getTokenFromCookies } from "@/lib/getTokenFromCookies";
import { Navigate, Outlet } from "react-router-dom";

const isAuthenticated = () => {
  const token = getTokenFromCookies();
  return token;
};

export const PrivateRoute = () => {
  return isAuthenticated() ? <Outlet /> : <Navigate to="/login" />;
};

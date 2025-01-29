import { useUserStore } from "@/store/useUserStore";
import Cookies from "js-cookie";

export const logoutUser = () => {
  const { removeUser } = useUserStore.getState();

  removeUser();
  Cookies.remove("authToken", {
    path: "/",
  });
};

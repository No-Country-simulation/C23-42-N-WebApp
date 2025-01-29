import Cookies from "js-cookie";

export const getTokenFromCookies = () => {
  const token = Cookies.get("authToken");
  return !!token;
};

import Cookies from "js-cookie";

export const saveTokenToCookies = (token) => {
  Cookies.set("authToken", token, {
    expires: 1,
    path: "/",
    secure: process.env.NODE_ENV === "production",
    sameSite: "Strict",
  });
};

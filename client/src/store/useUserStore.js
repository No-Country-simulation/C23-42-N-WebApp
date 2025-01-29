import { create } from "zustand";
import { persist, createJSONStorage } from "zustand/middleware";

export const useUserStore = create(
  persist(
    (set) => ({
      user: null,
      setUser: (user) => set({ user }),
      removeUser: () => {
        set({ user: null });
        localStorage.removeItem("auth-musync");
      },
    }),
    {
      name: "auth-musync",
      storage: createJSONStorage(() => localStorage),
    },
  ),
);

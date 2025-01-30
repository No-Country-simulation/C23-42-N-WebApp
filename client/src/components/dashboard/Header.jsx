import { useState, useEffect } from "react";
import { useUserStore } from "@/store/useUserStore";
import Avatar from "react-avatar";
import SearchMusync from "./SearchMusync";
import { Skeleton } from "@/components/ui/skeleton";

export function Header() {
  const { user } = useUserStore();
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false);
    }, 2000); // Simula una carga de 2 segundos

    return () => clearTimeout(timer);
  }, []);

  return (
    <header className="sticky top-0 flex items-center justify-center gap-16 bg-background/95 p-6 backdrop-blur-md">
      <SearchMusync />
      <div className="flex items-center gap-4">
        {isLoading ? (
          <Skeleton className="h-12 w-12 rounded-full" />
        ) : (
          <Avatar name={user?.username} size="50" round={true} color="#FF5722" />
        )}

        <div className="flex flex-col">
          {isLoading ? (
            <>
              <Skeleton className="h-4 w-24 rounded-md mb-1" />
              <Skeleton className="h-3 w-20 rounded-md" />
            </>
          ) : (
            <>
              <span className="text-gray-500 text-[14px] font-semibold capitalize">
                {user?.username}
              </span>
              <span className="text-gray-500 text-[13px]">1,2k Followers</span>
            </>
          )}
        </div>
      </div>
    </header>
  );
}


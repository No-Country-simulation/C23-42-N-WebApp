import { useState, useEffect } from "react";
import { SearchIcon } from "lucide-react";
import { Input } from "@/components/ui/input";
import { Skeleton } from "@/components/ui/skeleton";

export default function SearchMusync() {
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false);
    }, 2000); // Simula una carga de 2 segundos

    return () => clearTimeout(timer);
  }, []);

  return (
    <div className="relative w-full max-w-xl">
      {isLoading ? (
        <Skeleton className="h-12 w-full rounded-xl" />
      ) : (
        <>
          <Input
            type="search"
            placeholder="Search for a song"
            className="h-12 pl-4 pr-10 rounded-xl bg-secondary/50 border-0 placeholder:text-muted-foreground/60"
          />
          <SearchIcon className="absolute right-3 top-1/2 -translate-y-1/2 h-5 w-5 text-muted-foreground/60" />
        </>
      )}
    </div>
  );
}


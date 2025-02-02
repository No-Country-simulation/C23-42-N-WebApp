import { useState, useEffect } from "react";
import { Search } from "lucide-react";
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
    <div className="w-full px-4 sm:px-6 lg:px-8">
    <div className="relative w-full max-w-xl">
    
      {isLoading ? (
        <Skeleton className="h-10 sm:h-12 w-full rounded-xl" />
      ) : (
        <div className="relative">
          <Input
            type="search"
            placeholder="Search for a song"
            className="h-10 sm:h-12 pl-10 pr-4 rounded-xl bg-secondary/50 border-0 placeholder:text-muted-foreground/60 w-full text-sm sm:text-base"
          />
          <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 sm:h-5 sm:w-5 text-muted-foreground/60" />
        </div>
      )}
    </div>
    </div>
  );
}


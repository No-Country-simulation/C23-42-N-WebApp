import { useState, useEffect } from "react";
import PropTypes from "prop-types";
import { Skeleton } from "@/components/ui/skeleton";

export function PlaylistItem({ title, type, owner }) {
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false);
    }, 2000); // Simula una carga de 2 segundos

    return () => clearTimeout(timer);
  }, []);

  return (
    <a href="#" className="flex items-center gap-3 rounded-md px-3 py-2 hover:bg-orange-100/10">
      {/* Imagen de la playlist */}
      {isLoading ? (
        <Skeleton className="size-12 rounded" />
      ) : (
        <div className="size-12 rounded bg-muted" />
      )}

      {/* Detalles de la playlist */}
      <div className="flex-1 truncate">
        {isLoading ? (
          <>
            <Skeleton className="h-4 w-32 mb-1 rounded-md" />
            <Skeleton className="h-3 w-24 rounded-md" />
          </>
        ) : (
          <>
            <div className="font-medium">{title}</div>
            <div className="text-sm text-muted-foreground">{type} • {owner}</div>
          </>
        )}
      </div>
    </a>
  );
}

PlaylistItem.propTypes = {
  title: PropTypes.string.isRequired,
  type: PropTypes.string.isRequired,
  owner: PropTypes.string.isRequired,
};

  
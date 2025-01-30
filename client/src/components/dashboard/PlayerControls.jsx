import { useState, useEffect } from "react";
import { Slider } from "@/components/ui/slider";
import { Button } from "@/components/ui/button";
import { Skeleton } from "@/components/ui/skeleton";
import {
  Heart,
 
  SkipBack,
  Play,
  SkipForward,
  Shuffle,
  Repeat,
  Volume2,
} from "lucide-react";

export default function PlayerControls() {
  const [progress, setProgress] = useState(18);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false);
    }, 2000); // Simula una carga de 2 segundos

    return () => clearTimeout(timer);
  }, []);

  const formatTime = (percentage) => {
    const totalSeconds = Math.floor((238 * percentage) / 100);
    const minutes = Math.floor(totalSeconds / 60);
    const seconds = totalSeconds % 60;
    return `${minutes}:${seconds.toString().padStart(2, "0")}`;
  };

  return (
    <div className="flex justify-between gap-10 border-t bg-background py-6 w-full">
      {/* Controles de reproducción */}
      <div className="flex items-center gap-2">
        {isLoading ? (
          <>
            <Skeleton className="h-10 w-10 rounded-full" />
            <Skeleton className="h-10 w-10 rounded-full" />
            <Skeleton className="h-10 w-10 rounded-full" />
          </>
        ) : (
          <>
            <Button variant="ghost" size="icon" className="text-muted-foreground hover:text-foreground">
              <SkipBack className="h-5 w-5" />
            </Button>
            <Button variant="ghost" size="icon" className="text-muted-foreground hover:text-foreground">
              <Play className="h-5 w-5" />
            </Button>
            <Button variant="ghost" size="icon" className="text-muted-foreground hover:text-foreground">
              <SkipForward className="h-5 w-5" />
            </Button>
          </>
        )}
      </div>

      {/* Barra de progreso */}
      <div className="flex items-center gap-3 w-full">
        {isLoading ? (
          <>
            <Skeleton className="h-4 w-10 rounded-md" />
            <Skeleton className="h-3 w-full rounded-md flex-1" />
            <Skeleton className="h-4 w-10 rounded-md" />
          </>
        ) : (
          <>
            <span className="text-sm text-muted-foreground min-w-[40px]">{formatTime(progress)}</span>
            <Slider value={[progress]} onValueChange={(value) => setProgress(value[0])} max={100} step={1} className="flex-1" />
            <span className="text-sm text-muted-foreground min-w-[40px]">3:58</span>
          </>
        )}
      </div>

      {/* Botones de opciones */}
      <div className="flex items-center gap-2">
        {isLoading ? (
          <>
            <Skeleton className="h-10 w-10 rounded-full" />
            <Skeleton className="h-10 w-10 rounded-full" />
            <Skeleton className="h-10 w-10 rounded-full" />
            <Skeleton className="h-10 w-10 rounded-full" />
          </>
        ) : (
          <>
            <Button variant="ghost" size="icon" className="text-muted-foreground hover:text-foreground">
              <Heart className="h-5 w-5" />
            </Button>
            <Button variant="ghost" size="icon" className="text-muted-foreground hover:text-foreground">
              <Shuffle className="h-5 w-5" />
            </Button>
            <Button variant="ghost" size="icon" className="text-muted-foreground hover:text-foreground">
              <Repeat className="h-5 w-5" />
            </Button>
            <Button variant="ghost" size="icon" className="text-muted-foreground hover:text-foreground">
              <Volume2 className="h-5 w-5" />
            </Button>
          </>
        )}
      </div>
    </div>
  );
}

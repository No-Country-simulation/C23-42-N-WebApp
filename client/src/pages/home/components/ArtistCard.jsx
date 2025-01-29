import { Card, CardContent } from "@/components/ui/card";
import { Play } from "lucide-react";

export function ArtistCard({
  name,
  image = "/placeholder.svg",
  followers,
  children,
}) {
  return (
    <Card className="group relative  transition-all hover:bg-orange-100/10 bg-transparent rounded-3xl">
      <CardContent className="p-4">
        <div className=" aspect-square w-full overflow-hidden rounded-3xl bg-transparent">
          <div className="relative w-full h-full">
            <img
              src={image}
              alt={name}
              className="object-cover w-full h-full transition-all group-hover:scale-105 "
            />
            <div className="absolute inset-0 group-hover:bg-white/40">
              <button
                className="absolute inset-0 m-auto flex h-12 w-12 items-center justify-center rounded-full bg-[#FF5722] opacity-0 shadow-lg transition-all group-hover:opacity-100"
                aria-label={`Reproducir música de ${name}`}
              >
                <Play className="ml-1 h-6 w-6 text-white" fill="white" />
              </button>
            </div>
          </div>
        </div>
        <div className="mt-4 bg-transparent text-center">
          <h3 className="font-semibold text-white/50">{name}</h3>
          <p className="mt-1 text-sm text-white/40">{followers} seguidores</p>
        </div>
        {children && <div>{children}</div>}
      </CardContent>
    </Card>
  );
}

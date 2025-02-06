import { Play } from "lucide-react";

import { Card, CardContent } from "@/components/ui/card";
import {
  Carousel,
  CarouselContent,
  CarouselItem,
  CarouselNext,
  CarouselPrevious,
} from "@/components/ui/carousel";
import { GradientCard } from "./GradientCard";
import { useEffect, useState } from "react";
import { Skeleton } from "@/components/ui/skeleton";

export function CarouselCards({ artists, gender }) {
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false);
    }, 2000);

    return () => clearTimeout(timer);
  }, []);

  return (
    <>
      <div className="mr-36 ">
        <Carousel className="w-full">
          <h2 className="text-xl font-semibold mb-4 text-gray-400 relative">
            {gender}
          </h2>
          <div className="absolute top-3  right-12">
            <CarouselPrevious className="hidden md:flex" />
            <CarouselNext className="hidden md:flex" />
          </div>
          <CarouselContent className="-ml-2 md:-ml-4">
            {artists.map((artist, index) => (
              <CarouselItem
                key={index}
                className="pl-2 md:pl-4 basis-full md:basis-1/3 lg:basis-1/5"
              >
                <Card
                  className={`${isLoading ? "bg-orangePrimary/20 p-4" : ""} border-none group rounded-3xl`}
                >
                  <CardContent className="p-0">
                    {isLoading ? (
                      <>
                        <Skeleton className="aspect-square w-full mb-3 rounded-3xl" />
                        <Skeleton className="h-6 w-3/4 mb-2 text-center" />
                        <Skeleton className="h-4 w-1/2 text-center" />
                      </>
                    ) : (
                      <>
                        <GradientCard
                          image={artist.image}
                          isLoading={isLoading}
                        >
                          <div className="relative w-full h-full ">
                            <img
                              alt={artist.name}
                              src={artist.image}
                              className="object-cover aspect-square rounded-3xl overflow-hidden w-full h-full "
                            />
                            <div className="absolute inset-0 group-hover:bg-white/30 rounded-3xl flex justify-center items-center">
                              <button
                                className="flex h-12 w-12 items-center justify-center rounded-full bg-[#FF5722] opacity-0 shadow-lg transition-all group-hover:opacity-100"
                                aria-label={`Reproducir música de ${artist.name}`}
                              >
                                <Play
                                  className="ml-1 h-6 w-6 text-white"
                                  fill="white"
                                />
                              </button>
                            </div>
                          </div>

                          <div className="mt-4 bg-transparent text-center">
                            <h3 className="font-semibold text-white/50">
                              {artist.name}
                            </h3>
                            <p className="mt-1 text-sm text-white/40">
                              {artist.followers} seguidores
                            </p>
                          </div>
                        </GradientCard>
                      </>
                    )}
                  </CardContent>
                </Card>
              </CarouselItem>
            ))}
          </CarouselContent>
        </Carousel>
      </div>
    </>
  );
}

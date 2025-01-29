import { Play } from "lucide-react";

import { Card, CardContent } from "@/components/ui/card";
import {
  Carousel,
  CarouselContent,
  CarouselItem,
} from "@/components/ui/carousel";
import { GradientCard } from "./GradientCard";

const artists = [
  {
    name: "Taylor Swift",
    image: "/images/Taylor.jpg",
    followers: "100M",
  },
  {
    name: "Bad Bunny",
    image: "/images/Bad bunny.PNG",
    followers: "80M",
  },
  {
    name: "The Weeknd",
    image: "/images/the weeknd.png",
    followers: "75M",
  },
  {
    name: "Drake",
    image: "/images/drake.jpg",
    followers: "70M",
  },
  {
    name: "Ed Sheeran",
    image: "/images/ed sheeran.jpg",
    followers: "95M",
  },
  {
    name: "Ariana Grande",
    image: "/images/ariana grande.jpg",
    followers: "85M",
  },
];

export function CarouselCards() {
  return (
    <>
      <div className="w-full ">
        <Carousel className="w-full">
          <CarouselContent className="-ml-2 md:-ml-4">
            {artists.map((artist, index) => (
              <CarouselItem
                key={index}
                className="pl-2 md:pl-4 basis-full md:basis-1/3 lg:basis-1/5"
              >
                <Card className="border-none rounded-3xl group">
                  <CardContent className="p-0">
                    <GradientCard image={artist.image}>
                      <div className="relative w-full h-full ">
                        <img
                          src={artist.image}
                          alt={artist.name}
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

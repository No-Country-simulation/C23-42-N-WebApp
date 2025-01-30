
import { useState, useEffect } from "react";
import { Carousel, CarouselContent, CarouselItem } from "@/components/ui/carousel";
import { Chip } from "@/components/ui/Chip";
import { Skeleton } from "@/components/ui/skeleton";
import useEmblaCarousel from "embla-carousel-react";

const categories = [
  { id: 1, label: "All" },
  { id: 2, label: "Relax" },
  { id: 3, label: "Pop" },
  { id: 4, label: "Rock" },
  { id: 5, label: "Jazz" },
  { id: 6, label: "Classical" },
  { id: 7, label: "Hip Hop" },
  { id: 8, label: "Electronic" },
  { id: 9, label: "Sad" },
  { id: 10, label: "Party" },
  { id: 11, label: "Romance" },
  { id: 12, label: "Energetic" },
];

export function ChipsCarousel() {
  const [selectedCategory, setSelectedCategory] = useState("All");
  const [emblaRef] = useEmblaCarousel({
    align: "start",
    loop: false,
  });
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false);
    }, 2000);

    return () => clearTimeout(timer);
  }, []);

  if (isLoading) {
    return (
      <div className="relative w-full mb-6">
        <Carousel className="w-full">
          <CarouselContent className="-ml-2">
            {[...Array(8)].map((_, index) => (
              <CarouselItem key={index} className="pl-2 basis-auto">
                <Skeleton className="h-10 w-24 rounded-full" />
              </CarouselItem>
            ))}
          </CarouselContent>
        </Carousel>
      </div>
    );
  }

  return (
    <div className="relative w-full mb-6">
      {/* Contenedor de botones de navegación alineados a la derecha */}
      <div className="flex justify-end mb-2 space-x-2">
        <button className="px-4 py-2 bg-gray-300 text-gray-700 rounded-md">
          {"<"}
        </button>
        <button className="px-4 py-2 bg-gray-300 text-gray-700 rounded-md">
          {">"}
        </button>
      </div>

      {/* Carrusel */}
      <Carousel ref={emblaRef} className="w-full">
        <CarouselContent className="-ml-2">
          {categories.map((category) => (
            <CarouselItem key={category.id} className="pl-2 basis-auto">
              <Chip
                label={category.label}
                selected={selectedCategory === category.label}
                onClick={() => setSelectedCategory(category.label)}
              />
            </CarouselItem>
          ))}
        </CarouselContent>
      </Carousel>
    </div>
  );
}
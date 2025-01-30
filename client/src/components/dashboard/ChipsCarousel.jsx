import { useState, useEffect, useCallback } from "react";
import { Chip } from "@/components/ui/Chip";
import { Skeleton } from "@/components/ui/skeleton";
import useEmblaCarousel from "embla-carousel-react";
import { Chip } from "../ui/chip";

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
  { id: 13, label: "Reggae" },
  { id: 14, label: "Blues" },
  { id: 15, label: "Country" },
  { id: 16, label: "Indie" },
  { id: 17, label: "Metal" },
  { id: 18, label: "R&B" },
  { id: 19, label: "Latin" },
  { id: 20, label: "Alternative" },
  // Más categorías aquí si es necesario...
];

export function ChipsCarousel() {
  const [selectedCategory, setSelectedCategory] = useState("All");
  const [emblaRef, embla] = useEmblaCarousel({ align: "start", loop: false });
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false);
    }, 2000);
    return () => clearTimeout(timer);
  }, []);

  // Funciones para mover el carrusel
  const scrollPrev = useCallback(() => {
    if (embla) embla.scrollPrev();
  }, [embla]);

  const scrollNext = useCallback(() => {
    if (embla) embla.scrollNext();
  }, [embla]);

  if (isLoading) {
    return (
      <div className="relative w-full mb-6">
        <div className="overflow-hidden" ref={emblaRef}>
          <div className="flex">
            {[...Array(8)].map((_, index) => (
              <div key={index} className="pl-2 flex-shrink-0">
                <Skeleton className="h-10 w-24 rounded-full" />
              </div>
            ))}
          </div>
        </div>
      </div>
    );
  }

  return (
    <div className="relative w-full mb-6">
      {/* Contenedor de botones de navegación */}
      <div className="flex justify-end mb-2 space-x-2">
        <button
          onClick={scrollPrev}
          className="px-4 py-2 bg-gray-300 text-gray-700 rounded-md"
        >
          {"<"}
        </button>
        <button
          onClick={scrollNext}
          className="px-4 py-2 bg-gray-300 text-gray-700 rounded-md"
        >
          {">"}
        </button>
      </div>

      {/* Carrusel (se mueve con emblaRef) */}
      <div className="overflow-hidden" ref={emblaRef}>
        <div className="flex">
          {categories.slice(0, 12).map((category) => (
            <div key={category.id} className="pl-2 flex-shrink-0">
              <Chip
                label={category.label}
                selected={selectedCategory === category.label}
                onClick={() => setSelectedCategory(category.label)}
              />
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}



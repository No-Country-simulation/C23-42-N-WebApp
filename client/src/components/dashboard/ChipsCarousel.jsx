/* eslint-disable */
import { useState, useRef, useEffect } from "react";
import {
  Carousel,
  CarouselContent,
  CarouselItem,
} from "@/components/ui/carousel";
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
];

export function ChipsCarousel() {
  const [selectedCategory, setSelectedCategory] = useState("All");
  const [emblaRef, emblaApi] = useEmblaCarousel({
    align: "start",
    loop: false,
  });
  const [canScrollPrev, setCanScrollPrev] = useState(false);
  const [canScrollNext, setCanScrollNext] = useState(false);

  const onSelect = useRef(() => {});

  onSelect.current = () => {
    if (!emblaApi) return;
    setCanScrollPrev(emblaApi.canScrollPrev());
    setCanScrollNext(emblaApi.canScrollNext());
  };

  useEffect(() => {
    if (!emblaApi) return;

    onSelect.current();
    emblaApi.on("select", onSelect.current);
    emblaApi.on("reInit", onSelect.current);

    return () => {
      emblaApi.off("select", onSelect.current);
      emblaApi.off("reInit", onSelect.current);
    };
  }, [emblaApi]);

  return (
    <div className="relative w-full mb-6">
      <Carousel
        opts={{
          align: "start",
          loop: false,
        }}
        className="w-full"
      >
        <CarouselContent className="-ml-2" ref={emblaRef}>
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

      {/* Gradient overlay for scroll indication */}
    </div>
  );
}

/* eslint-disable */
"use client"

import { useState, useEffect } from "react"
import { Skeleton } from "@/components/ui/skeleton"
import useEmblaCarousel from "embla-carousel-react"
import { Chip } from "@/components/ui/chip"
import { Carousel, CarouselContent, CarouselNext, CarouselPrevious } from "@/components/ui/carousel"

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
]

export function ChipsCarousel() {
  const [selectedCategory, setSelectedCategory] = useState("All")
  const [emblaRef] = useEmblaCarousel({ align: "start", loop: false })
  const [isLoading, setIsLoading] = useState(true)

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false)
    }, 2000)
    return () => clearTimeout(timer)
  }, [])

  if (isLoading) {
    return (
      <div className="w-full mb-6">
        <div className="flex justify-between items-center mb-4">
          <Skeleton className="h-6 w-20" />
          <div className="flex space-x-2">
            <Skeleton className="h-8 w-8 rounded-full" />
            <Skeleton className="h-8 w-8 rounded-full" />
          </div>
        </div>
        <div className="overflow-hidden">
          <div className="flex gap-2">
            {Array.from({ length: 10 }).map((_, index) => (
              <Skeleton key={index} className="h-8 w-20 rounded-full flex-shrink-0" />
            ))}
          </div>
        </div>
      </div>
    )
  }

  return (
    <div className="w-full mb-6 mr-36 relative">
      <Carousel className="w-full">
        <h2 className="text-xl font-semibold mb-4 text-gray-400">Genres</h2>
        <div className="absolute top-0 right-12">
          <CarouselPrevious className="hidden md:flex" />
          <CarouselNext className="hidden md:flex" />
        </div>
        <CarouselContent ref={emblaRef} className="-ml-2">
          {categories.map((category) => (
            <div key={category.id} className="pl-2 flex-shrink-0">
              <Chip
                label={category.label}
                selected={selectedCategory === category.label}
                onClick={() => setSelectedCategory(category.label)}
              />
            </div>
          ))}
        </CarouselContent>
      </Carousel>
    </div>
  )
}













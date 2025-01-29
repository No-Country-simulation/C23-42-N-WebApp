import { Skeleton } from "@/components/ui/skeleton"

export function ChipsCarouselSkeleton() {
  return (
    <div className="flex space-x-2 overflow-x-auto py-2">
      {[...Array(8)].map((_, i) => (
        <Skeleton key={i} className="h-8 w-20 rounded-full" />
      ))}
    </div>
  )
}


import { Skeleton } from "@/components/ui/skeleton"

export function ArtistGridSkeleton() {
  return (
    <div className="grid grid-cols-2 gap-4 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5">
      {[...Array(10)].map((_, i) => (
        <div key={i} className="flex flex-col items-center space-y-2">
          <Skeleton className="h-32 w-32 rounded-full" />
          <Skeleton className="h-4 w-24" />
          <Skeleton className="h-3 w-16" />
        </div>
      ))}
    </div>
  )
}


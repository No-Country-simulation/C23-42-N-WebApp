import { Skeleton } from "@/components/ui/skeleton"

export function PlaylistItemSkeleton() {
  return (
    <div className="flex items-center space-x-4 p-2">
      <Skeleton className="h-10 w-10 rounded" />
      <div className="flex-1">
        <Skeleton className="h-4 w-32 mb-1" />
        <Skeleton className="h-3 w-24" />
      </div>
    </div>
  )
}


import { Skeleton } from "@/components/ui/skeleton"

export function PlayerSkeleton() {
  return (
    <div className="flex items-center space-x-4 p-4">
      <Skeleton className="h-16 w-16 rounded" />
      <div className="flex-1">
        <Skeleton className="h-4 w-32 mb-2" />
        <Skeleton className="h-3 w-24" />
      </div>
      <Skeleton className="h-8 w-8 rounded-full" />
      <Skeleton className="h-8 w-8 rounded-full" />
      <Skeleton className="h-8 w-8 rounded-full" />
    </div>
  )
}


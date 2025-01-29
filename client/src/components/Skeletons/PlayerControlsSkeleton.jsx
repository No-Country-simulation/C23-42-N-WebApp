import { Skeleton } from "@/components/ui/skeleton"

export function PlayerControlsSkeleton() {
  return (
    <div className="flex items-center justify-center space-x-4">
      <Skeleton className="h-10 w-10 rounded-full" />
      <Skeleton className="h-12 w-12 rounded-full" />
      <Skeleton className="h-10 w-10 rounded-full" />
    </div>
  )
}


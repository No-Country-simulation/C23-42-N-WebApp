import { Skeleton } from "@/components/ui/skeleton"

export function HeaderSkeleton() {
  return (
    <div className="flex items-center justify-between p-4">
      <Skeleton className="h-8 w-32" />
      <div className="flex items-center space-x-4">
        <Skeleton className="h-8 w-8 rounded-full" />
        <Skeleton className="h-6 w-24" />
      </div>
    </div>
  )
}


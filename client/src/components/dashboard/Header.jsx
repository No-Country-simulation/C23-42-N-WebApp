import { useState, useEffect } from "react"
import { useUserStore } from "@/store/useUserStore"
import Avatar from "react-avatar"
import { Skeleton } from "@/components/ui/skeleton"
import { Input } from "@/components/ui/input"
import { Search } from "lucide-react"

export function Header() {
  const { user } = useUserStore()
  const [isLoading, setIsLoading] = useState(true)

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false)
    }, 2000) // Simula una carga de 2 segundos

    return () => clearTimeout(timer)
  }, [])

  return (
    <header className="sticky top-0 bg-background/95 p-4 backdrop-blur-md">
      <div className="max-w-4xl mx-auto flex flex-col sm:flex-row items-center gap-4">
        <div className="w-full flex-grow relative">
          {isLoading ? (
            <Skeleton className="h-10 sm:h-12 w-full rounded-xl" />
          ) : (
            <div className="relative">
              <Input
                type="search"
                placeholder="Search for a song"
                className="h-10 sm:h-12 pl-10 pr-4 rounded-xl bg-secondary/50 border-0 placeholder:text-muted-foreground/60 w-full text-sm sm:text-base"
              />
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 sm:h-5 sm:w-5 text-muted-foreground/60" />
            </div>
          )}
        </div>
        <div className="flex items-center gap-4">
          {isLoading ? (
            <Skeleton className="h-14 w-14 rounded-full shrink-0" />
          ) : (
            <Avatar name={user?.username} size="60" round={true} color="#FF5722" className="shrink-0" />
          )}
          <div className="flex flex-col">
            {isLoading ? (
              <>
                <Skeleton className="h-4 w-24 rounded-md mb-1" />
                <Skeleton className="h-3 w-20 rounded-md" />
              </>
            ) : (
              <>
                <span className="text-gray-500 text-[14px] font-semibold capitalize">{user?.username}</span>
                <span className="text-gray-500 text-[13px]">1,2k Followers</span>
              </>
            )}
          </div>
        </div>
      </div>
    </header>
  )
}









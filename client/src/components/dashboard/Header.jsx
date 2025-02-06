import { useState, useEffect } from "react"
import { useUserStore } from "@/store/useUserStore"
import Avatar from "react-avatar"
import { Skeleton } from "@/components/ui/skeleton"
import { Input } from "@/components/ui/input"
import { Search } from 'lucide-react'
import { artists } from "@/lib/artists"

export function Header() {
  const { user } = useUserStore()
  const [isLoading, setIsLoading] = useState(true)
  const [searchTerm, setSearchTerm] = useState("")
  const [searchResults, setSearchResults] = useState([])
  const [showResults, setShowResults] = useState(false)

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false)
    }, 2000)

    return () => clearTimeout(timer)
  }, [])

  useEffect(() => {
    if (searchTerm) {
      const results = artists.filter(artist =>
        artist.name.toLowerCase().includes(searchTerm.toLowerCase())
      )
      setSearchResults(results)
      setShowResults(true)
    } else {
      setSearchResults([])
      setShowResults(false)
    }
  }, [searchTerm])

  const handleSearch = (e) => {
    setSearchTerm(e.target.value)
  }

  return (
    <header className="sticky top-0 bg-background/95 p-4 backdrop-blur-md z-50">
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
                value={searchTerm}
                onChange={handleSearch}
              />
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 sm:h-5 sm:w-5 text-muted-foreground/60" />
              
              {/* Dropdown de resultados */}
              {showResults && searchTerm && (
                <div className="absolute top-full left-0 right-0 mt-2 bg-background/95 rounded-xl shadow-lg backdrop-blur-md border border-border">
                  {searchResults.length > 0 ? (
                    <div className="max-h-[60vh] overflow-y-auto py-2">
                      {searchResults.map(artist => (
                        <div 
                          key={artist.name}
                          className="flex items-center gap-3 p-3 hover:bg-secondary/50 cursor-pointer"
                        >
                          <img 
                            src={artist.image || "/placeholder.svg"}
                            alt={artist.name}
                            className="w-12 h-12 rounded-full object-cover"
                          />
                          <div>
                            <p className="font-medium text-foreground">{artist.name}</p>
                            <p className="text-sm text-muted-foreground">{artist.followers}</p>
                          </div>
                        </div>
                      ))}
                    </div>
                  ) : (
                    <div className="flex flex-col items-center justify-center py-16">
                      <div className="w-24 h-24 flex items-center justify-center text-[#E67E22]">
                        <Search className="w-full h-full" />
                      </div>
                      <h2 className="text-xl font-semibold text-foreground mt-4">No results found</h2>
                      <p className="text-muted-foreground mt-2">Try searching for a different artist</p>
                    </div>
                  )}
                </div>
              )}
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









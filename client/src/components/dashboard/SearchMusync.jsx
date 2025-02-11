import { useState, useEffect } from "react"
import { Search } from "lucide-react"
import { Input } from "@/components/ui/input"
import { Skeleton } from "@/components/ui/skeleton"

export default function SearchMusync() {
  const [isLoading, setIsLoading] = useState(true)
  const [searchTerm, setSearchTerm] = useState("")
  const [searchResults, setSearchResults] = useState([])

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false)
    }, 1000)

    return () => clearTimeout(timer)
  }, [])

  useEffect(() => {
    if (searchTerm) {
      fetchArtists(searchTerm)
    } else {
      setSearchResults([])
    }
  }, [searchTerm])

  const fetchArtists = async (term) => {
    try {
      const response = await fetch(`/api/search?term=${encodeURIComponent(term)}`)
      const data = await response.json()
      setSearchResults(data)
    } catch (error) {
      console.error("Error fetching artists:", error)
      setSearchResults([])
    }
  }

  const handleSearch = (e) => {
    setSearchTerm(e.target.value)
  }

  return (
    <div className="flex flex-col min-h-screen bg-white">
      <div className="w-full px-4 sm:px-6 lg:px-8 py-4">
        <div className="relative w-full max-w-xl mx-auto">
          {isLoading ? (
            <Skeleton className="h-10 sm:h-12 w-full rounded-xl" />
          ) : (
            <div className="relative">
              <Input
                type="search"
                placeholder="Search for an artist"
                className="h-10 sm:h-12 pl-10 pr-4 rounded-xl bg-secondary border-0 placeholder:text-gray-400 w-full text-sm sm:text-base focus:ring-[#3E8B7E] focus:ring-2"
                value={searchTerm}
                onChange={handleSearch}
              />
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 sm:h-5 sm:w-5 text-gray-400" />
            </div>
          )}
        </div>
      </div>

      {!isLoading && (
        <div className="flex-1 w-full">
          {searchResults.length > 0 ? (
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6 p-8">
              {searchResults.map((artist) => (
                <div
                  key={artist.id}
                  className="bg-[#1E1E1E] rounded-xl overflow-hidden hover:bg-[#2A2A2A] transition-colors"
                >
                  <img
                    src={artist.image || "/placeholder.svg"}
                    alt={artist.name}
                    className="w-full h-48 object-cover"
                  />
                  <div className="p-4">
                    <h3 className="text-lg font-semibold text-white">{artist.name}</h3>
                    <p className="text-gray-400">{artist.followers} followers</p>
                  </div>
                </div>
              ))}
            </div>
          ) : (
            <div className="flex flex-col items-center justify-center h-[calc(100vh-200px)]">
              <div className="flex flex-col items-center gap-6">
                <div className="w-32 h-32 flex items-center justify-center">
                  <Search className="w-full h-full text-[#E67E22]" />
                </div>
                <div className="text-center">
                  <h2 className="text-2xl font-semibold text-white mb-2">No results found</h2>
                  <p className="text-gray-400 text-lg">Try searching for a different artist</p>
                </div>
              </div>
            </div>
          )}
        </div>
      )}
    </div>
  )
}
















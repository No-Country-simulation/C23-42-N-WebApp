import { useState, useEffect } from "react"
import { Search } from "lucide-react"
import { Input } from "@/components/ui/input"
import { artists } from "@/lib/artists"

export function Header() {
  const [searchTerm, setSearchTerm] = useState("")
  const [searchResults, setSearchResults] = useState([])
  const [showResults, setShowResults] = useState(false)

  useEffect(() => {
    if (searchTerm) {
      const results = artists.filter((artist) => artist.name.toLowerCase().includes(searchTerm.toLowerCase()))
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
    <header className="w-full bg-white px-4 py-3 fixed top-0 z-50">
      <div className="flex items-center justify-between max-w-7xl mx-auto">
       

        <div className="relative w-full max-w-md mx-4">
          <Input
            type="search"
            placeholder="Search for a song"
            className="h-10 pl-10 pr-4 rounded-xl bg-white border-0 placeholder:text-gray-400 w-full text-sm focus:ring-[#3E8B7E] focus:ring-2"
            value={searchTerm}
            onChange={handleSearch}
          />
          <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-gray-400" />

          {/* Results dropdown */}
          {showResults && searchTerm && (
            <div className="absolute top-full left-0 right-0 mt-2 bg-[#2A2A2A] rounded-xl shadow-lg overflow-hidden">
              {searchResults.length > 0 ? (
                <div className="max-h-96 overflow-y-auto">
                  {searchResults.map((artist) => (
                    <div key={artist.name} className="flex items-center gap-3 p-3 hover:bg-[#3E8B7E]/10 cursor-pointer">
                      <img
                        src={artist.image || "/placeholder.svg"}
                        alt={artist.name}
                        className="w-10 h-10 rounded-full object-cover"
                      />
                      <div>
                        <p className="text-white font-medium">{artist.name}</p>
                        <p className="text-gray-400 text-sm">{artist.followers} followers</p>
                      </div>
                    </div>
                  ))}
                </div>
              ) : (
                <div className="p-4 text-center">
                  <p className="text-gray-400">No results found</p>
                </div>
              )}
            </div>
          )}
        </div>

        <div className="flex items-center gap-4">
          <div className="flex items-center gap-2">
            <div className="w-8 h-8 rounded-full bg-[#E67E22] flex items-center justify-center text-white">S</div>
            <div className="hidden sm:block">
              <p className="text-white">Seven</p>
              <p className="text-gray-400 text-sm">1.2k Followers</p>
            </div>
          </div>
        </div>
      </div>
    </header>
  )
}











import { ArtistCard } from '@/components/ui/ArtistCard';

// Sample data
const artists = [
  {
    name: "Taylor Swift",
    image: "/placeholder.svg?height=400&width=400",
    followers: "100M"
  },
  {
    name: "Bad Bunny",
    image: "/placeholder.svg?height=400&width=400",
    followers: "80M"
  },
  {
    name: "The Weeknd",
    image: "/placeholder.svg?height=400&width=400",
    followers: "75M"
  },
  {
    name: "Drake",
    image: "/placeholder.svg?height=400&width=400",
    followers: "70M"
  },
  {
    name: "Ed Sheeran",
    image: "/placeholder.svg?height=400&width=400",
    followers: "95M"
  },
  {
    name: "Ariana Grande",
    image: "/placeholder.svg?height=400&width=400",
    followers: "85M"
  }
]

export function ArtistGrid() {
  return (
    <div className="grid grid-cols-2 gap-4 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5">
      {artists.map((artist, index) => (
        <ArtistCard key={index} {...artist} />
      ))}
    </div>
  )
}
import { ArtistCard } from '@/components/ui/ArtistCard';

// Sample data
const artists = [
  {
    name: "Taylor Swift",
    image: "/images/Taylor.jpg",
    followers: "100M"
  },
  {
    name: "Bad Bunny",
    image: "/images/Bad bunny.PNG",
    followers: "80M"
  },
  {
    name: "The Weeknd",
    image: "/images/the weeknd.png",
    followers: "75M"
  },
  {
    name: "Drake",
    image: "/images/drake.jpg",
    followers: "70M"
  },
  {
    name: "Ed Sheeran",
    image: "/images/ed sheeran.jpg",
    followers: "95M"
  },
  {
    name: "Ariana Grande",
    image: "/images/ariana grande.jpg",
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
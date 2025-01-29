import { ArtistGridSkeleton } from "./ArtistGridSkeleton"
import { ChipsCarouselSkeleton } from "./ChipsCarouselSkeleton"
import { HeaderSkeleton } from "./HeaderSkeleton"
import { PlayerSkeleton } from "./PlayerSkeleton"
import { PlayerControlsSkeleton } from "./PlayerControlsSkeleton"
import { PlaylistItemSkeleton } from "./PlaylistItemSkeleton"
import { SearchMusyncSkeleton } from "./SearchMusyncSkeleton"

export function DashboardSkeleton() {
  return (
    <div className="flex h-screen bg-background">
      {/* Sidebar */}
      <div className="w-64 bg-card p-4">
        <SearchMusyncSkeleton />
        <div className="mt-4 space-y-2">
          {[...Array(5)].map((_, i) => (
            <PlaylistItemSkeleton key={i} />
          ))}
        </div>
      </div>

      {/* Main content */}
      <div className="flex-1 flex flex-col">
        <HeaderSkeleton />
        <div className="flex-1 overflow-auto p-4">
          <ChipsCarouselSkeleton />
          <div className="mt-6">
            <ArtistGridSkeleton />
          </div>
        </div>
        <div className="bg-card p-4">
          <PlayerSkeleton />
          <PlayerControlsSkeleton />
        </div>
      </div>
    </div>
  )
}


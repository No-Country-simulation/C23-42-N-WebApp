import { useState, useEffect } from "react"
import { DashboardSkeleton } from "@/components/skeletons/DashboardSkeleton"
import { ArtistGrid } from "@/components/dashboard/ArtistGrid"
import { ChipsCarousel } from "@/components/dashboard/ChipsCarousel"
import { Header } from "@/components/dashboard/Header"
import { Player } from "@/components/dashboard/Player"
import { PlayerControls } from "@/components/dashboard/PlayerControls"
import { SearchMusync } from "@/components/dashboard/SearchMusync"

export function Dashboard() {
  const [isLoading, setIsLoading] = useState(true)

  useEffect(() => {
    // Simula una carga de datos
    const timer = setTimeout(() => {
      setIsLoading(false)
    }, 2000)

    return () => clearTimeout(timer)
  }, [])

  if (isLoading) {
    return <DashboardSkeleton />
  }

  return (
    <div className="flex h-screen bg-background">
      {/* Sidebar */}
      <div className="w-64 bg-card p-4">
        <SearchMusync />
        {/* Aquí irían los PlaylistItems */}
      </div>

      {/* Main content */}
      <div className="flex-1 flex flex-col">
        <Header />
        <div className="flex-1 overflow-auto p-4">
          <ChipsCarousel />
          <div className="mt-6">
            <ArtistGrid />
          </div>
        </div>
        <div className="bg-card p-4">
          <Player />
          <PlayerControls />
        </div>
      </div>
    </div>
  )
}


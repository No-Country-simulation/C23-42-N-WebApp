/* eslint-disable */
import React, { useState, useEffect } from "react"
import { ArtistGrid } from "@/components/dashboard/ArtistGrid"
import { Skeleton } from "@/components/ui/Skeleton" // Asegúrate de tener este componente

export const Home = () => {
  const [isLoading, setIsLoading] = useState(true)

  useEffect(() => {
    const timer = setTimeout(() => {
      setIsLoading(false)
    }, 2000)

    return () => clearTimeout(timer)
  }, [])

  return (
    <div className="p-6">
      <div className="mb-8">
        <h2 className="text-2xl font-semibold mb-4">Artistas Populares</h2>
        {isLoading ? <Skeleton /> : <ArtistGrid />}
      </div>
    </div>
  )
}



import React, { useState, useEffect } from "react"
import { Skeleton } from "@/components/ui/skeleton" // Asegúrate de que el path es correcto

export const Feed = () => {
  const [isLoading, setIsLoading] = useState(true)

  useEffect(() => {
    // Simula una carga de datos de 2 segundos
    const timer = setTimeout(() => {
      setIsLoading(false)
    }, 2000)

    return () => clearTimeout(timer)
  }, [])

  return (
    <div className="p-4">
      <h2 className="text-xl font-semibold mb-4">Últimas Noticias</h2>

      {isLoading ? (
        // 🔹 Mientras isLoading es true, mostramos Skeletons
        <div className="space-y-4">
          <Skeleton className="h-20 w-full rounded-lg" />
          <Skeleton className="h-20 w-full rounded-lg" />
          <Skeleton className="h-20 w-full rounded-lg" />
        </div>
      ) : (
        // ✅ Contenido real cuando la carga termina
        <div>Feed</div>
      )}
    </div>
  )
}


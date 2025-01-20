
import { Link, useNavigate } from 'react-router-dom'
import { Home, Search, Library, Plus } from 'lucide-react'
import { ScrollArea } from "@/components/ui/scroll-area"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { PlaylistItem } from './PlaylistItem'
import { useState } from "react";

export function Sidebar() {
  const [searchQuery, setSearchQuery] = useState('')
  const navigate = useNavigate()

  const handleSearch = (e) => {
    e.preventDefault()
    // Aquí iría la lógica para manejar la búsqueda
    console.log('Buscando:', searchQuery)
    // Por ahora, simplemente navegamos a una página de resultados hipotética
    navigate(`/search?q=${encodeURIComponent(searchQuery)}`)
  }

  return (
    <aside className="flex w-[350px] flex-col gap-2 bg-card">
      {/* Main navigation */}
      <div className="p-6">
        <div className="flex items-center gap-2 px-2 mb-6">
          {/* Imagen del logo */}
          <img 
            src="/images/musync1_720.jpg" 
            alt="Musync Logo" 
            className="w-40 h-30 object-cover rounded-full"
          />
        </div>
        
        <nav className="space-y-2">
          <Link 
            to="/login" 
            className="flex items-center gap-4 rounded-lg px-4 py-3 text-muted-foreground transition-colors hover:text-foreground hover:bg-orange-100/10"
          >
            <Home className="size-6" />
            Inicio
          </Link>
          <form onSubmit={handleSearch} className="flex items-center gap-4 rounded-lg px-4 py-3">
            <Search className="size-6 text-muted-foreground" />
            <Input
              type="search"
              placeholder="Buscar artista o canción..."
              className="flex-grow"
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
            />
            <Button type="submit" size="sm" variant="ghost">
              Buscar
            </Button>
          </form>
        </nav>
      </div>

      {/* Library section */}
      <div className="flex-1 bg-card/50 px-3">
        <div className="flex items-center gap-4 px-3 py-4">
          <div className="flex items-center gap-2">
            <Library className="size-6" />
            <span className="font-semibold">Tu Biblioteca</span>
          </div>
          <div className="ml-auto flex items-center gap-2">
            <button className="rounded-full p-2 hover:bg-orange-100/10">
              <Plus className="size-5" />
            </button>
          </div>
        </div>

        {/* Playlists */}
        <ScrollArea className="h-[calc(100vh-300px)]">
          <div className="space-y-1 p-2">
            {Array.from({ length: 50 }).map((_, i) => (
              <PlaylistItem 
                key={i}
                title={`Mi Playlist #${i + 1}`}
                type="Playlist"
                owner="Usuario"
              />
            ))}
          </div>
        </ScrollArea>
      </div>
    </aside>
  )
}




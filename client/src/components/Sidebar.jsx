import { Home, Search, Library, Plus } from 'lucide-react'
import { ScrollArea } from "@/components/ui/scroll-area"
import { PlaylistItem } from './PlaylistItem'
import { Link } from 'react-router-dom'
export function Sidebar() {
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
          <a 
            href="#" 
            className="flex items-center gap-4 rounded-lg px-4 py-3 text-muted-foreground transition-colors hover:text-foreground hover:bg-orange-100/10"
          >
          
          <Link 
            to="/login" 
            className="flex items-center gap-4 rounded-lg px-4 py-3 text-muted-foreground transition-colors hover:text-foreground hover:bg-orange-100/10"
          >
            <Home className="size-6" />
            Inicio
          </Link>
            <Search className="size-6" />
            Buscar
          </a>
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


import { Home, Search, Library } from 'lucide-react'
import { Button } from "@/components/ui/button"
import { ScrollArea } from "@/components/ui/scroll-area"

export default function Sidebar() {
  return (
    <div className="w-64 bg-card text-card-foreground flex flex-col h-full">
      <div className="p-6">
        <h1 className="text-2xl font-bold mb-6">Musync</h1>
        <nav className="space-y-4">
          <Button variant="ghost" className="w-full justify-start">
            <Home className="mr-2 h-4 w-4" />
            Inicio
          </Button>
          <Button variant="ghost" className="w-full justify-start">
            <Search className="mr-2 h-4 w-4" />
            Buscar
          </Button>
          <Button variant="ghost" className="w-full justify-start">
            <Library className="mr-2 h-4 w-4" />
            Tu Biblioteca
          </Button>
        </nav>
      </div>
      <ScrollArea className="flex-1 px-6">
        <div className="space-y-4">
          <h2 className="text-lg font-semibold">Tus Playlists</h2>
          {/* Aquí puedes agregar una lista de playlists */}
          <ul className="space-y-2">
            <li><a href="#" className="hover:underline">Playlist 1</a></li>
            <li><a href="#" className="hover:underline">Playlist 2</a></li>
            <li><a href="#" className="hover:underline">Playlist 3</a></li>
          </ul>
        </div>
      </ScrollArea>
    </div>
  )
}


import { Slider } from "@/components/ui/slider"
import { Button } from "@/components/ui/button"
import { Play, SkipBack, SkipForward, Volume2 } from 'lucide-react'

export default function Player() {
  return (
    <div className="fixed bottom-0 left-0 right-0 bg-card border-t border-border h-20 px-4 flex items-center">
      <div className="w-1/3">
        {/* Información de la canción actual */}
        <p className="font-medium">Nombre de la canción</p>
        <p className="text-sm text-muted-foreground">Artista</p>
      </div>
      <div className="w-1/3 flex flex-col items-center">
        <div className="flex items-center mb-2">
          <Button variant="ghost" size="icon">
            <SkipBack className="h-4 w-4" />
          </Button>
          <Button variant="ghost" size="icon" className="mx-2">
            <Play className="h-6 w-6" />
          </Button>
          <Button variant="ghost" size="icon">
            <SkipForward className="h-4 w-4" />
          </Button>
        </div>
        <Slider className="w-full" defaultValue={[33]} max={100} step={1} />
      </div>
      <div className="w-1/3 flex justify-end items-center">
        <Volume2 className="h-4 w-4 mr-2" />
        <Slider className="w-1/3" defaultValue={[66]} max={100} step={1} />
      </div>
    </div>
  )
}


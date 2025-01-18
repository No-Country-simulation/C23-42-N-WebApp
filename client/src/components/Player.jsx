import { Heart } from 'lucide-react'

export function Player() {
  return (
    <div className="fixed bottom-0 left-0 right-0 h-20 border-t bg-background/95 backdrop-blur-sm">
      <div className="flex h-full items-center justify-between px-4">
        <div className="flex items-center gap-4">
          <div className="size-14 rounded-md bg-muted" />
          <div>
            <h3 className="font-medium">Nombre de la canción</h3>
            <p className="text-sm text-muted-foreground">Artista</p>
          </div>
          <button className="ml-4">
            <Heart className="size-5 text-muted-foreground hover:text-[#FF5722]" />
          </button>
        </div>
        
        {/* Player controls */}
        <div className="flex flex-col items-center gap-2 max-w-2xl w-full">
          <div className="flex items-center justify-center gap-6">
            <div className="h-1 w-full rounded-full bg-muted">
              <div className="h-full w-1/3 rounded-full bg-[#FF5722]" />
            </div>
          </div>
        </div>
        
        {/* Volume control */}
        <div className="flex items-center gap-4">
          <div className="h-1 w-24 rounded-full bg-muted">
            <div className="h-full w-1/2 rounded-full bg-[#FF5722]" />
          </div>
        </div>
      </div>
    </div>
  )
}


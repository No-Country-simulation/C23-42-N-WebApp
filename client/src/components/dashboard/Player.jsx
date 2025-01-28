import PlayerControls from "./PlayerControls";

export function Player() {
  return (
    <div className="fixed bottom-0 left-0 right-0 h-20 border-t bg-background/95 backdrop-blur-sm">
      <div className="flex h-full items-center justify-between px-4 gap-10">
        <div className="flex items-center gap-2 justify-center w-[350px]">
          <div className="w-12 h-12 rounded-full bg-gray-300" />
          <div>
            <h3 className="font-semibold text-[14px] text-gray-500">
              Nombre de la canción
            </h3>
            <p className="text-[13px] text-muted-foreground">Artista</p>
          </div>
        </div>

        <PlayerControls />
      </div>
    </div>
  );
}

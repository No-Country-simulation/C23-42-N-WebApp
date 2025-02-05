import { useState, useRef, useEffect } from "react"
import { Slider } from "@/components/ui/slider"
import { Button } from "@/components/ui/button"
import { Play, Pause, SkipBack, SkipForward, Heart, Repeat, Shuffle, Volume2 } from "lucide-react"

// Asume que estas son las URLs de tu canción de prueba
const TEST_SONG_URL = "https://console.minio.icu/audio/Lady%20Gaga%20-%20Judas%20(Audio).mp3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250203%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250203T224545Z&X-Amz-Expires=259200&X-Amz-SignedHeaders=host&X-Amz-Signature=f1b084b5ee2a7d08a2a3cd890b2ef41743563503ee89f9df8569319ffa96ee59"

export function PlayerControls() {
  const [isPlaying, setIsPlaying] = useState(false)
  const [currentTime, setCurrentTime] = useState(0)
  const [duration, setDuration] = useState(0)
  const [volume, setVolume] = useState(1)
  const audioRef = useRef(null)

  useEffect(() => {
    if (audioRef.current) {
      audioRef.current.volume = volume
    }
  }, [volume])

  const togglePlayPause = () => {
    if (isPlaying) {
      audioRef.current.pause()
    } else {
      audioRef.current.play()
    }
    setIsPlaying(!isPlaying)
  }

  const handleTimeUpdate = () => {
    setCurrentTime(audioRef.current.currentTime)
  }

  const handleLoadedMetadata = () => {
    setDuration(audioRef.current.duration)
  }

  const handleSeek = (newValue) => {
    const [newTime] = newValue
    audioRef.current.currentTime = newTime
    setCurrentTime(newTime)
  }

  const formatTime = (time) => {
    const minutes = Math.floor(time / 60)
    const seconds = Math.floor(time % 60)
    return `${minutes}:${seconds.toString().padStart(2, "0")}`
  }

  return (
    <div className="fixed bottom-0 left-0 right-0 bg-background border-t border-border h-[72px] flex items-center px-4">
      <div className="w-full max-w-7xl mx-auto grid grid-cols-[auto,1fr,auto] items-center gap-4">
        {/* Song Info */}
        <div className="flex items-center gap-3">
          <div className="w-10 h-10 bg-muted rounded-full overflow-hidden">
            <img src=" https://console.minio.icu/images/lady-gaga.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250203%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250203T225016Z&X-Amz-Expires=259200&X-Amz-SignedHeaders=host&X-Amz-Signature=edc0f5f31250896285e6ca67d842f8d66af8000d878716be1f7dbfbb54f01757" alt="Song cover" className="w-full h-full object-cover" />
          </div>
          <div>
            <h3 className="text-sm font-medium text-foreground">Nombre de la canción</h3>
            <p className="text-xs text-muted-foreground">Artista</p>
          </div>
        </div>

        {/* Player Controls & Progress */}
        <div className="flex flex-col items-center gap-1 px-4">
          <div className="flex items-center gap-4">
            <Button variant="ghost" size="icon" className="h-8 w-8">
              <SkipBack className="h-4 w-4" />
            </Button>
            <Button variant="ghost" size="icon" onClick={togglePlayPause} className="h-8 w-8">
              {isPlaying ? <Pause className="h-4 w-4" /> : <Play className="h-4 w-4" />}
            </Button>
            <Button variant="ghost" size="icon" className="h-8 w-8">
              <SkipForward className="h-4 w-4" />
            </Button>
          </div>
          <div className="flex items-center w-full gap-2">
            <span className="text-xs text-muted-foreground min-w-[40px] text-right">{formatTime(currentTime)}</span>
            <Slider value={[currentTime]} max={duration} step={1} className="flex-1" onValueChange={handleSeek} />
            <span className="text-xs text-muted-foreground min-w-[40px]">{formatTime(duration)}</span>
          </div>
        </div>

        {/* Additional Controls */}
        <div className="flex items-center gap-2">
          <Button variant="ghost" size="icon" className="h-8 w-8">
            <Heart className="h-4 w-4" />
          </Button>
          <Button variant="ghost" size="icon" className="h-8 w-8">
            <Shuffle className="h-4 w-4" />
          </Button>
          <Button variant="ghost" size="icon" className="h-8 w-8">
            <Repeat className="h-4 w-4" />
          </Button>
          <div className="flex items-center gap-2">
            <Volume2 className="h-4 w-4 text-muted-foreground" />
            <Slider
              value={[volume * 100]}
              max={100}
              step={1}
              className="w-[80px]"
              onValueChange={(newValue) => setVolume(newValue[0] / 100)}
            />
          </div>
        </div>
      </div>

      <audio
        ref={audioRef}
        src={TEST_SONG_URL}
        onTimeUpdate={handleTimeUpdate}
        onLoadedMetadata={handleLoadedMetadata}
      />
    </div>
  )
}





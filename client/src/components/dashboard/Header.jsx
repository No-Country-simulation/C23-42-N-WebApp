import { Github, Twitter, Instagram } from 'lucide-react'

export function Header() {
  return (
    <header className="sticky top-0 flex items-center justify-between bg-background/95 p-6 backdrop-blur-md">
      <h1 className="text-2xl font-bold">Bienvenido a Musync</h1>
      <div className="flex items-center gap-4">
        <a 
          href="#" 
          className="text-muted-foreground hover:text-[#FF5722] transition-colors"
          aria-label="Twitter"
        >
          <Twitter className="size-5" />
        </a>
        <a 
          href="#" 
          className="text-muted-foreground hover:text-[#FF5722] transition-colors"
          aria-label="Instagram"
        >
          <Instagram className="size-5" />
        </a>
        <a 
          href="#" 
          className="text-muted-foreground hover:text-[#FF5722] transition-colors"
          aria-label="Github"
        >
          <Github className="size-5" />
        </a>
      </div>
    </header>
  )
}


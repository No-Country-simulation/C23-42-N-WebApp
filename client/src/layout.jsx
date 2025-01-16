import './globals.css'
import { Inter } from 'next/font/google'
import Sidebar from './components/Sidebar'
import Player from './components/Player'

const inter = Inter({ subsets: ['latin'] })

export const metadata = {
  title: 'Musync - Tu app de música',
  description: 'Una aplicación de música inspirada en Spotify',
}

export default function RootLayout({ children }) {
  return (
    <html lang="es">
      <body className={inter.className}>
        <div className="flex h-screen bg-background">
          <Sidebar />
          <main className="flex-1 overflow-y-auto">
            {children}
          </main>
        </div>
        <Player />
      </body>
    </html>
  )
}


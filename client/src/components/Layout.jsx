import { Sidebar } from './Sidebar'
import { Player } from './Player'
import { MainContent } from './MainContent'


export function Layout({ children }) {
  return (
    <div className="h-screen bg-background overflow-hidden">
      <div className="flex h-[calc(100%-80px)]">
        <Sidebar />
        <MainContent>{children}</MainContent>
      </div>
      <Player />
    </div>
  )
}


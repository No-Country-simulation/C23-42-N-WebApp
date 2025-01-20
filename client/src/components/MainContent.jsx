import { Header } from './Header'
import { ScrollArea } from "@/components/ui/scroll-area"
import { ArtistGrid } from './ArtistGrid'
import PropTypes from 'prop-types';

export function MainContent({ children }) {
  return (
    <main className="flex-1">
      <ScrollArea className="h-full">
        <Header />
        <div className="p-6">
          <div className="mb-8">
            <h2 className="text-2xl font-semibold mb-4">Artistas Populares</h2>
            <ArtistGrid />
          </div>
          {children}
        </div>
      </ScrollArea>
    </main>
  )
}
MainContent.propTypes = {
  children: PropTypes.node, // Valida que children sea cualquier nodo renderizable
};

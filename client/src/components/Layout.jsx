import { Sidebar } from './Sidebar'
import { Player } from './Player'
import { MainContent } from './MainContent'
import PropTypes from 'prop-types'

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
Layout.propTypes = {
  children: PropTypes.node.isRequired,  // Validación para los children
};

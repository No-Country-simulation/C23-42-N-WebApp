import { Card, CardContent } from "@/components/ui/card"
import { Play } from 'lucide-react'
import PropTypes from 'prop-types'

export function ArtistCard({ name, image, followers,children }) {
  return (
    <Card className="group relative overflow-hidden transition-all hover:bg-orange-100/10">
      <CardContent className="p-4">
        <div className="relative aspect-square w-full overflow-hidden rounded-md">
          <img
            src={image || "/placeholder.svg"}
            alt={name}
            className="object-cover w-full h-full transition-all group-hover:scale-105"
          />
          <button 
            className="absolute bottom-2 right-2 flex h-12 w-12 translate-y-4 items-center justify-center rounded-full bg-[#FF5722] opacity-0 shadow-lg transition-all group-hover:translate-y-0 group-hover:opacity-100"
            aria-label={`Reproducir música de ${name}`}
          >
            <Play className="ml-1 h-6 w-6 text-white" fill="white" />
          </button>
        </div>
        <div className="mt-4">
          <h3 className="font-semibold">{name}</h3>
          <p className="mt-1 text-sm text-muted-foreground">
            {followers} seguidores
          </p>
        </div>
        {children && <div>{children}</div>}
      </CardContent>
    </Card>
  )
}
ArtistCard.propTypes = {
  name: PropTypes.string.isRequired,
  image: PropTypes.string,
  followers: PropTypes.string.isRequired,
  children: PropTypes.node, // Validación opcional para los children
};

ArtistCard.defaultProps = {
  image: "/placeholder.svg",
};

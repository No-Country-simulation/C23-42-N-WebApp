export function PlaylistItem({ title, type, owner }) {
    return (
      <a
        href="#"
        className="flex items-center gap-3 rounded-md px-3 py-2 hover:bg-orange-100/10"
      >
        <div className="size-12 rounded bg-muted" />
        <div className="flex-1 truncate">
          <div className="font-medium">{title}</div>
          <div className="text-sm text-muted-foreground">{type} • {owner}</div>
        </div>
      </a>
    )
  }
  
  
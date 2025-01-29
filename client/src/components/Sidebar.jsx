import { NavLink, useNavigate } from "react-router-dom";
import { User, Home, Library, Plus, LogOut } from "lucide-react";
import { ScrollArea } from "@/components/ui/scroll-area";
import { PlaylistItem } from "./dashboard/PlaylistItem";
import { logoutUser } from "@/lib/logoutUser";

export function Sidebar() {
  // const [searchQuery, setSearchQuery] = useState("");
  // const navigate = useNavigate();

  // TODO:pròximamente ussado
  // const handleSearch = (e) => {
  //   e.preventDefault();
  //   console.log("Buscando:", searchQuery);
  //   navigate(`/search?q=${encodeURIComponent(searchQuery)}`);
  // };

  return (
    <aside className="flex w-[350px] flex-col gap-2 bg-card">
      <div className="px-6 pt-6">
        <div className="flex justify-center items-center mb-4">
          <img
            src="/images/logo-only-musync.svg"
            alt="Musync Logo"
            className="w-30 h-30"
          />

          <img
            src="/images/title-logo-musync.svg"
            alt="Musync Logo"
            className="w-30 h-30"
          />
        </div>

        <nav className="flex flex-col gap-1">
          <NavLink
            to="/"
            className={({ isActive }) =>
              `flex items-center gap-3 rounded-3xl px-4 py-3 text-muted-foreground transition-colors hover:bg-orangePrimary/30 ${isActive ? "bg-orangePrimary/10" : ""}`
            }
          >
            <Home className="size-6" />
            Home
          </NavLink>

          <NavLink
            to="/feed"
            className={({ isActive }) =>
              `flex items-center gap-3 rounded-3xl px-4 py-3 text-muted-foreground transition-colors hover:bg-orangePrimary/30 ${isActive ? "bg-orangePrimary/10" : ""}`
            }
          >
            <User className="size-6" />
            Feed
          </NavLink>
        </nav>
      </div>

      <div className="flex-1 bg-card/50 px-6">
        <div className="flex items-center gap-4 px-3 py-4">
          <div className="flex items-center gap-2">
            <Library className="size-6" />
            <span className="font-semibold">Tu Biblioteca</span>
          </div>
          <div className="ml-auto flex items-center gap-2">
            <button className="rounded-full p-2 hover:bg-orange-100/10">
              <Plus className="size-5" />
            </button>
          </div>
        </div>

        <ScrollArea className="h-[33vh]">
          <div className="space-y-1 p-2">
            {Array.from({ length: 50 }).map((_, i) => (
              <PlaylistItem
                key={i}
                title={`Mi Playlist #${i + 1}`}
                type="Playlist"
                owner="Usuario"
              />
            ))}
          </div>
        </ScrollArea>
      </div>

      <div className="mx-6 mb-2">
        <NavLink
          to="/login"
          className={({ isActive }) =>
            `flex items-center gap-3 rounded-3xl px-4 py-3 text-muted-foreground transition-colors hover:bg-orangePrimary/30 ${isActive ? "bg-orangePrimary/10" : ""}`
          }
          onClick={logoutUser}
        >
          <LogOut className="size-6" />
          Logout
        </NavLink>
      </div>
    </aside>
  );
}

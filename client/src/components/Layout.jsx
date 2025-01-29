import { Sidebar } from "./Sidebar";
import { Player } from "./dashboard/Player";
import { ScrollArea } from "@radix-ui/react-scroll-area";
import { Header } from "./dashboard/Header";
import { Outlet } from "react-router-dom";
import { ChipsCarousel } from "./dashboard/ChipsCarousel";

export function Layout() {
  return (
    <div className="h-screen bg-background overflow-hidden">
      <div className="flex h-[calc(100%-80px)]">
        <Sidebar />
        <main className="flex-1">
          <ScrollArea className="h-full">
            <Header />
            <ChipsCarousel/>
            <Outlet />
          </ScrollArea>
        </main>
      </div>
      <Player />
    </div>
  );
}

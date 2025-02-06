
import { CarouselCards } from "./components/CarouselCards";
import { ScrollArea } from "@/components/ui/scroll-area";
import { artists } from "@/lib/artists";
import { ChipsCarousel } from "@/components/dashboard/ChipsCarousel";

export const Home = () => {
  return (
    
    <div className="my-6">
      <ChipsCarousel/>
      <ScrollArea className="h-[60vh]  rounded-md w-[95%] overflow-auto">
        <div className="mb-8">
          <div className="my-6">
            <CarouselCards artists={artists} gender="Songs" />
          </div>

          <div className="my-6">
            <CarouselCards artists={artists} gender="Artists" />
          </div>
        </div>
      </ScrollArea>
    </div>
  );
};

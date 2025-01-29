import { SearchIcon } from "lucide-react";
import { Input } from "@/components/ui/input";

export default function SearchMusync() {
  return (
    <div className="relative w-full max-w-xl">
      <Input
        type="search"
        placeholder="Search for a song"
        className="h-12 pl-4 pr-10 rounded-xl bg-secondary/50 border-0 placeholder:text-muted-foreground/60"
      />
      <SearchIcon className="absolute right-3 top-1/2 -translate-y-1/2 h-5 w-5 text-muted-foreground/60" />
    </div>
  );
}

import { ArtistGrid } from "@/components/dashboard/ArtistGrid";

export const Home = () => {
  return (
    <div className="p-6">
      <div className="mb-8">
        <h2 className="text-2xl font-semibold mb-4">Artistas Populares</h2>
        <ArtistGrid />
      </div>
    </div>
  );
};

import React from "react";
import { ArtistGrid } from "./components/ArtistGrid";
import { GradientCard } from ".";

export const Home = () => {
  return (
    <div className="p-6">
      <div className="mb-8">
        <h2 className="text-xl font-semibold mb-4 text-gray-400">Songs</h2>
        <ArtistGrid />
        <GradientCard />
      </div>
    </div>
  );
};

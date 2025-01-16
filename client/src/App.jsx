import "./App.css";

import { useStore } from "./store/useExampleStore.js";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"

  function Home() {
  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold mb-6">Bienvenido a Musync</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        <Card>
          <CardHeader>
            <CardTitle>Playlists recomendadas</CardTitle>
          </CardHeader>
          <CardContent>
            <ul className="list-disc list-inside">
              <li>Top Hits 2023</li>
              <li>Chill Vibes</li>
              <li>Workout Mix</li>
            </ul>
          </CardContent>
        </Card>
        <Card>
          <CardHeader>
            <CardTitle>Artistas populares</CardTitle>
          </CardHeader>
          <CardContent>
            <ul className="list-disc list-inside">
              <li>Artista 1</li>
              <li>Artista 2</li>
              <li>Artista 3</li>
            </ul>
          </CardContent>
        </Card>
        <Card>
          <CardHeader>
            <CardTitle>Géneros destacados</CardTitle>
          </CardHeader>
          <CardContent>
            <ul className="list-disc list-inside">
              <li>Pop</li>
              <li>Rock</li>
              <li>Hip Hop</li>
            </ul>
          </CardContent>
        </Card>
      </div>
    </div>
  )
}

  /*const bears = useStore((state) => state.bears);
  const increasePopulation = useStore((state) => state.increasePopulation);
  const removeAllBears = useStore((state) => state.removeAllBears);
  const updateBears = useStore((state) => state.updateBears);

  console.log(bears);
  return (
    <>
      <h1>hello world</h1>
      <span className="text-3xl">{bears}</span>
      <Button onClick={increasePopulation}>buton</Button>
      <Button onClick={removeAllBears}>resetear</Button>
      <Button onClick={() => updateBears(77)}>actualizar numero a 77</Button>
      <Button variant="destructive">example</Button>
    </>
  );
}*/
export default Home;


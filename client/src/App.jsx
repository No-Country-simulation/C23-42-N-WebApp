import "./App.css";
import { Button } from "./components/ui/button";
import { useStore } from "./store/useExampleStore.js";

function App() {
  const bears = useStore((state) => state.bears);
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
}

export default App;

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Layout } from "./components/Layout";
import RegisterPage from "./pages/RegisterPage";
import LoginPage from "./pages/LoginPage";
import { Home } from "./pages/Home";
import { Example } from "./pages/Example";

function App() {
  return (
    <Router>
      <Routes>
        {/* rutas publicas */}
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/login" element={<LoginPage />} />

        {/* routas privadas */}
        <Route element={<Layout />}>
          <Route path="/" element={<Home />} />
          <Route path="/example" element={<Example />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App;

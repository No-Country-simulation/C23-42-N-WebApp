import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import RegisterPage from './pages/RegisterPage';
import LoginPage from './pages/LoginPage';
import { Layout } from './components/Layout';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/" element={<Layout />}/>
      </Routes>
    </Router>
  );
}

export default App;


/*import { Layout } from './components/Layout'
import "./App.css";
import RegisterForm from "./components/RegisterForm";
import LoginForm from './components/LoginForm';


function App() {
  return (
    
  
    <>
    <Layout>
    {/* Contenido adicional irá aquí */
  //</Layout>
    
      
/*     <RegisterForm />
      <LoginForm />
    </>
  );
}

//export default App*/

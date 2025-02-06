import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig({
  base: '/',
  plugins: [react()],
  resolve: {
    alias: {
      '@': '/src', // Asegúrate de que estas rutas coincidan con la estructura de tu proyecto
    },
  },
});



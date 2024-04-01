import { Dashboard } from './components/Dashboard';
import { Header } from './components/Header';
import { NovaPautaModal } from './components/NovaPautaModal';
import { NovoVotoModal } from './components/NovoVotoModal';
import { GlobalStyle } from './styles/global';
import { useState } from 'react';
import Modal from 'react-modal';

Modal.setAppElement('#root')

export function App() {
  const [isNovaPautaModalOpen, setIsNovaPautaModalOpen] = useState(false);
  const [isNovoVotoModalOpen, setIsNovoVotoModalOpen] = useState(false);

  function handleAbreNovaPautaModal() {
    setIsNovaPautaModalOpen(true);
  }

  function handleFechaPautaModal() {
    setIsNovaPautaModalOpen(false);      
  }

  function handleAbreNovoVotoModal() {
    setIsNovoVotoModalOpen(true);
  }

  function handleFechaVotoModal() {
    setIsNovoVotoModalOpen(false);      
  }

  return (
    <>
      <Header 
        onAbrirNovaPautaModal={handleAbreNovaPautaModal}
        onAbrirNovoVotoModal={handleAbreNovoVotoModal}
      />
      <Dashboard />

      <NovaPautaModal 
        isOpen={isNovaPautaModalOpen}
        onRequestClose={handleFechaPautaModal}
      />

     <NovoVotoModal 
        isOpen={isNovoVotoModalOpen}
        onRequestClose={handleFechaVotoModal}
      />

      <GlobalStyle /> 
    </>
  );
}
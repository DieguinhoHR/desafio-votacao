import { Dashboard } from './components/Dashboard';
import { Header } from './components/Header';
import { NovaPautaModal } from './components/NovaPautaModal';
import { GlobalStyle } from './styles/global';
import { useState } from 'react';
import Modal from 'react-modal';

Modal.setAppElement('#root')

export function App() {
  const [isNovaPautaModalOpen, setIsNovaPautaModalOpen] = useState(false);

  function handleAbreNovaPautaModal() {
    setIsNovaPautaModalOpen(true);
  }

  function handleFechaNovaPautaModal() {
    setIsNovaPautaModalOpen(false);      
  }

  return (
    <>
      <Header onAbrirNovaPautaModal={handleAbreNovaPautaModal} />
      <Dashboard />

      <NovaPautaModal 
        isOpen={isNovaPautaModalOpen}
        onRequestClose={handleFechaNovaPautaModal}
      />

      <GlobalStyle /> 
    </>
  );
}
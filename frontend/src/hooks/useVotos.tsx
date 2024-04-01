import { createContext, useEffect, useState, ReactNode, useContext } from 'react';
import { api } from "../services/api";

interface Voto {
  id: number,
  nome: string,
  resultado: {
      SIM: number,
      NAO: number
  }
}

interface VotoInput {
  cpfEleitor: string;
  statusVoto: string;
  sessaoVotacao: string;
}

interface VotoProviderProps {
  children: ReactNode;
}  

interface VotoContextData {
    votos: Voto[];
    criarVoto: (pautas: VotoInput, id: string) => Promise<void>;
}

export const VotoContext = createContext<VotoContextData>({} as  VotoContextData);

export function VotosProvider({children}: VotoProviderProps) {
  const [votos, setVotos] = useState<Voto[]>([]);

  useEffect(() => {
    api.get('pautas/contabiliza-votos')
      .then(response => setVotos(response.data))
  }, []);

  async function criarVoto(votonInput: VotoInput, id: string) {
    await api.post(`pautas/${id}/votos`, votonInput)
              .catch(function (error) {
                alert(error.response.data.title);
              });
              window.location.reload()  
  };

  return (
    <VotoContext.Provider value={{votos, criarVoto }}>
      {children}
    </VotoContext.Provider>
  )
}

export function useVotos() {
    const context = useContext(VotoContext)
  
    return context;
}


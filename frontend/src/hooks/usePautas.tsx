import { createContext, useEffect, useState, ReactNode, useContext } from 'react';
import { api } from "../services/api";

interface Pauta {
  id: string;
  nome: string;
  descricao:string;
  dataInicio: string;
}

interface PautaInput {
  nome: string;
  descricao:string;
  dataInicio: string;
}

interface PautaProviderProps {
  children: ReactNode;
}

interface PautaContextData {
    pautas: Pauta[];
    criarPauta: (pautas: PautaInput) => Promise<void>;
}

export const PautaContext = createContext<PautaContextData>({} as  PautaContextData);

export function PautasProvider({children}: PautaProviderProps) {
  const [pautas, setPautas] = useState<Pauta[]>([]);

  useEffect(() => {
    api.get('pautas')
      .then(response => setPautas(response.data))
  }, []);

  async function criarPauta(pautaInput: PautaInput) {
    const response = await api.post('pautas', pautaInput);
   
    setPautas([
      ...pautas,
      response.data
    ])
  };

  return (
    <PautaContext.Provider value={{pautas, criarPauta }}>
      {children}
    </PautaContext.Provider>
  )
}

export function usePautas() {
  const context = useContext(PautaContext)

  return context;
}
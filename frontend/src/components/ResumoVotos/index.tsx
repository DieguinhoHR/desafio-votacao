import { Container } from "./styles";
import incomeImg from '../../assets/income.svg';
import outcomeImg from '../../assets/outcome.svg';
import { useState, useEffect } from "react";
import { api } from "../../services/api";

interface Pauta {
    id: number;
    nome: string;
    resultado: {
        SIM: number,
        NAO: number
    }
}

export function ResumoVotos() {
    const [pautas, setPautas] = useState<Pauta[]>([]); 
    const [votoTotalSim, setVotoTotalSim] = useState(0);
    const [votoTotalNao, setVotoTotalNao] = useState(0);

    useEffect(() => {
        (async () => {
            const { data } = await api.get('pautas');
            setPautas(data)
  
            let somaVotosSim = 0;

            pautas.forEach(pauta => somaVotosSim += pauta.resultado.SIM);
            setVotoTotalSim(somaVotosSim);

            let somaVotosNao = 0;

            pautas.forEach(pauta => somaVotosNao += pauta.resultado.NAO);
            setVotoTotalNao(somaVotosNao);
          })();
    }, []);
    
    return (
        <Container>
            <div>
                <header>
                    <p>Votos (Sim)</p>
                    <img src={incomeImg} alt="Entradas" />
                </header>
                <strong>{votoTotalSim}</strong>
            </div>
            <div>
                <header>
                    <p>Votos (Não)</p>
                    <img src={outcomeImg} alt="Entradas" />
                </header>
                <strong>{votoTotalNao}</strong>
            </div>
            <div className="total-votos">
                <header>
                    <p>Total de votos</p>
                </header>
                <strong>{votoTotalSim + votoTotalNao}</strong>
            </div>
        </Container>    
    );
}
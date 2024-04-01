import { Container } from "./styles";
import incomeImg from '../../assets/income.svg';
import outcomeImg from '../../assets/outcome.svg';
import { useVotos } from "../../hooks/useVotos";

export function ResumoVotos() {
    const { votos } = useVotos();

    const resumo = votos.reduce((acumulador, voto) => {
        if (voto.resultado.SIM) {
            acumulador.SIM += voto.resultado.SIM;
            acumulador.total += voto.resultado.SIM;
        } 
        acumulador.NAO += voto.resultado.NAO;
        acumulador.total += voto.resultado.NAO;
        
        return acumulador;
    }, {
        SIM: 0,
        NAO: 0,
        total: 0
    })

    return (
        <Container>
            <div>
                <header>
                    <p>Votos (Sim)</p>
                    <img src={incomeImg} alt="Entradas" />
                </header>
                <strong>{resumo.SIM}</strong>
            </div>
            <div>
                <header>
                    <p>Votos (Não)</p>
                    <img src={outcomeImg} alt="Entradas" />
                </header>
                <strong>{resumo.NAO}</strong>
            </div>
            <div className="total-votos">
                <header>
                    <p>Total de votos</p>
                </header>
                <strong>{resumo.total}</strong>
            </div>
        </Container>    
    );
}
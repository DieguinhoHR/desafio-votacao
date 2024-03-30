import { Container } from "./styles";
import totalImg from '../../assets/total.svg';
import incomeImg from '../../assets/income.svg';
import outcomeImg from '../../assets/outcome.svg';

export function Summary() {
    return (
        <Container>  
            <div>
                <header>
                    <p>Votos (Sim)</p>
                    <img src={incomeImg} alt="Entradas" />
                </header>
                <strong>4</strong>
            </div>
            <div>
                <header>
                    <p>Votos (Não)</p>
                    <img src={outcomeImg} alt="Entradas" />
                </header>
                <strong>0</strong>
            </div>
            <div>
                <header>
                    <p>Total de votos</p>
                </header>
                <strong>0</strong>
            </div>
        </Container>    
    );
}
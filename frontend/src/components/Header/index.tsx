import logoImg from '../../assets/voto.svg';
import { Container, Content } from "./styles";

interface HeaderProps {
  onAbrirNovaPautaModal: () => void;
}

export function Header({ onAbrirNovaPautaModal }: HeaderProps) {
    
    return (
      <Container>
        <Content>
            <img src={logoImg} alt="Sistema de votos" />
            <button type="button" onClick={onAbrirNovaPautaModal}>
                Nova pauta
            </button>            
        </Content>
      </Container>
    )
}
import logoImg from '../../assets/voto.svg';
import { Container, Content } from "./styles";

interface HeaderProps {
  onAbrirNovaPautaModal: () => void;
  onAbrirNovoVotoModal: () => void;
}

export function Header({ onAbrirNovaPautaModal, onAbrirNovoVotoModal }: HeaderProps) {
    
    return (
      <Container>
        <Content>
            <img src={logoImg} alt="Sistema de votos" />
            <div>
              <button type="button" onClick={onAbrirNovaPautaModal}>
                  Nova pauta
              </button>
              <button type="button" onClick={onAbrirNovoVotoModal}>
                  Novo voto
              </button>
            </div>
        </Content>
      </Container>
    )
}
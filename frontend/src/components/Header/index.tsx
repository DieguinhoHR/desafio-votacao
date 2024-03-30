import logoImg from '../../assets/voto.svg';
import { Container, Content } from "./styles";

export function Header() {
    return (
      <Container>
        <Content>
            <img src={logoImg} alt="Sistema de votos" />
            <button type="button">
                Novo voto
            </button>
        </Content>
      </Container>
    )
}
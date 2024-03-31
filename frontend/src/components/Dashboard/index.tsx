import { ResumoVotos } from "../ResumoVotos";
import { TabelaPautas } from "../TabelaPautas";
import { Container } from "./styles";

export function Dashboard() {
  return (
    <Container>
      <ResumoVotos />
      <TabelaPautas />
    </Container>
  )
}
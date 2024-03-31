import { useEffect, useState } from "react";
import { Container } from "./styles";
import { api } from "../../services/api";

interface Pauta {
    id: number;
    nome: string;
}

export function TransactionTable() {
  const [pautas, setPautas] = useState<Pauta[]>([]);  

  useEffect(() => {
    api.get('pautas')
        .then(response => setPautas(response.data))
  }, []);   

  return (
    <Container>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
          </tr>
        </thead>

        <tbody>
            {pautas.map(pauta =>  (
                <tr key={pauta.id}>
                    <td>{pauta.id}</td>
                    <td>{pauta.nome}</td>
                </tr>   
            ))}               
        </tbody>
      </table>
    </Container>
  )
}
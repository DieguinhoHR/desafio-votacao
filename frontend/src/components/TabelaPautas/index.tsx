import { useEffect, useState } from "react";
import { Container } from "./styles";
import { api } from "../../services/api";

interface Pauta {
    id: number;
    nome: string;
}

export function TabelaPautas() {
  const [pautas, setPautas] = useState<Pauta[]>([]);

  async function handleIniciarSessao(id: Number) {
    const obj = await api.post(`sessoes/${id}/sessoes-votacoes`)
                        .catch(function (error) {
                          alert(error.response.data.title);
                        });

    if (obj) {
        alert('Sessão iniciada com sucesso')
    }
  }

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
            <th>Iniciar sessão</th>
          </tr>
        </thead>

        <tbody>
            {pautas.map(pauta =>  (
                <tr key={pauta.id}>
                    <td>{pauta.id}</td>
                    <td>{pauta.nome}</td>
                    <td>
                      <button type="submit" onClick={() => handleIniciarSessao(pauta.id)}>
                        Iniciar sessão
                      </button>
                    </td>
                </tr>   
            ))}               
        </tbody>
      </table>
    </Container>
  )
}
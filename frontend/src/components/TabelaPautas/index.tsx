import { Container } from "./styles";
import { api } from "../../services/api";
import { usePautas } from "../../hooks/usePautas";

export function TabelaPautas() {
  const { pautas } = usePautas();

  async function handleIniciarSessao(id: any) {
    const obj = await api.post(`sessoes/${id}/sessoes-votacoes`)
                        .catch(function (error) {
                          alert(error.response.data.title);
                        });

    if (obj) {
        alert('Sessão iniciada com sucesso')
        window.location.reload()       
    }
  }

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
                      <button type="submit" 
                              onClick={() => handleIniciarSessao(pauta.id)}>
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
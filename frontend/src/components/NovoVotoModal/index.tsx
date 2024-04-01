import Modal from 'react-modal';
import { FormEvent, SetStateAction, useEffect, useState } from 'react';
import closeImg from '../../assets/close.svg';
import { Container } from './styles';
import { api } from "../../services/api";

interface NovoVotoModalProps {
    isOpen: boolean; 
    onRequestClose: () => void;
}

export function NovoVotoModal({ isOpen, onRequestClose }: NovoVotoModalProps) {
    const [cpfEleitor, setCpfEleitor] = useState('');
    const [statusVoto, setStatusVoto] = useState('SIM');
    const [sessaoVotacao, setSessaoVotacao] = useState('');
    const [sessoes, setSessoes] = useState<any[]>([]);

    useEffect(() => {
        getSessoes()
    }, []);

    function getSessoes() {
        (async () => {
          const response = await api.get('sessoes');          
          setSessoes(response.data);
        })();
      }
    
    async function handleCreateVoto(event: FormEvent) {
        event.preventDefault();

        const data = {
            cpfEleitor,
            statusVoto,
            sessaoVotacao
        }

        const obj = await api.post('pautas/1/votos', data)
                            .catch(function (error) {
                                alert(error.response.data.title);
                            });

        if (obj) {
            alert('Registro cadstrado com sucesso')
            onRequestClose();  
        }           
    }     

    return (
        <Modal isOpen={isOpen} 
            onRequestClose={onRequestClose}
            overlayClassName="react-modal-overlay"
            className="react-modal-content"
        >
            <button type="button" 
                    onClick={onRequestClose} 
                    className='react-modal-close'
            >
                <img src={closeImg} alt="Fechar mdoal" />
            </button>   
                 
            <Container onSubmit={handleCreateVoto}>
                <h2>Cadastrar voto</h2>
                <input 
                    type="text"
                    value={cpfEleitor}
                    onChange={event => setCpfEleitor(event.target.value) }
                    placeholder="Digite seu CPF"  
                />               
                <label htmlFor="voto"> Selecione seu voto</label>
                <select name="voto" 
                        value={statusVoto || 'SIM'}
                        onChange={event => setStatusVoto(event.target.value)}
                >
                    <option value="SIM">SIM</option>
                    <option value="NAO">NÃO</option>
                </select>

                <label htmlFor="sessaoVotacao"> Selecione uma sessão de voto</label>
                <select name="sessaoVotacao" 
                        value={sessaoVotacao}
                        onChange={event => setSessaoVotacao(event.target.value)}
                >
                    {sessoes.map(sessao => (
                        <option value={sessao.id} 
                                key={sessao.id}>
                                    {sessao.id}
                        </option>   
                    ))}                     
                </select>             
                <button type="submit">Cadastrar</button>
            </Container>
        </Modal>    
     )
}
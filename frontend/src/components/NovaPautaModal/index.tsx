import Modal from 'react-modal';
import { FormEvent, useState } from 'react';
import closeImg from '../../assets/close.svg';
import { Container } from './styles';
import { api } from "../../services/api";

interface NovaPautaModalProps {
    isOpen: boolean; 
    onRequestClose: () => void;
}

export function NovaPautaModal({ isOpen, onRequestClose }: NovaPautaModalProps) {
    const [nome, setNome] = useState('');
    const [descricao, setDescricao] = useState('');
    const [dataInicio, setDataInicio] = useState('');
    
    async function handleCreateNovaPauta(event: FormEvent) {
        event.preventDefault();

        const hoje = new Date();
        console.log(hoje.getSeconds())
  
        const obj = await api.post('pautas', {
            'dataInicio': `${dataInicio} ${hoje.getHours()}:${hoje.getMinutes()}:${hoje.getSeconds()}`,
            'nome': nome,
            'descricao': descricao             
        });

        if (obj) {
            alert('Registro cadstrado com sucesso')
        }
        onRequestClose();      
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
                 
            <Container onSubmit={handleCreateNovaPauta}>
                <h2>Cadastrar pauta</h2>
                <input 
                    type="text"
                    value={nome}
                    onChange={event => setNome(event.target.value) }
                    placeholder="Nome" 
                />
                <input 
                    type="text"
                    value={descricao}
                    onChange={event => setDescricao(event.target.value) }
                    placeholder="Descrição"
                />
                <input 
                    type="date"
                    value={dataInicio}
                    onChange={event => setDataInicio(event.target.value) }
                    placeholder="Data Inicio"
                />
                <button type="submit">Cadastrar</button>
            </Container>
        </Modal>    
     )
}
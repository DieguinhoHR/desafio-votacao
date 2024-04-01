import Modal from 'react-modal';
import { FormEvent, useState } from 'react';
import closeImg from '../../assets/close.svg';
import { Container } from './styles';
import moment from 'moment';
import { usePautas } from '../../hooks/usePautas';

interface NovaPautaModalProps {
    isOpen: boolean; 
    onRequestClose: () => void;
}

export function NovaPautaModal({ isOpen, onRequestClose }: NovaPautaModalProps) {
    const { criarPauta } = usePautas();

    const [nome, setNome] = useState('');
    const [descricao, setDescricao] = useState('');
    const [dataInicio, setDataInicio] = useState('');
        
    async function handleCreateNovaPauta(event: FormEvent) {
        event.preventDefault();

        const dataInicioFormatada = moment(dataInicio).format("yyyy-MM-DD HH:mm:ss")

        await criarPauta({
            dataInicio: dataInicioFormatada,
            nome,
            descricao
        })
         
        setNome('');
        setDescricao('');
        setDataInicio('');
         
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
                    type="datetime-local"
                    value={dataInicio}
                    onChange={event => setDataInicio(event.target.value) }
                    placeholder="Data Inicio"
                />
                <button type="submit">Cadastrar</button>
            </Container>
        </Modal>    
     )
}
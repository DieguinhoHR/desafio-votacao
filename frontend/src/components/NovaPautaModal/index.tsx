import Modal from 'react-modal';
import { FormEvent, useState } from 'react';
import closeImg from '../../assets/close.svg';
import incomeImg from '../../assets/income.svg';
import outcomeImg from '../../assets/outcome.svg';
import { Container } from './styles';


interface NovaPautaModalProps {
    isOpen: boolean; 
    onRequestClose: () => void;
}

export function NovaPautaModal({ isOpen, onRequestClose }: NovaPautaModalProps) {
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
                 
            <Container>
                <h2>Cadastrar pauta</h2>
                <input 
                    type="text" 
                    placeholder="Nome" 
                />
                <input 
                    type="textarea" 
                    placeholder="Descrição"
                />
                <input 
                    type="date" 
                    placeholder="Data inicio"
                />
                <button type="submit">Cadastrar</button>
            </Container>
        </Modal>    
     )
}
import React, { useState } from 'react'
import './style.css'
import HeaderWeb from '../../components/index'
import { useForm } from "react-hook-form";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import 'bootstrap/dist/css/bootstrap.min.css';
import service from '../../service/service'


const validationPost = yup.object().shape({
  nome: yup.string().required("Preencha o título").max(40, "Até 40 caract."),
  descricao: yup.string().required("Preencha a descrição"),
});

function Cadastro() {

  let navigate = useNavigate();


  const [show1, setShow1] = useState(false);
  const handleClose1 = () => setShow1(false);
  const handleShow1 = () => setShow1(true);

  const [show2, setShow2] = useState(false);
  const handleClose2 = () => setShow2(false);
  const handleShow2 = () => setShow2(true)


  const {
    register,
    handleSubmit,
    formState: { errors } } = useForm({ resolver: yupResolver(validationPost) });

  const criaItem = async (data) => {
    await service.post("/item/salvar", data)
      .then(() => {
        console.log("deu certo");
        handleShow1();
      })
      .catch(() => {
        console.log("deu errado");
        handleShow2();
      })
  }

  return (
    <>
      <HeaderWeb />
      <div className="paginaCa">

        <div className="containerCA">
          <form action="#" className='form' onSubmit={handleSubmit(criaItem)}>
            <div className='dados'>
              <div className='nomeCa'>

                <span><strong>Nome</strong></span>
                <input type="text" id="nome" name="nome"{...register("nome")} className="nomei" placeholder='Nome'></input>
                <p className="error-message1">{errors.nome?.message}</p>

              </div>
              <div className='descricaoCa'>

                <span><strong>Descrição</strong></span>
                <textarea id="descricao" name="descricao" {...register("descricao")} className='descricaoi' placeholder='Descrição'></textarea>
                <p className="error-message2">{errors.descricao?.message}</p>

              </div>
            </div>

            <button className='btnEnviar' >Enviar</button>

          </form>
        </div>
        <div>
          <button className='bntVoltar' onClick={() => navigate('/')}>Voltar</button>
        </div>
      </div>

      <Modal show={show1} onHide={() => navigate('/')}>
        <Modal.Header closeButton>
          <Modal.Title>Cadastro realizado</Modal.Title>
        </Modal.Header>
        <Modal.Body>Seu cadastro fo realizado com sucesso</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => navigate('/')}>
            Fechar
          </Button>
        </Modal.Footer>
      </Modal>

      <Modal show={show2} onHide={handleClose2}>
        <Modal.Header closeButton>
          <Modal.Title>Cadastro falho</Modal.Title>
        </Modal.Header>
        <Modal.Body>Seu cadastro não pode ser realizado</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose2}>
            Fechar
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  )
}

export default Cadastro
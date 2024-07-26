import React, { useEffect, useState, createContext, useContext } from 'react'
import './style.css'
import HeaderWeb from '../../components/index'
import { useForm } from "react-hook-form";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import axios from "axios";
import { useNavigate } from "react-router-dom";
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
  const [show3, setShow3] = useState(false);
  const handleClose3 = () => setShow3(false);
  const handleShow3 = () => setShow3(true)
  const [disab, setDisab] = useState(false);
  const [muda, setMuda] = useState(false);
  const [id, setId] = useState();
  const [nome, setNome] = useState("");
  const [descricao, setDescricao] = useState("");

  useEffect(() => {
    altera()
  }, [])

  const altera = async () => {
    if (localStorage.getItem("id") !== null) {
      setId(localStorage.getItem("id"));
      setMuda(true);
      await service.get(`/items/${localStorage.getItem("id")}`)
        .then((resposta) => {
          setNome(resposta.data.nome);
          setDescricao(resposta.data.descricao);
          localStorage.removeItem("id");
        })
    }
  }

  const {
    register,
    handleSubmit,
    formState: { errors } } = useForm({ resolver: yupResolver(validationPost) });

  const criaItem = async (data) => {
    setDisab(true)

    if (muda == true) {
      await service.put(`/items/atualizar/${id}`, data)
        .then(() => {
          handleShow3()
        })
        .catch(() => {
          handleShow2();
          setDisab(false)
        })

    } else {
      await service.post("/items/salvar", data)
        .then(() => {
          handleShow1();
        })
        .catch(() => {
          handleShow2();
          setDisab(false)
        })
    }
  }



  return (
    <>
      <HeaderWeb />
      <div className="paginaCa">

        <p style={{ fontSize: "18px" }}>Cadastre sua tarefa</p>

        <div className="containerCA">
          <form action="#" className='form' onSubmit={handleSubmit(criaItem)}>
            <div className='dados'>
              <div className='nomeCa'>

                <span><strong>Nome</strong></span>
                <input type="text" id="nome" name="nome"{...register("nome")} className="nomei" placeholder='Nome' defaultValue={nome}></input>
                <p className="error-message1">{errors.nome?.message}</p>

              </div>
              <div className='descricaoCa'>

                <span><strong>Descrição</strong></span>
                <textarea id="descricao" name="descricao" {...register("descricao")} className='descricaoi' placeholder='Descrição' defaultValue={descricao}></textarea>
                <p className="error-message2">{errors.descricao?.message}</p>

              </div>
            </div>

            <button className='btnEnviar' disabled={disab} >Enviar</button>

          </form>
        </div>
      </div>

      <Modal show={show1} onHide={() => navigate('/')}>
        <Modal.Header closeButton>
          <Modal.Title>Cadastro realizado</Modal.Title>
        </Modal.Header>
        <Modal.Body>Seu cadastro foi realizado com sucesso</Modal.Body>
        <Modal.Footer>
          <button className='bntmodal' onClick={() => navigate('/')}>
            Fechar
          </button>
        </Modal.Footer>
      </Modal>

      <Modal show={show2} onHide={handleClose2}>
        <Modal.Header closeButton>
          <Modal.Title>Cadastro falho</Modal.Title>
        </Modal.Header>
        <Modal.Body>Seu cadastro não pode ser realizado</Modal.Body>
        <Modal.Footer>
          <button className='bntmodal' onClick={handleClose2} >
            Fechar
          </button>
        </Modal.Footer>
      </Modal>

      <Modal show={show3} onHide={() => navigate('/')}>
        <Modal.Header closeButton>
          <Modal.Title>Cadastro alterado</Modal.Title>
        </Modal.Header>
        <Modal.Body>Seu cadastro foi alterado com sucesso</Modal.Body>
        <Modal.Footer>
          <button className='bntmodal' onClick={() => navigate('/')}>
            Fechar
          </button>
        </Modal.Footer>
      </Modal>
    </>
  )
}

export default Cadastro
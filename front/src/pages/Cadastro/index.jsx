import React, { useState } from 'react'
import './style.css'
import HeaderWeb from '../../components/index'
import { useForm } from "react-hook-form";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const validationPost = yup.object().shape({
  nome: yup.string().required("Preencha o título").max(40, "Até 40 caract."),
  descricao: yup.string().required("Preencha a descrição").max(100, "Até 100 caract."),
});

function Cadastro() {

  const {
    register,
    handleSubmit,
    formState: { errors } } = useForm({ resolver: yupResolver(validationPost) });

  const criaItem = (data) => axios.post("http://localhost:8080/api/item/salvar", data)
    .then(() => {
      console.log("deu certo");
      navigate("/");
    })
    .catch(() => {
      console.log("deu errado");
    })

  return (
    <>
      <HeaderWeb />
      <div className="paginaCA">
        <div className="container">
          <div className='dados'>
            <form action="#" className='form' onSubmit={handleSubmit(criaItem)}>
              <div className='nome'>
                <span><strong>Nome</strong></span>
                <input type="text" id="nome" name="nome"{...register("nome")} className="nomei" placeholder='Nome'></input>
              </div>
              <div className='descricao'>
                <span><strong>Descrição</strong></span>
                <textarea id="descricao" name="descricao" {...register("descricao")} className='descricaoi' placeholder='Descrição'></textarea>
              </div>
              <button className='btn'>Enviar</button>
            </form>
          </div>

        </div>
      </div>
    </>
  )
}

export default Cadastro
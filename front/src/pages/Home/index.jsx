import React, { useEffect, useState } from 'react'
import { useNavigate } from "react-router-dom";
import HeaderWeb from '../../components/index'
import { Table } from 'react-bootstrap';
import service from '../../service/service'
import './style.css'


function Home() {

    let navigate = useNavigate();
    const [lista, setLista] = useState([]);

    const pegarItems = async () => {
        await service.get("/item/listar")
            .then((resposta) => {
                console.log(resposta.data);
                setLista(resposta.data);
            })
    }

    useEffect(() => {
        pegarItems()
    }, [])

    return (
        <>
            <HeaderWeb />
            <div className='paginaHo'>
                {lista?.map((items, key) => {
                    return (
                        <div key={key} className='postHo'>

                            <div className='nomeHo'>
                                {items.nome}
                            </div>

                            <div className='descricaoHo'>
                                {items.descricao}
                            </div>

                        </div>
                    )
                })}
                <button className='btncadastrar' onClick={() => navigate('/cadastro')}>Cadastrar</button>
            </div>
        </>
    )
};

export default Home
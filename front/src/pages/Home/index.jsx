import React, { useEffect, useState } from 'react'
import { Navigate, useNavigate } from "react-router-dom";
import HeaderWeb from '../../components/index'
import { Table } from 'react-bootstrap';
import service from '../../service/service'
import './style.css'
import { BsFillArrowUpSquareFill } from "react-icons/bs";
import { FaTrashCan } from "react-icons/fa6";
import { GoPencil } from "react-icons/go";



function Home() {

    let navigate = useNavigate();

    const [lista, setLista] = useState([]);
    const [id,setId] = useState();

    useEffect(() => {
        pegarItems()
    }, [])

    const pegarItems = async () => {
        await service.get("/items/listar")
            .then((resposta) => {
                setLista(resposta.data);
            })
    }

    const deletarItem = async (id) => {
        await service.delete(`/items/deletar/${id}`)
        setLista(lista.filter((lista) => lista.id !== id));
    }

    const alterarItem = (item) => {
        setId(localStorage.setItem('id', item.id));
        navigate("/cadastro");
    }

    const scrollToTop = () => {
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    };

    return (
        <>
            <HeaderWeb />
            <div className='paginaHo'>
                {lista?.map((items, key) => {
                    return (
                        <div key={key} className='postHo'>

                            <div className='nomeHo'>
                                <pre className='texto'>{items.nome}</pre>
                            </div>

                            <div className='descricaoHo'>
                                <pre className='texto'>{items.descricao}</pre>
                            </div>
                            <div className='data'>
                                <p style={{ margin: 0, paddingInline: '10px', fontSize: "12px" }}>{items.data}</p>
                                <div>
                                    <button style={{ backgroundColor: 'transparent', border: '0px' }} onClick={() => alterarItem(items)}><GoPencil /></button>
                                    <button style={{ backgroundColor: 'transparent', border: '0px' }} onClick={() => deletarItem(items.id)}><FaTrashCan /></button>
                                </div>
                            </div>
                        </div>
                    )
                })}
                <button className='btnSobe' onClick={scrollToTop}><BsFillArrowUpSquareFill size={30} /></button>
            </div>
        </>
    )
};

export default Home
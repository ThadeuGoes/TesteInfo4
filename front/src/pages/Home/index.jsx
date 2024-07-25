import React, { useEffect, useState } from 'react'
import { useNavigate } from "react-router-dom";
import HeaderWeb from '../../components/index'
import { Table } from 'react-bootstrap';
import service from '../../service/service'
import './style.css'
import { BsFillArrowUpSquareFill } from "react-icons/bs";
import { FaTrashCan } from "react-icons/fa6";



function Home() {

    const [lista, setLista] = useState([]);

    const pegarItems = async () => {
        await service.get("/items/listar")
            .then((resposta) => {
                console.log(resposta.data);
                setLista(resposta.data);
            })
    }

    const deletarItem =async(id)=>{
        console.log(id);
        await service.delete(`/items/deletar/${id}`)
        setLista(lista.filter((lista)=>lista.id!==id));
    }

    const scrollToTop = () => {
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    };

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
                                <pre className='algo'>{items.nome}</pre>
                            </div>

                            <div className='descricaoHo'>
                                <pre className='algo'>{items.descricao}</pre>
                            </div>
                            <div className='data'>
                                <p style={{margin:0,paddingInline:'10px',fontSize:"12px"}}>{items.data}</p>

                                <button style={{backgroundColor:'transparent',border:'0px'}} onClick={()=>deletarItem(items.id)}><FaTrashCan /></button>
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
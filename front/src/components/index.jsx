import React, { useEffect, useState } from 'react'
import './style.css'
import { useNavigate } from 'react-router-dom';
import { CiLogout } from "react-icons/ci";
import Logo from '../assets/logo.png';
import { useLocation } from 'react-router-dom';

function HeaderWeb() {

    let navigate = useNavigate();

    const [algo, setAlgo] = useState("/cadastro")

    const location = useLocation();
    const currentPath = location.pathname;

    useEffect(() =>{console.log(currentPath)},[])


    return (
        <>
            <div className='corpo'>
                <img width={'70px'} height={'70px'} src={Logo} />
                {algo ===currentPath ?
                    <>
                        <button className='btncadastrar' onClick={()=>navigate("/")}>Home</button>
                    </>
                    : <>
                        <button className='btncadastrar' onClick={()=>navigate("/cadastro")}>Cadastro</button>
                    </>}
            </div >
        </>
    )
}

export default HeaderWeb
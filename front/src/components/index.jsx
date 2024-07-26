import React, { useEffect, useState } from 'react'
import './style.css'
import { useNavigate } from 'react-router-dom';
import { CiLogout } from "react-icons/ci";
import Logo from '../assets/logo.png';
import { useLocation } from 'react-router-dom';

function HeaderWeb() {

    let navigate = useNavigate();
    const location = useLocation();

    const [algo, setAlgo] = useState("/cadastro")
    const currentPath = location.pathname;

    return (
        <>
            <div className='corpo'>
                <img width={'70px'} height={'70px'} src={Logo} />
                {algo ===currentPath ?
                    <>
                        <button className='btnpagina' onClick={()=>navigate("/")}>Home</button>
                    </>
                    : <>
                        <button className='btnpagina' onClick={()=>navigate("/cadastro")}>Cadastro</button>
                    </>}
            </div >
        </>
    )
}

export default HeaderWeb
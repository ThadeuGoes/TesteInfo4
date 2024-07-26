import React from 'react'
import { useNavigate } from 'react-router-dom'

function Erro() {

  let navigate = useNavigate();

  return (
    <div style={{ display: 'flex', alignItems: 'center', justifyContent: "center", backgroundColor: '#e8f1f3', height: "100vh" }}>
      <p style={{ fontSize: '50px', cursor:"pointer"}} onClick={() => navigate("/")}>Erro</p>
    </div>
  )
}

export default Erro
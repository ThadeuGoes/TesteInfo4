import React from 'react'
import { Navigate, Route, Routes } from 'react-router-dom'
import Home from '../pages/Home'
import Erro from '../pages/Erro'
import Cadastro from '../pages/Cadastro'

function AppRouter() {
  return (
    <div>
      <Routes>
        <Route path='/' element={<Home/>}></Route>

        <Route path='/cadastro'element={<Cadastro/>} ></Route>

        <Route path='/*' element={<Erro />}></Route>
      </Routes>
    </div>
  )
}
export default AppRouter

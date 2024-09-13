import React from 'react'
import { Navigate, Outlet } from 'react-router-dom'
import { isLoggedIn, isTourist } from '../../auth/Index'

const TouristBasePage = () => {
  const login=isLoggedIn();
  const tourist=isTourist();
    if(login===false){
        return <Navigate to={"/signin"}/>
      }
    if(tourist){
      return <Outlet/>
      }
      
      
      
}

export default TouristBasePage

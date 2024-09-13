import React from 'react'
import { isLoggedIn, isTourGuide } from '../../auth/Index';
import { Navigate, Outlet } from 'react-router-dom';

const GuideBasePage = () => {
    const login=isLoggedIn();
    const tourguide=isTourGuide();
      if(login===false){
          return <Navigate to={"/signin"}/>
        }
      if(tourguide){
        return <Outlet/>
        }
        
}

export default GuideBasePage

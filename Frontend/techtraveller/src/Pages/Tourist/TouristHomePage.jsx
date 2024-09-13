import React from 'react'
import { getCurrentUserDetails, isTouristUser } from '../../auth/Index';
import { Navigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import DynamicCard from '../../Component/user/DynamicCard';
import g1 from '../../image/Home/g1.png';
import g2 from '../../image/Home/g2.png';
import g3 from '../../image/Home/g3.png';
import g4 from '../../image/Home/g4.png';
import Profie from '../../Component/user/Profie';



const TouristHomePage = () => {
    const currentUser = getCurrentUserDetails(); 
    
  //  if(!currentUser.isActive){
  //   toast.error("Your account is not active! Please check your mail...")
  //   return <Navigate to={"/signin"}/>
  //  }
    
    
  return (
<>
<div className="container-fluid">
  <div className="row">
  <div className="container d-flex justify-content-center flex-wrap ">
<DynamicCard 
           img={g1}
           title="Beautiful Beach Resort"
           rating={4.5}
           price={200}
           footer="Book Now"
           link="/resort"
           width="20rem"
          />
<DynamicCard 
           img={g2}
           title="Delhi"
           rating={4.5}
           price={2000}
           footer="Book Now"
           link="/resort"
           width="20rem"
          />
<DynamicCard 
           img={g3}
           title="Gujarat"
           rating={4.5}
           price={3000}
           footer="Book Now"
           link="/resort"
           width="20rem"
          />
<DynamicCard 
           img={g4}
           title="Rajisthan"
           rating={4.5}
           price={200}
           footer="Book Now"
           link="/resort"
           width="20rem"
          />



</div>
  </div>
</div>
</>
  )
}

export default TouristHomePage

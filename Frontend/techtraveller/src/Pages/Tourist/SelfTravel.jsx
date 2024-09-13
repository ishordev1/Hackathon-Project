import React from 'react'
import DynamicCard from '../../Component/user/DynamicCard'
import g1 from '../../image/Home/uk.png'

const SelfTravel = () => {
  return (
    <div>
    <div className="container-fluid">
  <div className="row">
   <div className="container text-center">
   {/* <h1>Choose For Travell</h1> */}
   </div>
  <div className="container d-flex justify-content-center flex-wrap ">
<DynamicCard 
           img="https://travel-be.com/wp-content/uploads/2019/07/Tour-Guide0.jpg"
            title="Tour Guide"
           footer="Select Tour Guide"
           link="/tourist/booktourguide"
           width="20rem"
          />
<DynamicCard 
           img="https://t3.ftcdn.net/jpg/02/12/30/40/360_F_212304026_9QgKzHH2Aj6pGITIHViCHPs9NOjyZbXY.jpg"
            title="Vachile"
           footer="Select"
           link="/tourist/bookvehicle"
           width="20rem"
          />
<DynamicCard 
           img={g1}
           title="House"
           footer="Select House"
           link="/tourist/bookhouse"
           width="20rem"
          />
<DynamicCard 
           img="https://th.bing.com/th/id/R.9e2d5876320bfc3e4c247cf94cce9719?rik=asw%2bFVuvIl%2bCGA&riu=http%3a%2f%2fwww.oohmyguide.com%2fuploads%2fimages%2f20200704153306735520.jpg&ehk=Wp8BzdrH1wpK3T7%2fy0o5LLxsw1D39km%2f1DcfzHYVnF0%3d&risl=&pid=ImgRaw&r=0"
           title="Hotel"
           footer="Select Hotel"
           link="/tourist/bookhouse"
           width="20rem"
          />
        




</div>
  </div>
</div>
    </div>
  )
}

export default SelfTravel

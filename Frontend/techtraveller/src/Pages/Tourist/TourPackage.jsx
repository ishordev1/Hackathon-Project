import React from 'react'
import Card from '../../Component/Card'
import g1 from '../../image/Home/uk.png'
import g2 from '../../image/Home/book-img.png'
import g3 from '../../image/Home/italy.png'
import g4 from '../../image/Home/pakistan.png'
import DynamicCard from '../../Component/user/DynamicCard'

const TourPackage = () => {
  return (

    <div className="container-fluid">
      <div className="row">
        <div className="container d-flex justify-content-around mt-4" >
          <div className="">


            <form action="">
              <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="search Here" aria-label="Recipient's username" aria-describedby="button-addon2" />
              </div>
            </form>
          </div>
          <div className="">
            <h3>sort</h3>
          </div>

        </div>
        <div className="container d-flex justify-content-center flex-wrap ">
          <DynamicCard
            address="Nepal"

            img={g1}
            title="Beautiful Beach Resort"
            rating={4.5}
            price={200}
            footer="Book Now"
             link="/tourist/bookpackage"
            width="20rem"
          />
          <DynamicCard

            address="Nepal"
            img={g2}
            title="Beautiful Beach Resort"
            rating={4.5}
            price={200}
            footer="Book Now"
          link="/tourist/bookpackage"
            width="20rem"
          />
          <DynamicCard
            img={g3}
            title="Beautiful Beach Resort"
            rating={4.5}
            address="Nepal"
            price={200}
            footer="Book Now"
         link="/tourist/bookpackage"
            width="20rem"
          />
          <DynamicCard
            img={g4}
            title="Beautiful Beach Resort"
            rating={4.5}
            address="Nepal"
            price={200}
            footer="Book Now"
            link="/tourist/bookpackage"
            width="20rem"
          />




        </div>
      </div>
    </div>
  )
}

export default TourPackage

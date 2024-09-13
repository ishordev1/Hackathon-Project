import React from 'react'
import DynamicCard from '../../Component/user/DynamicCard'
import Profile from '../../Component/user/Profie'

const BookTourGuideMain = () => {
  return (
    <div className="container-fluid">
      <div className="row">

        <div className="container d-flex justify-content-around mt-4" >
          <div className="">


            <form action="">
              <div class="input-group mb-3">
                <input type="date" className="form-control mx-3" placeholder="choose Date" aria-label="Recipient's username" aria-describedby="button-addon2" />
                <input type="text" className="form-control" placeholder="search address Here" aria-label="Recipient's username" aria-describedby="button-addon2" />
                <button className='btn-sm'>search</button>
              </div>
            </form>
          </div>
          <div className="">
            <h3>sort</h3>
          </div>

        </div>
        <div className="container d-flex justify-content-center flex-wrap ">

          <Profile
            image="https://codingyaar.com/wp-content/uploads/bootstrap-profile-card-image.jpg"
            location="Nepal / Kathmandu"
            name="Kumar Yadav"
            rating="4.5"
            price="500"
            address="delhi"
            link="/tourist/tourguidebooknowpage"
          />
          <Profile
            image="https://codingyaar.com/wp-content/uploads/bootstrap-profile-card-image.jpg"
            location="Nepal / Kathmandu"
            name="Kumar Yadav"
            rating="4.5"
            price="500"
            address="delhi"
            link="/tourist/tourguidebooknowpage"
          />
          <Profile
            image="https://codingyaar.com/wp-content/uploads/bootstrap-profile-card-image.jpg"
            location="Nepal / Kathmandu"
            name="Kumar Yadav"
            rating="4.5"
            price="500"
            address="delhi"
            link="/tourist/tourguidebooknowpage"
          />


        </div>
      </div>
    </div>
  )
}

export default BookTourGuideMain

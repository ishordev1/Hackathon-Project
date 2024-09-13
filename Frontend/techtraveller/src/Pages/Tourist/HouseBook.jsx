import React from 'react'
import DynamicCard from '../../Component/user/DynamicCard'

function HouseBook() {
  return (
    <div className="container-fluid">
            <div className="row">
                <div className="container text-center mt-3">
                    <h1>choose any House</h1>
                </div>
                <div className="container d-flex justify-content-around" >
                    <div className="m-2">
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

                    <DynamicCard
                        img="https://wallup.net/wp-content/uploads/2019/09/389794-2015-650s-car-mclaren-orange-tarocco-spider-supercar-vehicle-wallpaper.jpg"
                        title="Tour Guide"
                        footer="Select Tour Guide"
                        link="/tourist/bookhousenow"
                        width="20rem"
                    />
                    <DynamicCard
                        img="https://wallup.net/wp-content/uploads/2019/09/389794-2015-650s-car-mclaren-orange-tarocco-spider-supercar-vehicle-wallpaper.jpg"
                        title="Tour Guide"
                        footer="Select Tour Guide"
                        link="/tourist/bookhousenow"
                        width="20rem"
                    />
                    <DynamicCard
                        img="https://wallup.net/wp-content/uploads/2019/09/389794-2015-650s-car-mclaren-orange-tarocco-spider-supercar-vehicle-wallpaper.jpg"
                        title="Tour Guide"
                        footer="Select Tour Guide"
                        link="/tourist/bookhousenow"
                        width="20rem"
                    />
                    <DynamicCard
                        img="https://wallup.net/wp-content/uploads/2019/09/389794-2015-650s-car-mclaren-orange-tarocco-spider-supercar-vehicle-wallpaper.jpg"
                        title="Tour Guide"
                        footer="Select Tour Guide"
                        link="/tourist/bookhousenow"
                        width="20rem"
                    />
                  

                </div>
            </div>
        </div>
  )
}

export default HouseBook

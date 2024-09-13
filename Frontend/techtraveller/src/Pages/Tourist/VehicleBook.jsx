import React from 'react'
import DynamicCard from '../../Component/user/DynamicCard'
import g1 from '../../image/Home/g2.png'

const VehicleBook = () => {
    return (
        <div className="container-fluid">
            <div className="row">
                <div className="container text-center mt-3">
                    <h1>choose any vehicle</h1>
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
                        link="/tourist/bookvehiclenow"
                        width="20rem"
                    />
                    <DynamicCard
                        img="https://th.bing.com/th/id/OIP.Rk5t3WYp-PyRfM6c_Z0i6QHaEi?rs=1&pid=ImgDetMain"
                        title="Tour Guide"
                        footer="Select Tour Guide"
                        link="/tourist/bookvehiclenow"
                        width="20rem"
                    />
                    <DynamicCard
                        img="https://th.bing.com/th/id/OIP.XGk9YknrIbjMEOwLslpI2wHaE7?rs=1&pid=ImgDetMain"
                        title="Tour Guide"
                        footer="Select Tour Guide"
                         link="/tourist/bookvehiclenow"
                        width="20rem"
                    />
                    <DynamicCard
                        img={g1}
                        title="Tour Guide"
                        footer="Select Tour Guide"
                        link="/tourist/bookvehiclenow"
                        width="20rem"
                    />


                </div>
            </div>
        </div>
    )
}

export default VehicleBook

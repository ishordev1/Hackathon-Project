import React from 'react'

const TourGuidHome = () => {
    return (
        <div>
            <div className="container-fluid">
                <div className="row">
                    <div className="container justify-content-center d-flex flex-wrap">
                        <div className="">
                            <div className="m-3">
                                <div className="card" style={{ width: "18rem" }}>
                                    <img style={{ width: "18rem", height: "18rem", overflow: 'hidden' }} src="https://i.pinimg.com/originals/e0/05/39/e0053981f58ddb9e3bb26de08766c999.jpg" class="card-img-top" alt="..." />
                                    <div className="card-body">
                                        <h5 className="card-title">Add Tour Package</h5>
                                        <div className="container text-center">
                                            <a href="/guide/addtourpackage" class="btn btn-primary">add</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="">
                            <div className="m-3">
                                <div className="card" style={{ width: "18rem" }}>
                                    <img style={{ width: "18rem", height: "18rem", overflow: 'hidden' }} src="https://th.bing.com/th/id/OIP.ZPvwSriCQF3Y65TAAvoavQAAAA?rs=1&pid=ImgDetMain" class="card-img-top" alt="..." />
                                    <div className="card-body">
                                        <h5 className="card-title">Booking Details</h5>
                                        <div className="container text-center">
                                            <a href="/guide/alldetails" class="btn btn-primary">Show Details</a>

                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div className="">
                            <div className="m-3">
                                <div className="card" style={{ width: "18rem" }}>
                                    <img style={{ width: "18rem", height: "18rem", overflow: 'hidden' }} src="https://www.shutterstock.com/image-photo/illustration-travel-concept-plane-famous-260nw-2329937983.jpg" class="card-img-top" alt="..." />
                                    <div className="card-body">
                                        <h5 className="card-title">Manage Package</h5>
                                        <div className="container text-center">
                                            <a href="/guide/managePackage" class="btn btn-primary">Show package</a>

                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    )
}

export default TourGuidHome

import React, { useEffect, useState } from 'react';
import { getAllTourPackageById, getTourGuideByEmail } from '../../service/TourGuideService';
import { getCurrentUserDetails } from '../../auth/Index';
import  img  from '../../image/Home/g4.png';

const ManagePackage = () => {
  const [tourPackages, setTourPackages] = useState([]);  // useState to store tour package
  const [guideId, setGuideId] = useState(undefined);

  useEffect(() => {
    const userEmail = getCurrentUserDetails().email;

    // Get tour guide ID by email
    getTourGuideByEmail(userEmail)
      .then((res) => {
        setGuideId(res.id);
        // console.log("Tour Guide ID:", res.id);
      })
      .catch((error) => {
        console.log("Error fetching tour guide by email:", error);
      });

   
    if (guideId) {
      getAllTourPackageById(guideId)
        .then((res) => {
          setTourPackages(res);  
        //   console.log("Tour packages:", res);
        })
        .catch((error) => {
          console.log("Error fetching tour packages:", error);
        });
    }
  }, [guideId]);  
  
  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Manage Tour Packages</h2>
      <div className="row">
        {tourPackages.map((tourPackage) => (
          <div className="col-md-4" key={tourPackage.tourPackageId}>
            <div className="card mb-4">
              <img 
                src={img} 
                className="card-img-top" 
                alt="Tour Package" 
                style={{ height: '200px', objectFit: 'cover' }}
              />
              <div className="card-body">
                <h5 className="card-title">{tourPackage.packageName}</h5>
                <p className="card-text">
                  <i className="fa-sharp fa-solid fa-location-dot"></i> {tourPackage.destination}
                </p>
                <p className="card-text">
                  <strong>Price:</strong> ${tourPackage.pricePerPerson}
                </p>
                <p className="card-text">
                  <strong>Duration:</strong> {tourPackage.durationDays} days
                </p>
                <button className="btn btn-warning w-100">
                  <i className="fas fa-edit"></i> Edit
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default ManagePackage;

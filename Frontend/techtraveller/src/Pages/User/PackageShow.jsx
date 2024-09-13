import React, { useEffect, useState } from 'react';
import { getAllTourPackage } from '../../service/TourGuideService';
import DynamicCard from '../../Component/user/DynamicCard';
import img from '../../image/Home/india.png';


const PackageShow = () => {
  const [tourPackages, setTourPackages] = useState([]); // useState to store data

  useEffect(() => {
    getAllTourPackage()
      .then((res) => {
        setTourPackages(res); // Store the response in state
      })
      .catch((error) => {
        console.log("Error:", error);
      });
  }, []);

  return (
    <div className="container mt-4">
    <h1 className="mb-4">Tour Packages</h1>
    <div className="row">
      {tourPackages.length > 0 ? (
        tourPackages.map((tourPackage, index) => (
          <div key={index} className="col-md-4 mb-4">
            <DynamicCard
              title={tourPackage.packageName}
              address={tourPackage.destination}
              price={tourPackage.pricePerPerson}
              rating={4.5}  // Static rating for now, can be dynamic if available
              footer="Book Now"
              link={`/packages/${tourPackage.tourPackageId}`}  // Optional: link to detailed package page
              img={img}
              alt={tourPackage.packageName}  // Alt text for the image
            />
          </div>
        ))
      ) : (
        <p>No tour packages available.</p>
      )}
    </div>
  </div>
  );
};

export default PackageShow;

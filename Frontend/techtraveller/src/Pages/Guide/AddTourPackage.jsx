import React, { useEffect, useState } from 'react'
import { createTourPackage, getTourGuideByEmail } from '../../service/TourGuideService';
import { toast } from 'react-toastify';
import { getCurrentUserDetails, getToken, isTourGuide } from '../../auth/Index';

const AddTourPackage = () => {
    const [packageDetails, setPackageDetails] = useState({
        packageName: '',
        destination: '',
        durationDays: '',
        pricePerPerson: '',
        startDate: '',
        endDate: '',
        description: '',
        pickupLocation: '',
        numberOfSeats: '',
        availabilityStatus: "AVAILABLE",
        language: '',
        transportationMode: '',
        activities: ''
        
      });
    
      const handleChange = (event, property) => {
        setPackageDetails({ ...packageDetails, [property]: event.target.value });
      };
    
 const [guideId,setGuideId]=useState(undefined)

    useEffect(() => {
       
        const userEmail=getCurrentUserDetails().email;
        getTourGuideByEmail(userEmail).then((res)=>{
            setGuideId(res.id)
          }).catch((error)=>{
            console.log(error);
            
          })
      }, [])
    



          
      const submitForm = (event) => {
        event.preventDefault();
    
       createTourPackage(guideId,packageDetails).then((res)=>{
        console.log(res)
        toast.success("package created successfully")
       }).catch((error)=>{
        console.log(error);
        
        toast.error("something went wrong...")
       })
console.log(packageDetails);

       
    
   
      };
  return (
    <div className="container">
    <div className="row justify-content-center">
      <div className="col-md-8 mt-4">
        <div className="card m-3 p-3">
          <div className="card-header">
            <h2 className="text-center mb-4">Create Tour Package</h2>
          </div>
          <form onSubmit={submitForm}>
            <div className="row">
              <div className="col-md-6 mb-3">
                <label htmlFor="packageName" className="form-label">Package Name</label>
                <input
                  onChange={(e) => handleChange(e, 'packageName')}
                  value={packageDetails.packageName}
                  type="text"
                  className="form-control"
                  id="packageName"
                  placeholder="Enter package name"
                />
              </div>
              <div className="col-md-6 mb-3">
                <label htmlFor="destination" className="form-label">Destination</label>
                <input
                  onChange={(e) => handleChange(e, 'destination')}
                  value={packageDetails.destination}
                  type="text"
                  className="form-control"
                  id="destination"
                  placeholder="Enter destination"
                />
              </div>
            </div>

            <div className="row">
              <div className="col-md-6 mb-3">
                <label htmlFor="durationDays" className="form-label">Duration (Days)</label>
                <input
                  onChange={(e) => handleChange(e, 'durationDays')}
                  value={packageDetails.durationDays}
                  type="number"
                  className="form-control"
                  id="durationDays"
                  placeholder="Enter duration in days"
                />
              </div>
              <div className="col-md-6 mb-3">
                <label htmlFor="pricePerPerson" className="form-label">Price per Person ($)</label>
                <input
                  onChange={(e) => handleChange(e, 'pricePerPerson')}
                  value={packageDetails.pricePerPerson}
                  type="number"
                  className="form-control"
                  id="pricePerPerson"
                  placeholder="Enter price per person"
                />
              </div>
            </div>

            <div className="row">
              <div className="col-md-6 mb-3">
                <label htmlFor="startDate" className="form-label">Start Date</label>
                <input
                  onChange={(e) => handleChange(e, 'startDate')}
                  value={packageDetails.startDate}
                  type="datetime-local"
                  className="form-control"
                  id="startDate"
                />
              </div>
              <div className="col-md-6 mb-3">
                <label htmlFor="endDate" className="form-label">End Date</label>
                <input
                  onChange={(e) => handleChange(e, 'endDate')}
                  value={packageDetails.endDate}
                  type="datetime-local"
                  className="form-control"
                  id="endDate"
                />
              </div>
            </div>

            <div className="row">
              <div className="col-md-6 mb-3">
                <label htmlFor="pickupLocation" className="form-label">Pickup Location</label>
                <input
                  onChange={(e) => handleChange(e, 'pickupLocation')}
                  value={packageDetails.pickupLocation}
                  type="text"
                  className="form-control"
                  id="pickupLocation"
                  placeholder="Enter pickup location"
                />
              </div>
              <div className="col-md-6 mb-3">
                <label htmlFor="numberOfSeats" className="form-label">Number of Seats</label>
                <input
                  onChange={(e) => handleChange(e, 'numberOfSeats')}
                  value={packageDetails.numberOfSeats}
                  type="number"
                  className="form-control"
                  id="numberOfSeats"
                  placeholder="Enter available seats"
                />
              </div>
            </div>

            <div className="row">
              <div className="col-md-6 mb-3">
                <label htmlFor="language" className="form-label">Language</label>
                <input
                  onChange={(e) => handleChange(e, 'language')}
                  value={packageDetails.language}
                  type="text"
                  className="form-control"
                  id="language"
                  placeholder="Enter language"
                />
              </div>
              <div className="col-md-6 mb-3">
                <label htmlFor="transportationMode" className="form-label">Transportation Mode</label>
                <input
                  onChange={(e) => handleChange(e, 'transportationMode')}
                  value={packageDetails.transportationMode}
                  type="text"
                  className="form-control"
                  id="transportationMode"
                  placeholder="Enter transportation mode"
                />
              </div>
            </div>

            <div className="mb-3">
              <label htmlFor="activities" className="form-label">Activities</label>
              <input
                onChange={(e) => handleChange(e, 'activities')}
                value={packageDetails.activities}
                type="text"
                className="form-control"
                id="activities"
                placeholder="Enter activities"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="description" className="form-label">Description</label>
              <textarea
                onChange={(e) => handleChange(e, 'description')}
                value={packageDetails.description}
                className="form-control"
                id="description"
                placeholder="Enter package description"
              />
            </div>

            <div className="d-grid gap-2">
              <button type="submit" className="btn btn-primary">Submit</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  )
}

export default AddTourPackage

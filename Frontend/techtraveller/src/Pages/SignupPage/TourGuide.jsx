import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { TourGuidesignUp } from '../../service/Login-Service';

const TourGuide = () => {
  const [loginDetails, setLoginDetails] = useState({
    role: 'TOURGUIDE',
    email: '',
    password: '',
    phoneNumber: '',
    gender: '',
    address: '',
    idProof: '',
    experience: '',
    description: '',
    pricePerDay: '',
    language: '',
    availabilityStatus: 'AVAILABLE'
  });

  const handleChange = (event, property) => {
    setLoginDetails({ ...loginDetails, [property]: event.target.value });
  };

  const navigate = useNavigate();

  const submitForm = (event) => {
    event.preventDefault();
    const data = {
      user: {
        email: loginDetails.email,
        password: loginDetails.password,
        role: loginDetails.role
      },
      phoneNumber: loginDetails.phoneNumber,
      gender: loginDetails.gender,
      address: loginDetails.address,
      idProof: loginDetails.idProof,
      experience: loginDetails.experience,
      description: loginDetails.description,
      pricePerDay: loginDetails.pricePerDay,
      language: loginDetails.language,
      availabilityStatus: loginDetails.availabilityStatus
    };

    // Call the API and handle response
    TourGuidesignUp(data)
      .then((res) => {
        console.log(res);
        navigate('/signin');
        toast.success("Successfully registered user!");
      })
      .catch((error) => {
        toast.error("User data is invalid.");
        console.log(error);
      });
  };

  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-5 mt-4">
          <div className="card m-3 p-3">
            <div className="card-header">
              <h2 className="text-center mb-4">Tour Guide Signup Form</h2>
            </div>
            <form onSubmit={submitForm}>
              <div className="mb-3">
                <label htmlFor="email" className="form-label">Email address</label>
                <input
                  onChange={(e) => handleChange(e, 'email')}
                  value={loginDetails.email}
                  type="email"
                  className="form-control"
                  id="email"
                  placeholder="Enter email"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="password" className="form-label">Password</label>
                <input
                  onChange={(e) => handleChange(e, 'password')}
                  value={loginDetails.password}
                  type="password"
                  className="form-control"
                  id="password"
                  placeholder="Enter password"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="phoneNumber" className="form-label">Phone Number</label>
                <input
                  onChange={(e) => handleChange(e, 'phoneNumber')}
                  value={loginDetails.phoneNumber}
                  type="tel"
                  className="form-control"
                  id="phoneNumber"
                  placeholder="Enter phone number"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="gender" className="form-label">Gender</label>
                <select
                  id="gender"
                  className="form-select"
                  value={loginDetails.gender}
                  onChange={(e) => handleChange(e, 'gender')}
                >
                  <option value="" disabled>Select Gender</option>
                  <option value="Male">Male</option>
                  <option value="Female">Female</option>
                </select>
              </div>
              <div className="mb-3">
                <label htmlFor="address" className="form-label">Address</label>
                <input
                  onChange={(e) => handleChange(e, 'address')}
                  value={loginDetails.address}
                  type="text"
                  className="form-control"
                  id="address"
                  placeholder="Enter address"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="idProof" className="form-label">ID Proof</label>
                <select
                  id="idProof"
                  className="form-select"
                  value={loginDetails.idProof}
                  onChange={(e) => handleChange(e, 'idProof')}
                >
                  <option value="" disabled>Select ID Proof</option>
                  <option value="PAN_CARD">PAN Card</option>
                  <option value="AADHAR_CARD">Aadhar Card</option>
                  <option value="DRIVING_LICENSE">DRIVING_LICENSE</option>
                </select>
              </div>
              <div className="mb-3">
                <label htmlFor="experience" className="form-label">Experience</label>
                <textarea
                  onChange={(e) => handleChange(e, 'experience')}
                  value={loginDetails.experience}
                  className="form-control"
                  id="experience"
                  placeholder="Describe your experience"
                ></textarea>
              </div>
              <div className="mb-3">
                <label htmlFor="description" className="form-label">Description</label>
                <textarea
                  onChange={(e) => handleChange(e, 'description')}
                  value={loginDetails.description}
                  className="form-control"
                  id="description"
                  placeholder="Describe yourself"
                ></textarea>
              </div>
              <div className="mb-3">
                <label htmlFor="pricePerDay" className="form-label">Price Per Day</label>
                <input
                  onChange={(e) => handleChange(e, 'pricePerDay')}
                  value={loginDetails.pricePerDay}
                  type="number"
                  className="form-control"
                  id="pricePerDay"
                  placeholder="Enter price per day"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="language" className="form-label">Language</label>
                <input
                  onChange={(e) => handleChange(e, 'language')}
                  value={loginDetails.language}
                  type="text"
                  className="form-control"
                  id="language"
                  placeholder="Enter spoken languages"
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
  );
};

export default TourGuide;

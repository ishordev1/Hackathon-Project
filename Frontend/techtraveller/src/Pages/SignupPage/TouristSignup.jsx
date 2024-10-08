import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { TouristsignUp } from '../../service/Login-Service';

const TouristSignup = () => {
  const [loginDetails, setLoginDetails] = useState({
    gender: '',
    email: '',
    password: '',
    phone: '',
    address: '',
    name: ''
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
        role:"TOURIST"
      },
      name: loginDetails.name,
      email: loginDetails.email,
      phoneNumber: loginDetails.phone,
      gender: loginDetails.gender,  
      address: loginDetails.address,
      nationality: "Canadian" 
    };
    
    TouristsignUp(data).then((res) => {
      console.log(res)
      navigate('/signin');
      toast.success("Successfully register user. !! user id:" )
  })
      .catch((error) => {
          toast.error("User data are invalid..")
          console.log(error)
      })
  };


  return (
   
    <div className="container">
      {JSON.stringify(loginDetails)}
      <div className="row justify-content-center">
        <div className="col-md-5 mt-4">
          <div className="card m-3 p-3">
            <div className="card-header">
              <h2 className="text-center mb-4">Tourist Signup Form</h2>
            </div>
            <form onSubmit={submitForm}>
              <div className="mb-3">
                <label htmlFor="gender" className="form-label">Select Gender</label>
                <select
                  id="gender"
                  className="form-select"
                  value={loginDetails.gender}
                  onChange={(e) => handleChange(e, 'gender')}  // Correctly binding gender change
                >
                  <option value="" disabled>Select Gender</option>
                  <option value="male">Male</option>
                  <option value="female">Female</option>
                </select>
              </div>
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
                <label htmlFor="name" className="form-label">Name</label>
                <input
                  onChange={(e) => handleChange(e, 'name')}
                  value={loginDetails.name}
                  type="text"
                  className="form-control"
                  id="name"
                  placeholder="Enter name"
                />
              </div>
              <div className="mb-3">
                <label htmlFor="phone" className="form-label">Phone number</label>
                <input
                  onChange={(e) => handleChange(e, 'phone')}
                  value={loginDetails.phone}
                  type="tel"
                  className="form-control"
                  id="phone"
                  placeholder="Enter phone number"
                />
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

export default TouristSignup;

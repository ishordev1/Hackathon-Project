import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

const TourGuide = () => {
    const [loginDetails, setLoginDetails] = useState({
      role: '',
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
  
     
        //error aayega to then nahi chalega to isi liye catch block
        
    };
  
    return (
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-5 mt-4">
            {JSON.stringify(loginDetails)}
            <div className="card m-3 p-3">
              <div className="card-header">
                <h2 className="text-center mb-4">TourGuide Signup Form</h2>
              </div>
              <form onSubmit={submitForm}>
                <div className="mb-3">
                  <label htmlFor="role" className="form-label">Choose Role</label>
                  <select
                    id="role"
                    className="form-select"
                    value={loginDetails.role}
                    onChange={(e) => handleChange(e, 'role')}
                  >
                    <option value="" disabled>Select Role</option>
                    <option value="tourist">Tourist</option>
                    <option value="admin">Admin</option>
                    <option value="tourguide">Tour Guide</option>
                    <option value="vehicleprovider">Vehicle Provider</option>
                    <option value="homeprovider">Home Provider</option>
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
    )
  }
export default TourGuide

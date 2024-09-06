import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const Signin = () => {
  const [loginDetails, setLoginDetails] = useState({
    role: '',
    email: '',
    password: ''
  });

  const handleChange = (event, property) => {
    setLoginDetails({ ...loginDetails, [property]: event.target.value });
  };

  const navigate = useNavigate();

  return (
    <>
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-5 mt-4">
            {JSON.stringify(loginDetails)}
            <div className="card m-3 p-3">
              <div className="card-header">
                <h2 className="text-center mb-4">Login Form</h2>
              </div>
              <form>
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
                    placeholder="Password"
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
    </>
  )
}

export default Signin;

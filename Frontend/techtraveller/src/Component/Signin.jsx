import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import { loginUser } from '../service/Login-Service';
import { doLogin } from '../auth/Index';

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

  const submitForm = async (event) => {
    event.preventDefault(); // Prevent default form submission
    try {
      const jwtTokenData = await loginUser(loginDetails);
      toast.success("Login successful");

      await doLogin(jwtTokenData, () => {
        // Navigate first, then reload the page
        if (loginDetails.role === "TOURIST") {
          navigate('/tourist/home');
        } else if (loginDetails.role === "TOURGUIDE") {
          navigate('/guide/home');
        } else {
          navigate('/admin/home');
        }
        // Trigger page reload after navigating
        setTimeout(() => {
          window.location.reload();
        }, 0);
      });
    } catch (error) {
      toast.error("Error occurred during login");
    }
  };

  return (
    <>
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-5 mt-4">
            {/* {JSON.stringify(loginDetails)} */}
            <div className="card m-3 p-3">
              <div className="card-header">
                <h2 className="text-center mb-4">Login Form</h2>
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
                    <option value="TOURIST">Tourist</option>
                    <option value="ADMIN">Admin</option>
                    <option value="TOURGUIDE">Tour Guide</option>
                    <option value="VEHICLEPROVIDER">Vehicle Provider</option>
                    <option value="HOMEPROVIDER">Home Provider</option>
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

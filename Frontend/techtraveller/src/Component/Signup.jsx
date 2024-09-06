import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const Signup = () => {
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

    const { role } = loginDetails;

    // Navigate based on the selected role
    if (role === 'tourist') {
      navigate('/signup/tourist');
    } else if (role === 'admin') {
      navigate('/signup/admin');
    } else if (role === 'tourguide') {
      navigate('/signup/tourguide');
    } else if (role === 'vehicleprovider') {
      navigate('/signup/vehicleprovider');
    } else if (role === 'homeprovider') {
      navigate('/signup/homeprovider');
    }
  };

  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-5 mt-4">
          {JSON.stringify(loginDetails)}
          <div className="card m-3 p-3">
            <div className="card-header">
              <h2 className="text-center mb-4">Tourist Signup Form</h2>
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

export default Signup;

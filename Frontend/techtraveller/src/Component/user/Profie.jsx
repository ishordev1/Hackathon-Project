import React from 'react';
import './Profile.css';

const Profile = ({ image, location, name, rating, price, link }) => {
  return (
    <div>
      <div className="card card-profile m-2" style={{ width: '18rem' }}>
        {image && <img src={image} className="card-img-top-profile" alt="Profile" />}
        <div className="card-body">
          {location && <p className="card-text"><i className="fa-sharp fa-solid fa-location-dot"></i> {location}</p>}
          {name && <h5 className="card-title">{name}</h5>}
          {rating && (
            <p className="card-text m-0">
              <i className="fas fa-star text-warning"></i> {rating} / 5
            </p>
          )}
          {price && <p className="card-text m-0">Price: ${price} per/Day</p>}
          <hr />
          {link ? (
            <a href={link} className="btn btn-primary m-0">Book Now</a>
          ) : (
            <button className="btn btn-primary m-0" disabled>Book Now</button>
          )}
        </div>
      </div>
    </div>
  );
};

export default Profile;

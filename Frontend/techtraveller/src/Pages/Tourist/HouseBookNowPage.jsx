import React from 'react'

const HouseBookNowPage = () => {
  return (
    <div>
    <div className="container">
        <div className="row  m-4">
            <div className="col-md-4">
                <div className="card">
                    <div className="card-header">
                        <h3 className='text-center'>Details House</h3>
                        <img src="https://codingyaar.com/wp-content/uploads/bootstrap-profile-card-image.jpg" class="card-img-top" alt="..." />
                        <div className="card-body">
                         
                            <p className="card-text m-0">Email:</p>
                            <p className="card-text m-0">phone Number:</p>
                            <p className="card-text m-0">price per Day:</p>
                            <p className="card-text m-0"><i class="fa-sharp fa-solid fa-location-dot"></i>Address:</p>
                            <p className="card-text m-0">Rating:</p>
                        </div>
                    </div>
                </div>
                
            </div>
            <div className="col-md-8 bg-light">
<div className="container text-center ">
<h1>Book House</h1>
<hr />
<div className="card">
<div className="booking-form" style={{textAlign:"left"}}>
<form id="accommodation-form">
  <div className="form-group">
    <label htmlFor="accom-destination">Destination:</label>
    <input type="text" id="accom-destination" name="accom-destination" placeholder="e.g., Rome, Italy" required />
  </div>

  <div className="mb-3">
        <label htmlFor="role" className="form-label">Choose City</label>
        <select
          id="role"
          className="form-select"
        >
          <option value="" disabled>Select City</option>
          <option value="tourist">delhi</option>
          <option value="admin">panjabh</option>
          <option value="tourguide">Gujarat</option>
        </select>
      </div>
  <div className="form-group">
    <label htmlFor="accom-checkin">Check-in Date:</label>
    <input type="date" id="accom-checkin" name="accom-checkin" required />
  </div>
  <div className="form-group">
    <label htmlFor="accom-checkout">Check-out Date:</label>
    <input type="date" id="accom-checkout" name="accom-checkout" required />
  </div>
  <div className="form-group">
    <label htmlFor="accom-guests">No of Person:</label>
    <input type="number" id="accom-guests" name="accom-guests" min={1} defaultValue={1} required />
  </div>
 <div className="container text-center">
 <button type="submit" className="btn">Book</button>
 </div>
</form>
<div id="accommodation-results" />
</div>
</div>


</div>
            </div>
            <div className="card p-0">
                <div className="card-body  bg-primary">
                    <h1 className='text-center'>FeedBack</h1>
                </div>
            
            </div>
        </div>
    </div>
</div>
  )
}

export default HouseBookNowPage

import React from 'react'
import Card from '../../Component/Card'
import sample1 from '../../image/Home/uk.png'
import Slider from '../../Component/Slider'


const Home = () => {
  return (
    <>
{/* home start */}
<div>
  {/* Home Section */}
  <section id="home" className="section">
    <div className="hero">
      <h2>Explore the World with Ease</h2>
      <p>Your ultimate travel companion for personalized and sustainable journeys.</p>
      <a href="#itinerary" className="btn">Plan Your Trip</a>
    </div>
  </section>
  
  <div className="container">
    
  {/* Itinerary Planner Section */}
  <section id="itinerary" className="section">
    <h2>Itinerary Planner</h2>
    <form id="itinerary-form">
      <div className="form-group">
        <label htmlFor="destination">Destination:</label>
        <input type="text" id="destination" name="destination" placeholder="e.g., Paris, France" required />
      </div>
      <div className="form-group">
        <label htmlFor="start-date">Start Date:</label>
        <input type="date" id="start-date" name="start-date" required />
      </div>
      <div className="form-group">
        <label htmlFor="end-date">End Date:</label>
        <input type="date" id="end-date" name="end-date" required />
      </div>
      <div className="form-group">
        <label htmlFor="preferences">Preferences:</label>
        <select id="preferences" name="preferences" multiple>
          <option value="adventure">Adventure</option>
          <option value="culture">Culture</option>
          <option value="relaxation">Relaxation</option>
          <option value="food">Food &amp; Dining</option>
          <option value="nightlife">Nightlife</option>
        </select>
      </div>
      <button type="submit" className="btn">Generate Itinerary</button>
    </form>
    <div id="itinerary-results" />
  </section>
  {/* Booking Section */}
  <section id="booking" className="section">
    <h2>Book Your Travel</h2>
    <div className="booking-options">
      {/* Accommodation Booking Form */}
      <div className="booking-form">
        <h3>Accommodation</h3>
        <form id="accommodation-form">
          <div className="form-group">
            <label htmlFor="accom-destination">Destination:</label>
            <input type="text" id="accom-destination" name="accom-destination" placeholder="e.g., Rome, Italy" required />
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
            <label htmlFor="accom-guests">Guests:</label>
            <input type="number" id="accom-guests" name="accom-guests" min={1} defaultValue={1} required />
          </div>
          <button type="submit" className="btn">Search Accommodations</button>
        </form>
        <div id="accommodation-results" />
      </div>
      {/* Flight Booking Form */}
      <div className="booking-form">
        <h3>Flights</h3>
        <form id="flight-form">
          <div className="form-group">
            <label htmlFor="flight-from">From:</label>
            <input type="text" id="flight-from" name="flight-from" placeholder="e.g., New York" required />
          </div>
          <div className="form-group">
            <label htmlFor="flight-to">To:</label>
            <input type="text" id="flight-to" name="flight-to" placeholder="e.g., London" required />
          </div>
          <div className="form-group">
            <label htmlFor="flight-departure">Departure Date:</label>
            <input type="date" id="flight-departure" name="flight-departure" required />
          </div>
          <div className="form-group">
            <label htmlFor="flight-return">Return Date:</label>
            <input type="date" id="flight-return" name="flight-return" />
          </div>
          <div className="form-group">
            <label htmlFor="flight-passengers">Passengers:</label>
            <input type="number" id="flight-passengers" name="flight-passengers" min={1} defaultValue={1} required />
          </div>
          <button type="submit" className="btn">Search Flights</button>
        </form>
        <div id="flight-results" />
      </div>
      {/* Car Rental Booking Form */}
      <div className="booking-form">
        <h3>Car Rentals</h3>
        <form id="car-form">
          <div className="form-group">
            <label htmlFor="car-location">Pickup Location:</label>
            <input type="text" id="car-location" name="car-location" placeholder="e.g., Los Angeles Airport" required />
          </div>
          <div className="form-group">
            <label htmlFor="car-pickup">Pickup Date:</label>
            <input type="date" id="car-pickup" name="car-pickup" required />
          </div>
          <div className="form-group">
            <label htmlFor="car-dropoff">Drop-off Date:</label>
            <input type="date" id="car-dropoff" name="car-dropoff" required />
          </div>
          <button type="submit" className="btn">Search Cars</button>
        </form>
        <div id="car-results" />
      </div>
    </div>
  </section>
  {/* Support Section */}
  <section id="support" className="section">
    <h2>24/7 Customer Support</h2>
    <p>We're here to help you anytime, anywhere.</p>
    <button id="chat-support" className="btn">Chat with Support</button>
    <div id="chat-box" className="chat-box hidden">
      <div id="chat-messages" />
      <input type="text" id="chat-input" placeholder="Type your message..." />
    </div>
  </section>
  {/* Eco Options Section */}
  <section id="eco-options" className="section">
    <h2>Eco-Friendly Travel Options</h2>
    <p>Choose sustainable travel options and enjoy exclusive discounts.</p>
    <button id="eco-deals" className="btn">View Eco Deals</button>
    <div id="eco-results" />
  </section>
</div>

  </div>

{/* home start */}



<Slider/>
      <div className="container">
        <div className="row">

          <div className="service mt-4">
            <div className="text-center ">
              <h1>Our Service</h1>
            </div>
            <div className="service-home-card d-flex justify-content-center flex-wrap">
              <Card
                img={sample1}
                text="Delhi"
                style={{
                  width: '300px',
                  margin: '20px',
                  backgroundColor: 'lightblue',
                  borderRadius: '10px',
                }}
               
              />
              <Card
                img={sample1}
                text="Delhi"
                style={{
                  width: '300px',
                  margin: '20px',
                  backgroundColor: 'lightblue',
                  borderRadius: '10px',
                }}
              
              />
              <Card
                img={sample1}
                text="Delhi"
                style={{
                  width: '300px',
                  margin: '20px',
                  backgroundColor: 'lightblue',
                  borderRadius: '10px',
                }}
         
              />
              <Card
                img={sample1}
                text="Delhi"
                style={{
                  width: '300px',
                  margin: '20px',
                  backgroundColor: 'lightblue',
                  borderRadius: '10px',
                }}
          
              />
              <Card
                img={sample1}
                text="Delhi"
                style={{
                  width: '300px',
                  margin: '20px',
                  backgroundColor: 'lightblue',
                  borderRadius: '10px',
                }}
  
              />
              <Card
                img={sample1}
                text="Delhi"
                style={{
                  width: '300px',
                  margin: '20px',
                  backgroundColor: 'lightblue',
                  borderRadius: '10px',
                }}
             
              />
        
             

              
          
            </div>

          </div>



        </div>
      </div>
    </>
  )
}

export default Home

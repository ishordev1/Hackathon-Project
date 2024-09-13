import React from 'react'

const DynamicCard = (props) => {
    const cardStyle = {
        width: props.width || '18rem', // Customizable width with default value
        margin: '10px',
        ...props.style  // Merge custom styles from props
      };
  return (
    <div>
      <div className="card" style={cardStyle}>
        {/* Image */}
        {props.img && <img src={props.img} className="card-img-top"  style={{width: "18rem", height:"18rem", overflow:'hidden'}} alt={props.alt || 'Card image'} />}

        <div className="card-body">
          {/* Location Title */}
          {props.address &&<p className="card-text"> <i className="fa-sharp fa-solid fa-location-dot"></i>  {props.address}</p>}
          {props.title && <h5 className="card-title">{props.title}</h5>}
          
          {/* Rating */}
          {props.rating && (
            <p className="card-text">
              <i className="fas fa-star text-warning"></i> {props.rating} / 5
            </p>
          )}
<hr />
          {/* Price */}
          {props.price && (
            <p className="card-text">
              <strong>Price:</strong> ${props.price}
            </p>
          )}

          {/* Book Now Button */}
          {props.footer && (
            <a href={props.link || '#'} className="btn btn-primary w-100">
              {props.footer || 'Book Now'}
            </a>
          )}
        </div>
      </div>
    </div>
  )
}

export default DynamicCard

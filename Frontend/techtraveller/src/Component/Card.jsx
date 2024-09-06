import React from 'react'

const Card = (props) => {
    const mystyle = {
        width: props.w,
        margin: '10px',
    }
    return (
        <div>
            <div className="card" style={props.style}>
                {/* <img src={`/Img/icon/${props.img}`} className="card-img-top " alt="..." /> */}

                <img src={props.img} className="card-img-top " alt="..." />
                <div className="card-body">
                    <h3 className='text-center'>{props.text}</h3>
                    <p>{props.pragraph}</p>
                    <h4 className='text-center bg-primary text-white rounded'>{props.footer}</h4>
                </div>
            </div>
        </div>




    )
}

export default Card

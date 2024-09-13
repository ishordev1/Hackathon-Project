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
                    <h2 className=''>{props.text}</h2>
                    <p>{props.pragraph}</p>
                   <a href=""><h4 className='text-center bg-primary text-white rounded'>{props.footer}</h4></a> 
                </div>
            </div>
        </div>




    )
}

export default Card

import React from 'react';
import '../card.css';

const Card = props => {
    return (
     <div className="card text-center">
       <div className="overflow">
        <img src={props.imgs} alt="Image 1" className="card-img-top"/>
     </div> 
      <div className="card-body text-dark">
        <h4 className="card-text text-primary">{props.title}</h4>
       <a href="#" className="btn btn-outline-success" onClick={()=> props.loadQoutes()} > Load Quotes</a>
      </div> 
     </div>
    );
}

export default Card;
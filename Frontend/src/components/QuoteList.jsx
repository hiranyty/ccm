import React from 'react';

const QuoteList = props => {
  return (
    <div>
      <div >
        <h2 className="text-primary">Crypto Currency Rates</h2>
      </div>
      <table className="table table-hover">
        <thead>
          <tr>
            <th scope="col">Time</th>
            <th scope="col">Price</th>
          </tr>
        </thead>
        <tbody>
          {props.quotelist.map(quote =>
            <tr>
              <td>{quote.tradeTime}</td>
              <td>$ {quote.price} </td>
            </tr>)}
        </tbody>
      </table>
    </div>
  );
}

export default QuoteList;


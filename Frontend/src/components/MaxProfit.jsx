import React from 'react';

const maxProfit = (props) => {
    return (
        <div>
            <div>
                <h2 className="text-primary">Maximium Profit</h2>
            </div>
            <table className="table table-hover">
                <thead>
                    <tr><th scope="col">{props.profit.code}</th></tr>
                </thead>
                <tbody>
                    <tr>
                        <td scope="col"> Buy</td>
                        <td scope="col"> Sell</td>
                    </tr>
                    <tr>
                        <td>{props.profit.buyValue}</td>
                        <td>{props.profit.sellValue}</td>
                    </tr>
                    <tr>
                        <td>{props.profit.buyTime}</td>
                        <td>{props.profit.sellTime}</td>
                    </tr>
                    <tr>
                        <td>Profit</td>
                        <td>{props.profit.maxProfit}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default maxProfit;
import React, { Component } from 'react'
import Card from './CryptoCard'
import bitcoinImage from "../assets/Bitcoin Logo.png"
import litecoinImage from "../assets/Litecoin Logo.png"
import ethereumImage from "../assets/Ethereum Logo.png"
import axios from 'axios'
import QuoteList from './QuoteList'
import MaxProfit from './MaxProfit'

class Cards extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cryptoObj: {
                currency: '',
                quotes: []
            },
            maxprofitobj: {
                code: '',
                buyValue: '',
                buyTime: '',
                sellValue: '',
                sellTime: ''
            }
        };
    }

    loadQoutes(id) {
        //console.log("Load quotes");
        axios.get(`http://localhost:8085/v1/cryptos/${id}`)
            .then(res => {
                //console.log(res.data)
                this.setState({
                    cryptoObj: res.data
                })
            }
            );

        axios.get(`http://localhost:8085/v1/maxprofit/${id}`)
            .then(res => {
                //console.log(res.data)
                this.setState({
                    maxprofitobj: res.data
                })
            }
            );
    }

    render() {
        return (
            <div>
                <div className="container-fluid d-flex justify-content-center" >
                    <div className="row">
                        <div className="col-md-4">
                            <Card imgs={bitcoinImage} title="Bitcoin" loadQoutes={this.loadQoutes.bind(this, 'BTC')} />
                        </div>
                        <div className="col-md-4">
                            <Card imgs={litecoinImage} title="Litecoin" loadQoutes={this.loadQoutes.bind(this, 'LTC')} />
                        </div>
                        <div className="col-md-4">
                            <Card imgs={ethereumImage} title="Ethereum" loadQoutes={this.loadQoutes.bind(this, 'ETH')} />
                        </div>
                    </div>

                </div>
                {this.state.cryptoObj.quotes.length > 0 && (<div className="container justify-content-center" style={{ marginTop: '40px' }}>
                    <div className="row">
                        <div className="col-md-4">
                            <QuoteList quotelist={this.state.cryptoObj.quotes} />
                        </div>
                        <div className="col-md-4 ">
                            <MaxProfit profit={this.state.maxprofitobj} />
                        </div>
                    </div>
                </div>)}

            </div>
        );
    }
}

export default Cards;
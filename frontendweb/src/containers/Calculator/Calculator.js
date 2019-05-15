import './Calculator.css';

import React from 'react';
import axios from 'axios';
import { CardPanel, Row } from 'react-materialize';
import M from "materialize-css";
class Calculator extends React.Component {
  state = {
    open: false,
    id: null,
    result: null
  };
    componentDidMount() {
        // Auto initialize all the things!
        M.AutoInit();
    }

    onClickBlock = event => {
      const tab = document.getElementsByClassName('card-panel-perso');
      if (!this.state.open) {
        const e = event.target;
        const id = e.id;
        if (e.tagName === 'DIV' && id.match(/card.*/)) {
          this.setState({
          open: true,
          id: id
          });
          for (let div of tab) {
            div.style.display = 'none';
          }
          e.style.display = 'block';
          e.style.height = '400px';
          e.style.width = '500px';
          document.getElementById('times-' + id).style.cursor = 'pointer';
          this.changeDisplay(id, 'block', 'default');
        }
      }
    };

    closeBlock = () => {
      this.setState({
        open: false
      });
      const tab = document.getElementsByClassName('card-panel-perso');
      for (let div of tab) {
        div.style.display = 'block';
        div.style.height = '150px';
        div.style.width ='200px';
      }
      this.changeDisplay(this.state.id, 'none', 'pointer');
    };

    changeDisplay = (id, status, cursor) => {
    document.getElementById('form-' + id).style.display = status;
    document.getElementById('times-' + id).style.display = status;
    document.getElementById(id).style.cursor = cursor;
    };

    handleSubmit = () => {
      const id = this.state.id;
      switch (id) {
        case 'cardTR':
          axios.get('localhost:8080/calculatorController/discountRate?net=' +
            document.getElementById('tr-pan').value +
            '&brut=' +
            document.getElementById('tr-pab').value)
            .then(res => {
              this.setState({result: res.data});
            });break;
        case 'cardPA':
          axios.get('localhost:8080/calculatorController/netBuyingPrice?brut=' +
            document.getElementById('pa-pab').value +
            '&discountRate=' +
            document.getElementById('pa-tr').value)
            .then(res => {
              this.setState({result: res.data});
            });break;
        case 'cardPV':
          axios.get('localhost:8080/calculatorController/netSellingPrice?netBuyingPrice=' +
            document.getElementById('pv-pan').value +
            '&multiplicationCoeff=' +
            document.getElementById('pv-cm').value)
            .then(res => {
              this.setState({result: res.data});
            });break;
        case 'cardCM':
          axios.get('localhost:8080/calculatorController/multiplicationCoeff?netSellingPrice=' +
            document.getElementById('cm-pv').value +
            '&netBuyingPrice=' +
            document.getElementById('cm-pan').value)
            .then(res => {
              this.setState({result: res.data});
            });break;
        default:
          this.setState({result: null});
      }

    };

  render() {
    const res = this.state.result;
    const displayResult = res !== null ? 'Résultat : '+res : null;
    return (
    <div className="container" style={{textAlign: 'center',  paddingRight: 10}}>
      <Row>
        <CardPanel onClick={this.onClickBlock} id="cardTR" href={"#modal1"} className="col s3 deep-purple accent-1 modal-trigger card-panel-perso">
          <span className="white-text flow-text" >Taux de remise</span>
          <span onClick={this.closeBlock} id="times-cardTR" style={{float: 'right', display: 'none'}}>&times;</span>
          <form id="form-cardTR" onSubmit={this.handleSubmit}>
            <div className="input-field col s6">
              <input id="tr-pan" type="number" name="tr-pan" className="validate"/>
              <label htmlFor="tr-pan">Prix d'achat net</label>
            </div>
            <div className="input-field col s6">
              <input id="tr-pab" type="number" name="tr-pab" className="validate"/>
              <label htmlFor="tr-pab">Prix d'achat brut</label>
            </div>
            <button>Calculer</button>
            {displayResult}
          </form>
        </CardPanel>
        <CardPanel onClick={this.onClickBlock} id="cardPA" className="col s3 deep-purple accent-2 card-panel-perso" href={"#modal2"} style={{marginLeft: 50}}>
          <span className="white-text flow-text">Prix d'achat</span>
          <span onClick={this.closeBlock} id="times-cardPA" style={{float: 'right', display: 'none'}}>&times;</span>
          <form id="form-cardPA">
            <div className="input-field col s6">
              <input id="pa-pab" type="number" name="pa-pab" className="validate"/>
              <label htmlFor="pa-pab">Prix d'achat brut</label>
            </div>
            <div className="input-field col s6">
              <input id="pa-tr" type="number" name="pa-tr" className="validate"/>
              <label htmlFor="pa-tr">Taux de remise</label>
            </div>
            <button>Calculer</button>
          </form>
        </CardPanel>
      </Row>
      <Row>
        <CardPanel onClick={this.onClickBlock} id="cardPV" className="col s3 deep-purple accent-3 card-panel-perso">
          <span className="white-text flow-text">Prix de vente net</span>
          <span onClick={this.closeBlock} id="times-cardPV" style={{float: 'right', display: 'none'}}>&times;</span>
          <form id="form-cardPV">
            <div className="input-field col s6">
              <input id="pv-pan" type="number" name="pv-pan" className="validate"/>
              <label htmlFor="pv-pan">Prix d'achat net</label>
            </div>
            <div className="input-field col s6">
              <input id="pv-cm" type="number" name="pv-cm" className="validate"/>
              <label htmlFor="pv-cm">Coefficient multiplicateur</label>
            </div>
            <button>Calculer</button>
          </form>
        </CardPanel>

        <CardPanel onClick={this.onClickBlock} id="cardCM" className="col s3 deep-purple accent-4 card-panel-perso" style={{marginLeft: 50 }}>
          <span className="white-text flow-text">Coefficient multiplicateur</span>
          <span onClick={this.closeBlock} id="times-cardCM" style={{float: 'right', display: 'none'}}>&times;</span>
          <form id="form-cardCM">
            <div className="input-field col s6">
              <input id="cm-pv" type="number" name="cm-pv" className="validate"/>
              <label htmlFor="cm-pv">Prix de vente net</label>
            </div>
            <div className="input-field col s6">
              <input id="cm-pan" type="number" name="cm-pan" className="validate"/>
              <label htmlFor="cm-pan">Prix d'achat net</label>
            </div>
            <button>Calculer</button>
          </form>
        </CardPanel>
      </Row>
    </div>
    )
  }
}

export default Calculator;

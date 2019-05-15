import React from 'react';
import { CardPanel,Row,Col,Container } from 'react-materialize';
import M from "materialize-css";
class Calculator extends React.Component {
    componentDidMount() {
        // Auto initialize all the things!
        M.AutoInit();
    }


  render() {
    return (

    <div className="container" style={{textAlign: 'center',  paddingRight: 10}}>

    <Row>
        <CardPanel id={"calculTauxRemise"} href={"#modal1"} className="col s3 deep-purple accent-1 modal-trigger" style={{height: 150, width: 200}}>
            <span className="white-text flow-text" >
                Taux de remise
            </span>
        </CardPanel>
        <div id="modal1" className="modal">
            <div className="modal-content">
                <h4>Taux de remise</h4>

                <div className="row">
                    <form className="col s12" onSubmit={""}>
                        <div className="row">
                            <div className="input-field col s6">
                                <input id="prixAchatNet1" type="text" className="validate"/>
                                <label htmlFor="dataOne">Prix d'achat net</label>
                            </div>
                            <div className="input-field col s6">
                                <input id="prixAchatBrut1" type="text" className="validate"/>
                                <label  htmlFor="dataTwo">Prix d'achat brut</label>
                            </div>
                        </div>
                        <button type={"submit"} className={"btn"}>Calculer</button>
                    </form>
                </div>
            </div>
            <div className="modal-footer">
                <a href="#!" className="modal-close waves-effect waves-green btn-flat">Fermer</a>
            </div>
        </div>
        <CardPanel className="col s3 deep-purple accent-2" href={"#modal2"} style={{height: 150, width: 200, marginLeft: 50}}>
          <span className="white-text flow-text">
                Prix d'achat
          </span>
        </CardPanel>
        <div id="modal2" className="modal">
            <div className="modal-content">
                <h4>Prix d'achat</h4>

                <div className="row">
                    <form className="col s12" onSubmit={""}>
                        <div className="row">
                            <div className="input-field col s6">
                                <input id="tauxRemise2" type="text" className="validate"/>
                                <label htmlFor="tauxRemise2">Taux de remise</label>
                            </div>
                            <div className="input-field col s6">
                                <input id="prixBrut2" type="text" className="validate"/>
                                <label  htmlFor="prixBrut2">Prix d'achat brut</label>
                            </div>
                        </div>
                        <button type={"submit"} className={"btn"}>Calculer</button>
                    </form>
                </div>
            </div>
            <div className="modal-footer">
                <a href="#!" className="modal-close waves-effect waves-green btn-flat">Fermer</a>
            </div>
        </div>
    </Row>
    <Row>
        <CardPanel className="col s3 deep-purple accent-3" style={{height: 150, width: 200}}>
          <span className="white-text flow-text">
                Prix de vente net
          </span>
        </CardPanel>
        <CardPanel className="col s3 deep-purple accent-4" style={{height: 150, width: 200, marginLeft: 50 }}>
          <span className="white-text flow-text">
                Coefficient multiplicateur
          </span>
        </CardPanel>
    </Row>

    </div>



    )
  }
}

export default Calculator;
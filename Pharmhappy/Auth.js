import React, {Fragment} from "react";

import {Text, View, Button, TextInput} from "react-native";

class Auth extends React.Component {
  state = {
    title: 'Sign up',
    email: '',
    password: '',
    isSignup: true,
    userId: null,
    jwtToken: null
  };

  onChangeEmail = event => {
    this.setState({
      ...this.state,
      email: event.target.value
    })
  };

  onChangePassword = event => {
    this.setState({
      ...this.state,
      password: event.target.value
    })
  };

  onClickSubmit = () => {
    const endURL = this.state.isSignup ? '/user' : '/auth/login';
    fetch('http://app-76af27ba-b48e-48d9-a763-a8a67ece4a5c.cleverapps.io' + endURL, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        email: this.state.email,
        password: this.state.password
      }),
    }).then(response => {
      console.log(response);
      if (this.state.isSignup) {
        this.setState({
          ...this.state,
          userId: response.message
        })
      } else {
        this.setState({
          ...this.state,
          jwtToken: response.token
        })
      }
    }).catch(err => {

    });
  };

  switchAuthModeHandler = () => {
    if (this.state.isSignup) {
      this.setState({
        ...this.state,
        isSignup: false,
        title: 'Log in'
      });
    } else {
      this.setState({
        ...this.state,
        isSignup: true,
        title: 'Sign up'
      });
    }
  };

  render() {
    const userId = this.state.userId !== null && this.state.userId !== '' ? <Text>User UUID : {this.state.userId}</Text> : null;
    const jwtToken = this.state.jwtToken !== null && this.state.jwtToken !== '' ? <Text>Token JWT : {this.state.jwtToken}</Text> : null;
    return (
      <Fragment>
        <View >
          <View>
            <Text style={{fontWeight: 'bold', textAlign:'center', fontSize: 24}}>{this.state.title}{"\n"}</Text>
          </View>
          <View>
            <Text>Email :</Text>
            <TextInput textContentType="emailAddress" onChange={this.onChangeEmail} value={this.state.email} />
          </View>
          <View>
            <Text>Password :</Text>
            <TextInput textContentType="password" onChange={this.onChangePassword} value={this.state.password} secureTextEntry={true}/>
          </View>
          <Button color='green' onPress={this.onClickSubmit} title={this.state.title} />
          <View>
            <Button
              onPress={this.switchAuthModeHandler}
              title={`SWITCH TO ${this.state.isSignup ? 'LOG IN' : 'SIGN UP'}`} />
          </View>
          {userId}
          {jwtToken}
        </View>
      </Fragment>
    )
  }
}

export default Auth;

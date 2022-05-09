import './App.css';
import { Component } from 'react';
import Dashboard from './components/Dashboard';
import Header from './components/Layout/Header';
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router, Route} from "react-router-dom"; 
import AddProject from './components/Project/AddProject';


class App extends Component{
  render(){
    return(
      <Router>
      <div className="App">
        <Header/>
        <Dashboard/>
        <Route exact path="/dashborad" component={Dashboard} />
        <Route exact path="/addProject" component={AddProject} />
      </div>
      </Router>
    );
  }
}

export default App;

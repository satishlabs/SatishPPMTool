import React, { Component } from 'react'

 class Header extends Component {
  render() {
    return (
        <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
        <div className="container">
            <a className="navbar-brand" href="Dashboard.html">
                Personal Project Management Tool
            </a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">
            <span className="navbar-toggler-icon"></span>
          </button>

          <div className="collapse navbar-collapse" id="mobile-nav">
   
            <ul className="navbar-nav mr-auto">
                <li className="nav-item">
                    <a className="nav-link" href="#">
                        Dashboard
                    </a>
                </li>
                <li className="nav-item">
                    <a className="nav-link" href="register.html">
                        Sing Up
                    </a>
                </li>
                <li className="nav-item">
                    <a className="nav-link disabled" href="login.html">
                        Login
                    </a>
                </li>
            </ul>
   
        </div>
        </div>
      </nav>
    )
  }
}
export default Header;

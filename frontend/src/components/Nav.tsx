import React, { Component } from "react";
import { Link } from "react-router-dom";
import '../css/Nav.css';


const Nav=() =>{
    return (
        <nav className="navbar">
            <Link className="a" to="/">Home</Link>
            <Link className="a" to="/addnewtransaction">Add new transaction</Link>
        </nav>
    );
  }
  
  export default Nav;
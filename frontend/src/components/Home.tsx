import React, { Component } from "react";
import { Link } from "react-router-dom";

function Home() {
    return (
        <>
        <h1>HOME</h1>
        <Link to="/month/january">JANUARY</Link>
        </>
    );
  }
  
  export default Home;
import React, { Component } from "react";
import { Link } from "react-router-dom";
import '../css/Home.css';
import { months } from '../Interfaces'

function Home() {
    return (
        <>
            <h1>Welcome to your Budget App!</h1>

            <div className="page-conent">
                {months.map((month) => {
                    return <Link className="button-month" to={"/month/"+month}>{month.toUpperCase()}</Link>
                })}

            </div>
        </>
    );
}

export default Home;
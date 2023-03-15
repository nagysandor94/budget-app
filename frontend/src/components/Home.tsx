import React, { Component } from "react";
import { Link } from "react-router-dom";
import '../css/Home.css';

function Home() {
    return (
        <>
            <h1>Welcom to your Budget App!</h1>
            <div className="page-conent">
                <div className="btn-group">
                    <Link className="button-month" to="/month/january">JANUARY</Link>
                    <Link className="button-month" to="/month/february">FEBRUARY</Link>
                    <Link className="button-month" to="/month/march">MARCH</Link>
                    <Link className="button-month" to="/month/april">APRIL</Link>
                </div>

                <div className="btn-group">
                    <Link className="button-month" to="/month/may">MAY</Link>
                    <Link className="button-month" to="/month/june">JUNE</Link>
                    <Link className="button-month" to="/month/july">JULY</Link>
                    <Link className="button-month" to="/month/august">AUGUST</Link>
                </div>

                <div className="btn-group">
                    <Link className="button-month" to="/month/september">SEPTEMBER</Link>
                    <Link className="button-month" to="/month/october">OCTOBER</Link>
                    <Link className="button-month" to="/month/november">NOVEMBER</Link>
                    <Link className="button-month" to="/month/december">DECEMBER</Link>
                </div>

            </div>
        </>
    );
}

export default Home;
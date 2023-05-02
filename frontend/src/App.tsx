import React from 'react';
import logo from './logo.svg';
import './App.css';

import Home from './components/Home';
import { Routes, Route } from "react-router-dom";
import Nav from './components/Nav';
import AddEditTransaction from './components/AddEditTransaction';
import ListTransactionMonth from './components/ListTransactionMonth';


function App() {
  const months: string[] = ["january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"];
  return (
    <div className="App">
      <Nav />
      <Routes>
        <Route path="/" element={<Home />}> </Route>

        <Route path="/addnewtransaction" element={<AddEditTransaction />}> </Route>

        {months.map((month) => {
          return <Route key={month} path={"/month/" + month} element={<ListTransactionMonth month={month} />}> </Route>;
        })};

        <Route path="/edit-transaction/:id" element={<AddEditTransaction />}> </Route>
      </Routes>
    </div>
  );
}

export default App;

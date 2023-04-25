import React from 'react';
import logo from './logo.svg';
import './App.css';

import Home from './components/Home';
import { Routes, Route } from "react-router-dom";
import Nav from './components/Nav';
import AddEditTransaction from './components/AddEditTransaction';
import ListTransactionMonth from './components/ListTransactionMonth';


function App() {
  return (
    <div className = "App">
      <Nav />
      <Routes>
        <Route path="/" element={<Home />}> </Route>

        <Route path="/addnewtransaction" element={<AddEditTransaction />}> </Route>

        <Route path="/month/january" element={<ListTransactionMonth month='january' />}> </Route>
        <Route path="/month/february" element={<ListTransactionMonth month='february' />}> </Route>
        <Route path="/month/march" element={<ListTransactionMonth month='march' />}> </Route>
        <Route path="/month/april" element={<ListTransactionMonth month='april' />}> </Route>
        <Route path="/month/may" element={<ListTransactionMonth month='may' />}> </Route>
        <Route path="/month/june" element={<ListTransactionMonth month='june' />}> </Route>
        <Route path="/month/july" element={<ListTransactionMonth month='july' />}> </Route>
        <Route path="/month/august" element={<ListTransactionMonth month='august' />}> </Route>
        <Route path="/month/september" element={<ListTransactionMonth month='september' />}> </Route>
        <Route path="/month/october" element={<ListTransactionMonth month='october' />}> </Route>
        <Route path="/month/november" element={<ListTransactionMonth month='november' />}> </Route>
        <Route path="/month/december" element={<ListTransactionMonth month='december' />}> </Route>

        <Route path = "/edit-transaction/:id" element = {<AddEditTransaction />}> </Route>
      </Routes>
    </div>
  );
}

export default App;

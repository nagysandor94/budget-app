
import axios from "axios";
import React, { Component, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { ICategoryName, ITransaction, IRespTransaction } from '../Interfaces';
import '../css/ListTransactionMonth.css';

interface Props {
    month: string;
}

const ListTransactionMonth = ({ month }: Props) => {
    const [transactions, setTransactions] = useState<IRespTransaction[]>([])
    let sum = 0;

    useEffect(() => {
        getAllTransactions(month);
    }, [])

    const getAllTransactions = (month: string) => {
        axios.get('http://localhost:8080/api/transactions/month/' + month).then((response) => {
            setTransactions(response.data)
            console.log(response.data)
        }).catch(error => {
            console.log(error);
        })

    }

    function sumArray(transactions: IRespTransaction[]) {
        transactions.forEach(transaction => {
            sum += transaction.amount;
        });

        console.log(sum);
        return sum;
    }

    const deleteTransaction = (transactionId: any) => {
        axios.delete('http://localhost:8080/api/transactions/' + transactionId).then((response) => {
            getAllTransactions(month);

        }).catch(error => {
            console.log(error);
        })

    }


    return (
        <>
            <div className="container-List">
                <h1 className="text-center"> List Transactions </h1>
                {/* <Link to="/addnewtransaction" className="btn btn-primary mb-2" > Add Transaction </Link> */}
                <table className="table table-bordered table-striped">
                    <thead>
                        <th> Transaction Id </th>
                        <th> Type </th>
                        <th> Category </th>
                        <th> Month </th>
                        <th> Description </th>
                        <th> Amount </th>
                        <th> Edit / Delete </th>
                    </thead>
                    <tbody>
                        {
                            transactions.map(
                                transaction =>
                                    <tr key={transaction.id}>
                                        <td> {transaction.id} </td>
                                        <td> {transaction.type} </td>
                                        <td> {transaction.category} </td>
                                        <td>{transaction.month}</td>
                                        <td>{transaction.description}</td>
                                        <td>{transaction.amount}</td>
                                        <td>
                                            <Link className="button-Edit" to={`/edit-transaction/${transaction.id}`} >Update</Link>
                                            <button className="button-Delete" onClick={() => deleteTransaction(transaction.id)}
                                                style={{ marginLeft: "10px" }}> Delete</button>
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>

            </div>
            <div className="summury">
                <h2>Money left</h2>
                <h2>{sumArray(transactions)}</h2>
            </div>
        </>
    )
}

export default ListTransactionMonth;
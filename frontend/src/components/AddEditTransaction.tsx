import { useEffect, useState } from "react";
import { ICategoryName, ITransaction, IRespTransaction } from '../Interfaces'
import {Link, useParams } from 'react-router-dom';
import axios from "axios";
import '../css/AddEditTransaction.css';

function AddEditTransaction() {

    const [categories, setCategories] = useState<ICategoryName[]>();
    const [transaction, setTransaction] = useState<ITransaction>();
    const [category, setCategory] = useState<string>('');
    const [description, setDescription] = useState<string>('');
    const [month, setMonth] = useState<string>('january');
    const [typeIncEx, settypeIncEx] = useState<string>('');
    const [amount, setAmount] = useState<number>(0);

    const {id} = useParams<string>();


    const createTransaction =(transaction:any) => {
        return axios.post('http://localhost:8080/api/transactions', transaction)
        .then((response) => {
            console.log(response)
    
        }).catch(error => {
            console.log(error)
        });
    };

    const updateTransaction =(transactionId: string, transaction:any) => {
        return axios.put('http://localhost:8080/api/transactions/'+transactionId, transaction).then((response) => {
            console.log(response)
    
        }).catch(error => {
            console.log(error)
        });
    };
    
    const getTransactionById =(transactionId: string) => {
        return axios.get('http://localhost:8080/api/transactions/'+transactionId);
    };
    


    useEffect(() => {
        const url = 'http://localhost:8080/api/categories';
        axios.get(url).then((response) => {
            setCategories(response.data);
            console.log({categories});
        });
        if(id) {
            getTransactionById(id).then((response) =>{
                setCategory(response.data.category);
                setMonth(response.data.month);
                setAmount(response.data.amount);
                setDescription(response.data.description);
                settypeIncEx(response.data.type);
            })

        }
    }, []);

    const addTransaction = (e:React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
        e.preventDefault();
        const transaction = {typeIncEx, category, month, description, amount};
        console.log(transaction);

        if(id){
            updateTransaction(id, transaction).then((response) => {
                // history.push('/employees')
            }).catch(error => {
                console.log(error)
            })
        } else {
            createTransaction(transaction);
        }
    }

    useEffect (() => {
        
    })


    return (
        <div>
            <h1>ADD NEW</h1>
            <div className="container">
            <form>
                <label >Type</label>
                <select value={typeIncEx} onChange = {(e) => settypeIncEx(e.target.value)}>
                    <option value="Income">Income</option>
                    <option value="Expense">Expense</option>
                </select>

                <label >Category</label>
                <select value={category} onChange={(e)=> setCategory(e.target.value)}>
                    {categories
                    ? categories.map((category) => {
                        return <option key={category.categoryName} value={category.categoryName}>{category.categoryName}</option>;
                    }): null}
                </select>

                <label >Month</label>
                <select value={month} onChange={(e)=> setMonth(e.target.value)}>
                    <option value="january">january</option>
                    <option value="february">february</option>
                    <option value="march">march</option>

                    <option value="april">april</option>
                    <option value="may">may</option>
                    <option value="june">june</option>

                    <option value="july">july</option>
                    <option value="august">august</option>
                    <option value="september">september</option>

                    <option value="october">october</option>
                    <option value="november">november</option>
                    <option value="december">december</option>
                </select>
                <label >Description</label>
                <textarea value={description} onChange={(e)=> setDescription(e.target.value)} placeholder="Add description.." ></textarea>
                <label >Amount</label>
                <input value={amount} onChange={(e)=> setAmount(e.target.valueAsNumber)} type="number" step="0.01" id="fname" name="firstname" placeholder="Amount..." />
                <button className="add-button" onClick={event => addTransaction(event)}>Add</button>
            </form>
            </div>


        </div>

    );
}

export default AddEditTransaction;
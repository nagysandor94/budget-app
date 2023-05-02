import { useEffect, useState } from "react";
import { ICategoryName, ITransaction, IRespTransaction, months } from '../Interfaces'
import { Link, useParams } from 'react-router-dom';
import axios from "axios";
import '../css/AddEditTransaction.css';
import { useNavigate } from "react-router-dom";

function AddEditTransaction() {

    const [categories, setCategories] = useState<ICategoryName[]>();
    const [transaction, setTransaction] = useState<ITransaction>();
    const [category, setCategory] = useState<string>('No category');
    const [description, setDescription] = useState<string>('');
    const [month, setMonth] = useState<string>('january');
    const [typeIncEx, settypeIncEx] = useState<string>('Expense');
    const [amount, setAmount] = useState<number>(0);
    const navigate = useNavigate();
    const { id } = useParams<string>();


    const createTransaction = (transaction: ITransaction) => {
        return axios.post('http://localhost:8080/api/transactions', transaction)
            .then((response) => {
                console.log(response)
                navigate("/month/" + month);

            }).catch(error => {
                console.log(error)
            });
    };

    const updateTransaction = (transactionId: string, transaction: ITransaction) => {
        return axios.put('http://localhost:8080/api/transactions/' + transactionId, transaction).then((response) => {
            console.log(response)
            navigate("/month/" + month);

        }).catch(error => {
            console.log(error)
        });
    };

    const getTransactionById = (transactionId: string) => {
        return axios.get('http://localhost:8080/api/transactions/' + transactionId);
    };



    useEffect(() => {
        const url = 'http://localhost:8080/api/categories';
        axios.get(url).then((response) => {
            setCategories(response.data);
            console.log({ categories });
        });
        if (id) {
            getTransactionById(id).then((response) => {
                setCategory(response.data.category);
                setMonth(response.data.month);
                setAmount(response.data.amount);
                setDescription(response.data.description);
                settypeIncEx(response.data.type);
            })

        }
    }, []);

    const addTransaction = (e: React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
        e.preventDefault();
        const transaction = { typeIncEx, category, month, description, amount };
        console.log(transaction);

        if (id) {
            updateTransaction(id, transaction).then((response) => {

            }).catch(error => {
                console.log(error)
            })
        } else {
            createTransaction(transaction);
        }
    }

    return (


        <div>
            <h1>Transaction</h1>
            <div className="container">
                <form>
                    <label >Type</label>
                    <select value={typeIncEx} onChange={(e) => settypeIncEx(e.target.value)}>
                        <option value="Income">Income</option>
                        <option value="Expense">Expense</option>
                    </select>

                    <label >Category</label>
                    <select value={category} onChange={(e) => setCategory(e.target.value)}>
                        {categories
                            ? categories.map((category) => {
                                return <option key={category.categoryName} value={category.categoryName}>{category.categoryName}</option>;
                            }) : null}
                    </select>

                    <label >Month</label>
                    <select value={month} onChange={(e) => setMonth(e.target.value)}>

                        {months.map((month) => {
                            return <option key={month} value={month}>{month}</option>;
                        })};
                    </select>

                    <label >Description</label>
                    <textarea value={description} onChange={(e) => setDescription(e.target.value)} placeholder="Add description.." ></textarea>

                    <label >Amount</label>
                    <input value={amount} onChange={(e) => setAmount(e.target.valueAsNumber)} type="number" step="0.01" id="fname" name="firstname" placeholder="Amount..." />
                    <button className="add-button" onClick={event => addTransaction(event)}>Submit</button>
                </form>
            </div>


        </div>

    );
}

export default AddEditTransaction;
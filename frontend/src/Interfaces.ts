export interface ICategoryName {
    categoryName: string;
}

export interface ITransaction {
    typeIncEx: string; 
    category: string;
    month: string;
    description:string;
    amount:number;
}


export interface IRespTransaction {
    id:          number;
    type:        string;
    category:    string;
    month:       string;
    description: string;
    amount:      number;
}

export const months: string[] = ["january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"];




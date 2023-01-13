import { Account } from "./account";

export interface Transaction {
    idTransaction: number,
    accountNumber: String,
    transferAccount: String,
    movementDate: Date,
    transactionType: String,
    description: String,
    value: number,
    movementType: String,
    balance: number,
    availableBalance: number,
    idAccount: Account

}

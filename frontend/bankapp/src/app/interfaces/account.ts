import { Client } from "./client"
import { Transaction } from "./transaction"

export interface Account {
    idAccount: number,
    accountType: String,
    accountNumber: String,
    accountStatus: String,
    balance: number,
    availableBalance: number,
    nontaxable: String,
    creationDate: Date
    userCreation: String,
    modificationDate: Date,
    userModification: String,
    idClient: Client,
    transaction: Transaction[]

}

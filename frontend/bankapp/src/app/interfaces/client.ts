import { Account } from "./account";

export interface Client {
    idClient: number,
    identificationType: String,
    identificationNumber: String,
    name: String,
    lastName: String,
    email: String,
    birthDate: Date,
    creationDate: Date,
    userCreation: String,
    modificationDate: Date,
    userModification: String,
    deleteid: boolean,
    account: Account[]
    
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Transaction } from '../interfaces/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private apiServerUrl = environment.apiBaseUrl

  constructor(private http: HttpClient){}

  public getTransactions(): Observable<Transaction[]> {
      return this.http.get<Transaction[]>(`${this.apiServerUrl}/transactions`);
  }

  public getTransactiontByIdAccount(idAccount: number): Observable<Transaction[]>{
      return this.http.get<Transaction[]>(`${this.apiServerUrl}/transactions/getTransactiontByIdAccount/${idAccount}`)
  }

  public createTransaction(transaction: Transaction): Observable<Transaction> {
      return this.http.post<Transaction>(`${this.apiServerUrl}/transactions/create`, transaction)
  }

}

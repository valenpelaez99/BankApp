import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Account } from '../interfaces/account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private apiServerUrl = environment.apiBaseUrl

  constructor(private http: HttpClient){}


  public addAccount(clientId: number, account: Account): Observable<Account> {
      return this.http.post<Account>(`${this.apiServerUrl}/accounts/create/${clientId}`, account);
  }

  public getAccounts(): Observable<Account[]> {
      return this.http.get<Account[]>(`${this.apiServerUrl}/accounts`);
  }

  public getAccountByClientId(id: number): Observable<Account[]>{
      return this.http.get<Account[]>(`${this.apiServerUrl}/accounts/getByClientId/${id}`)
  }

  updateAccount(account: Account): Observable<Account>{
      return this.http.put<Account>(`${this.apiServerUrl}/accounts/update/${account.idAccount}`, account);
    }

}

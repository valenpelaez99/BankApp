import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Account } from 'src/app/interfaces/account';
import { Transaction } from 'src/app/interfaces/transaction';
import { AccountService } from 'src/app/services/account.service';
import { TransactionService } from 'src/app/services/transaction.service';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit{

  public transactions: Transaction[] = [];

  account: Account;

  id: number;


  constructor(
    private route: ActivatedRoute,
    private accountService: AccountService, 
    private transactionService: TransactionService,
  ){}

  ngOnInit(): void {

    this.route.paramMap.subscribe((params: ParamMap) => {
      this.id = +params.get('idAccount')!
    })
    this.getTransactiontByIdAccount(this.id);
  } 

  public getTransactions(): void {
    this.transactionService.getTransactions().subscribe({
      next: (response: Transaction[]) => {
        this.transactions = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public getTransactiontByIdAccount(id: number): void {
    this.transactionService.getTransactiontByIdAccount(id).subscribe({
      next: (response: Transaction[]) => {
        this.transactions = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }
}

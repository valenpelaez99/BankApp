import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Account } from 'src/app/interfaces/account';
import { Client } from 'src/app/interfaces/client';
import { Transaction } from 'src/app/interfaces/transaction';
import { AccountService } from 'src/app/services/account.service';
import { TransactionService } from 'src/app/services/transaction.service';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit{

  public accounts: Account[] = [];

  updateAccount: Account | undefined;

  movementAccount: Account | undefined;

  client: Client;
  clientId: number;
  id: number;

  constructor(
    private route: ActivatedRoute,
    private transactionService: TransactionService,
    private accountService: AccountService, 
  ){}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.id = +params.get('idClient')!
    })
    //const id = this.route.snapshot.paramMap.get('idClient')!;
    this.getAccountsByClientId(this.id);

  }

  public getAccountsByClientId(id: number): void {
    this.accountService.getAccountByClientId(id).subscribe({
      next: (response: Account[]) => {
        this.accounts = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onAddAccount(addForm: NgForm): void {
    document.getElementById('add-account-form')?.click();
    this.accountService.addAccount(this.id, addForm.value).subscribe(
      {
        next:(response: Account) => {
          console.log(response);
          alert('Account Created')
          location.reload();
          addForm.reset();
        },
        error:() => {
          alert('Please try again');
          addForm.reset();
        }
      });
  }

  public onUpdateAccount(account: Account): void {
    this.updateAccount!.accountStatus = account.accountStatus;
    console.log(account);
    this.accountService.updateAccount(this.updateAccount!).subscribe({
      next:(response: Account) => {
        console.log(response);
        alert('Account Updated')
        this.getAccountsByClientId(this.id);
      },
      error:() => {
        alert('Cannot Cancel this account: Available Balance must be 0')
      }
    });
  }

  public onAddConsWdrl(consWdrlForm: NgForm): void {
    document.getElementById('add-cons-wdrl-form')?.click();

    consWdrlForm.value.accountNumber = this.movementAccount?.accountNumber;

    if(consWdrlForm.value.transactionType == 'consignment'){
      consWdrlForm.value.movementType = 'credit';
    } else {
      consWdrlForm.value.movementType = 'debit';
    }
    this.transactionService.createTransaction(consWdrlForm.value).subscribe(
      {
        next:(response: Transaction) => {
          console.log(response);
          alert('Successfull consignment');
          location.reload();
          consWdrlForm.reset();
        },
        error:() => {
          alert('The account must be activated');
          alert('Failed consignment');
          consWdrlForm.reset();
        }
      });
  }

  public onAddTransfer(transferForm: NgForm): void {
    document.getElementById('add-transfer-form')?.click();
    transferForm.value.accountNumber = this.movementAccount?.accountNumber;
    transferForm.value.transactionType = 'transfer';
    transferForm.value.movementType = 'debit';
    console.log(transferForm);
    this.transactionService.createTransaction(transferForm.value).subscribe(
      {
        next:(response: Transaction) => {
          console.log(response);
          alert('Successfull transfer');
          location.reload();
          transferForm.reset();
        },
        error:() => {
          alert('Failed transfer');
          alert('Please check if the account is activate, the Receiver Account Number or the funds on this account')
          transferForm.reset();
        }
      });
  }

  public onOpenModal(mode: string, account?: Account): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addAccountModal');
    }
    else if (mode === 'edit') {
      this.updateAccount = account;
      button.setAttribute('data-target', '#updateAccountModal');
    }
    else if (mode === 'consignment-withdrawal') {
      this.movementAccount = account;
      button.setAttribute('data-target', '#addConsWdrlModal');
    } 
    else if (mode === 'transfer') {
      this.movementAccount = account;
      button.setAttribute('data-target', '#addTransferModal');
    }
    container?.appendChild(button);
    button.click();
  }

}

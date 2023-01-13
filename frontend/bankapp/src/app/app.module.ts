import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { ClientAccountsComponent } from './client-accounts/client-accounts.component';
import { ClientsPageComponent } from './clients-page/clients-page.component';
import { RouterModule } from '@angular/router';
import { AccountTransactionsComponent } from './account-transactions/account-transactions.component';
import { DeveloperProfileComponent } from './developer-profile/developer-profile.component';
import { HeaderComponent } from './header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {TableModule} from 'primeng/table';
import {ButtonModule} from 'primeng/button';
import { HomeComponent } from './home/home.component';
import {CardModule} from 'primeng/card';
import {CarouselModule} from 'primeng/carousel';
import { ClientsComponent } from './components/clients/clients.component';
import { AccountsComponent } from './components/accounts/accounts.component';
import { TransactionsComponent } from './components/transactions/transactions.component';
import { InfoComponent } from './components/info/info.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientAccountsComponent,
    ClientsPageComponent,
    AccountTransactionsComponent,
    DeveloperProfileComponent,
    HeaderComponent,
    HomeComponent,
    ClientsComponent,
    AccountsComponent,
    TransactionsComponent,
    InfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    RouterModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    TableModule,
    ButtonModule,
    CardModule,
    CarouselModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

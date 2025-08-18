package com.finance;

import com.finance.account.Account;
import com.finance.tax.FinanceTaxCalculation;

public class Demo 
{
    public static void main(String[] args) 
    {
        
        Account account = new Account("Aniket", 100000);

        account.showBalance();
        account.deposit(20000.0);
        account.withdrawal(5000.0);
        account.showBalance();

        FinanceTaxCalculation taxIncome = new FinanceTaxCalculation();
        
        double gst=taxIncome.CalculateGST(2000);
        double tax=taxIncome.CalculateIncomeTax(500000);
        
        System.out.println("GST on 2000 :"+gst);
        System.out.println("IncomeTax on 500000 :"+tax);
    }
}

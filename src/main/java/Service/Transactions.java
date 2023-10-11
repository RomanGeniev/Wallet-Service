package Service;

import Core.Customers;
import Core.Data;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Transactions {

    public static void debitTransaction(Customers customer, float transactionAmount){
        Date date = new Date();
        if (customer.getBankAccount() - transactionAmount >= 0) {
            customer.setBankAccount(customer.getBankAccount() - transactionAmount);
            Data.creatingTransactionId(transactionAmount,"Снятие наличных");

        } else {
            System.out.println("На счете недостаточно средств");
        }
    }

    public static void creditTransaction(Customers customers, float loanAmount){
        customers.setBankAccount(customers.getBankAccount() + loanAmount);
        Data.creatingTransactionId(loanAmount,"Крeдит");
    }
}

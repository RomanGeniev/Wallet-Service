package Service;

import Core.Customers;
import Core.Data;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Transactions {

    public static boolean debitTransaction(Customers customer, float transactionAmount){
        Date date = new Date();
        if (customer.getBankAccount() - transactionAmount >= 0) {
            customer.setBankAccount(customer.getBankAccount() - transactionAmount);
            Data.creatingTransactionId(transactionAmount,"Снятие наличных");
            return true;

        } else {
            System.out.println("На счете недостаточно средств");
            return false;
        }
    }

    public static boolean creditTransaction(Customers customers, float loanAmount){
        customers.setBankAccount(customers.getBankAccount() + loanAmount);
        Data.creatingTransactionId(loanAmount,"Крeдит");
        return true;
    }
}

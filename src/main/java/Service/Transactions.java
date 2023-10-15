package Service;

import Core.Customers;
import Core.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Transactions {
    private static final String host = "jdbc:postgresql://localhost:5432/Bank_Data";
    private static final String user = "User";
    private static final String password = "admin";


    public static void main(String[] args) {
        try {
            Properties property = new Properties();
            property.load(new FileInputStream("src/main/resources/config.properties"));

            //String host = property.getProperty("host");
            //String login = property.getProperty("login");
            //String password = property.getProperty("password");
            //System.out.println(host + login + password);

            Connection connection = DriverManager.getConnection(host, user, "admin");
            if (connection != null) {
                System.out.print("Connection successfully!");
            } else {
                System.out.println("Connection false!");
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean debitTransaction(Customers customer, int transactionAmount) {
        if (customer.getBankAccount() - transactionAmount >= 0) {
            customer.setBankAccount(customer.getBankAccount() - transactionAmount);
            Data.creatingTransactionId(transactionAmount, "Снятие наличных");
            return true;

        } else {
            System.out.println("На счете недостаточно средств");
            return false;
        }
    }

    public static boolean creditTransaction(Customers customers, int loanAmount) {
        customers.setBankAccount(customers.getBankAccount() + loanAmount);
        Data.creatingTransactionId(loanAmount, "Крeдит");
        return true;
    }
}

package Interface;

import Core.Customers;
import Core.Data;
import Service.Transactions;

import java.util.Scanner;

public class InterfaceBank {

    public InterfaceBank() {
        Scanner scanner = new Scanner(System.in);
        int choosingAction;
        int choosingActionInAccount;

        do {
            System.out.println("Выберите интересующее вас действие:" +
                    "\n 1: Создать аккаунт " +
                    "\n 2: Войти в аккаунт " +
                    "\n 3: Завершить программу");
            choosingAction = scanner.nextInt();
            if (choosingAction == 1) {
                scanner.nextLine();
                System.out.println("Введите логин");
                String login = scanner.nextLine();
                System.out.println("Введите пароль");
                String password = scanner.nextLine();
                new Customers(login, password);
            } else if (choosingAction == 2) {
                scanner.nextLine();
                System.out.println("Введите логин от вашего аккаунта");
                String login = scanner.nextLine();
                System.out.println("Введите пароль от вашего аккаунта");
                String password = scanner.nextLine();
                if (Data.isHasAccount(login, password)) {
                    System.out.println("Вы вошли в аккаунт");
                    System.out.println("Ваш баланс: " + Data.getBankAccount(login).getBankAccount());
                    do{
                        System.out.println("Вы в своем аккаунте, что вы хотите сделать далее? \n 1:Снятие денег \n 2:Взять кредит \n 3:Посмотреть историю \n4:Выйти из аккаунта");
                        choosingActionInAccount = scanner.nextInt();
                        if(choosingActionInAccount == 1){
                            System.out.println("Введите сумму снятия");
                            Transactions.debitTransaction(Data.getBankAccount(login),scanner.nextFloat());
                            System.out.println("Ваш баланс: " + Data.getBankAccount(login).getBankAccount());
                        }else if (choosingActionInAccount == 2){
                            System.out.println("Введите сумму кредита: ");
                            Transactions.creditTransaction(Data.getBankAccount(login), scanner.nextFloat());
                            System.out.println("Ваш баланс: " + Data.getBankAccount(login).getBankAccount());
                        } else if (choosingActionInAccount == 3){
                            Data.getAccountHistory();
                        }
                    }while (choosingActionInAccount != 4);

                }
            }
        } while (choosingAction != 3);
    }
}

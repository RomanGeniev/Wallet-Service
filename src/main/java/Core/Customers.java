package Core;

public class Customers {

    private final String password;
    private final String login;
    private int bankAccount = 0;

    public Customers(String login, String password) {
        this.password = password;
        this.login = login;
        Data.setDataUsers(login, this);
    }

    public void setBankAccount(int bankAccount) {
            this.bankAccount = bankAccount;

    }



    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public int getBankAccount() {
        return bankAccount;
    }


}

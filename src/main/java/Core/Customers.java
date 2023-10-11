package Core;

public class Customers {

    private String password;
    private String login;
    private float bankAccount = 0;

    public Customers(String login, String password) {
        this.password = password;
        this.login = login;
        Data.setDATAUSERS(login, this);
    }

    public void setBankAccount(float bankAccount) {
            this.bankAccount = bankAccount;

    }



    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public float getBankAccount() {
        return bankAccount;
    }


}

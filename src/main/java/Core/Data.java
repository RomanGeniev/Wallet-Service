package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Data {
    private static final ArrayList<String> AccountHistory = new ArrayList<>();
    private static final HashMap<String,Customers> dataUsers = new HashMap<>();

    public static Boolean isHasAccount(String login, String password){
        try {
            return dataUsers.get(login).getPassword().equals(password);
        }catch (NullPointerException e){
            System.out.println("Неверный логин или пароль!");
            return false;
        }
    }
    public static String getPassword(String login){
        return dataUsers.get(login).getPassword();
    }

    public static void setDataUsers(String login, Object o) {
        dataUsers.put(login, (Customers) o);
    }

    public static Customers getBankAccount(String login){
        return dataUsers.get(login);
    }

    public static void setAccountHistory(String action) {
        if(!AccountHistory.equals(action)) {
            AccountHistory.add(action);
        }
    }
    public static void getAccountHistory(){
        for(String s:AccountHistory){
            System.out.println(s);
        }
    }

    public static void creatingTransactionId(Float sum,String string){

        Random random = new Random();
        String generatedString = random.ints(97, 122 + 1)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String action = string + " на сумму: " + sum.toString() + ". Уникальный идентификатор :" + generatedString;
        setAccountHistory(action);
    }

}

package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Data {
    private static final ArrayList<String> AccountHistory = new ArrayList<>();
    private static final HashMap<String,Customers> DATAUSERS = new HashMap<>();

    public static Boolean isHasAccount(String login, String password){
        try {
            return DATAUSERS.get(login).getPassword().equals(password);
        }catch (NullPointerException e){
            System.out.println("Неверный логин или пароль!");
            return false;
        }
    }
    public static String getPassword(String login){
        return DATAUSERS.get(login).getPassword();
    }

    public static void setDATAUSERS(String login, Object o) {
        DATAUSERS.put(login, (Customers) o);
    }

    public static Customers getBankAccount(String login){
        return DATAUSERS.get(login);
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

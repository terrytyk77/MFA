package mfa;

import java.util.HashMap;

public final class DataManager {

    private static final HashMap<String,String> loginInfo = new HashMap<>();
    private static final DataManager INSTANCE = new DataManager();

    private DataManager(){
        loginInfo.put("Terry", "12345");
        loginInfo.put("Ali", "Apple12");
        loginInfo.put("John", "Pizza");
    }

    public static DataManager getInstance(){
        return INSTANCE;
    }

    public boolean createUser(String name, String password){
        if(getUser(name)){
            System.out.println("Username already taken!");
            return false;
        }

        loginInfo.put(name, password);
        return true;
    }

    public boolean getUser(String name){
        return loginInfo.containsKey(name);
    }

    public boolean confirmUserPassword(String name,String password){
        return loginInfo.get(name).equals(password);
    }
}

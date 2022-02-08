import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**Form*/
public class Form {
    private static Map<String, String> usersDB = new HashMap<>();
    private static ArrayList<String> usersActivity = new ArrayList<>();
    private static String login = "";
    private static String password = "";
    private static String process = "";
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            new Form().check(sc.nextLine());
        }
    }
    public void check(String s){
        String[] str = s.split(" ");
        process = str[0];
        login = str[1];
        if (str.length > 2){ password = str[2];}
        if ("register".equals(str[0])) {
            register();
        } else if ("login".equals(str[0])) {
            login();
        } else if ("logout".equals(str[0])) {
            logout();
        }
    }
    public void register() {
        if(usersDB.containsKey(login)){
            System.out.println("fail: user already exists");
        } else {
        usersDB.put(login, password);
        System.out.println("success: new user added");
        }
    }
    public void login() {
        if (!usersDB.containsKey(login)) {
            System.out.println("fail: no such user");
        } else if (!usersDB.get(login).equals(password)) {
            System.out.println("fail: incorrect password");
        } else if (usersActivity.contains(login) ){
            System.out.println("fail: already logged in");
        } else {
            usersActivity.add(login);
            System.out.println("success: user logged in");
        }
    }
    public void logout(){
        if (!usersDB.containsKey(login)){
            System.out.println("fail: no such user");
        } else if (!usersActivity.contains(login)){
            System.out.println("fail: already logged out");
        } else {
            System.out.println("success: user logged out");
            usersActivity.remove(login);
        }
    }
}
package tiendachuches;

public class User {
    private String userName;
    private String passwd;

    public User(String userName, String passwd) {
        this.userName = userName;
        this.passwd = passwd;
    }
    
    public String toString(){
        return userName+" "+passwd;
    }
}

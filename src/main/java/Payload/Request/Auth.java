package Payload.Request;

public class Auth {

    private String Username;
    private String Password;

    public  Auth(){}

    public String getusername(){return Username;}

    public void setusername(String Username){
        this.Username = Username;

    }
    public String getpassword(){return Password;}

    public void setpassword(String Password) {
        this.Password = Password;
    }


}

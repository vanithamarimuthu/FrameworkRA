package Utils;

import com.github.javafaker.Faker;

public class Fakerutils {


     static Faker fakeuser;



    public static String getusers(){
        fakeuser = new Faker();
        String fake_firstname = fakeuser.name().firstName();
        return fake_firstname;
    }



}

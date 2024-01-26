package Endpoint;

import Utils.Propertie_fileReader;

public class API_URL {

   // public static String Base_url = "https://restful-booker.herokuapp.com";
   // public static String Create_url = "/booking";
   // public static String Update_url = "/booking";

    public static String Base_url;
    public static String Create_url;



    public static String Update_url;

    static {
        try {
            Base_url = Propertie_fileReader.readKey("url");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static {
        try {
            Create_url = Propertie_fileReader.readKey("createurl");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static {
        try {
            Update_url = Propertie_fileReader.readKey("updateurl");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}

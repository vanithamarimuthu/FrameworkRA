package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertie_fileReader {

    public Propertie_fileReader(){}

    public static String readKey(String key) throws Exception {
        String dir = System.getProperty("user.dir");
        FileInputStream filepath = new FileInputStream(new File(dir)+"/src/main/java/resource/urls.properties");
        System.out.println(filepath);
        Properties prop = new Properties();
        prop.load(filepath);
        if(prop.getProperty(key) == null){
            throw new Exception("not able to find key");
        }
        else{
            return prop.getProperty(key);
        }

    }
}

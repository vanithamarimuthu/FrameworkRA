package DataDriven_TC;

import Utils.excel_Reader_utils;
import org.testng.annotations.Test;

public class Datas_from_excel {

    @Test(dataProvider = "getdata",dataProviderClass = excel_Reader_utils.class)
    public void excel_TestData(String username,String password){
        System.out.println("username "+username);
        System.out.println("password  "+password);
    }

}

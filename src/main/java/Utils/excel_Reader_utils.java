package Utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excel_Reader_utils {

    static Workbook workbook;
    static Sheet sheet;

    public static String file = System.getProperty("user.dir")+"/src/main/java/resource/TestData_Login.xlsx";

    public static Object[][] getData_from_excel(String sheetname) throws FileNotFoundException {

        FileInputStream filename = new FileInputStream(file);
        try {
            workbook = WorkbookFactory.create(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet = workbook.getSheet(sheetname);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i=0;i<sheet.getLastRowNum();i++){
            for (int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }


        return data;

    }



    @DataProvider
    public Object[][] getdata() throws FileNotFoundException {
        return getData_from_excel("Sheet1");
    }
}

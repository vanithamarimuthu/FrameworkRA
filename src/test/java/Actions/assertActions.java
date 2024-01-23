package Actions;

import io.restassured.response.Response;
import org.testng.Assert;


public class assertActions {

    public void verifystatuscode(Response response){
        Assert.assertEquals(String.valueOf(response.getStatusCode()).startsWith("20"), "Value of Status code" + response.getStatusCode());
    }
    public void verifyresponsebody(String actual,String expected,String description){
        Assert.assertEquals(actual,expected,description);
        
    }
    public void verifyresponsebody(float actual,float expected,float description){
        Assert.assertEquals(actual,expected,description);

    }
    public void verifyresponsebody(int actual,int expected,int description){
        Assert.assertEquals(actual,expected,description);

    }
    public void verifyresponsebody(double actual,double expected,double description){
        Assert.assertEquals(actual,expected,description);

    }
    
}

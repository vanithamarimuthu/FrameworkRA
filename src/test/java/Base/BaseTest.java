package Base;

import Actions.assertActions;
import Endpoint.API_URL;
import Modules.payloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification requestspec;

    public payloadManager Payload;
    public assertActions assertaction;

    public Response response;

    public JsonPath jsonPath;

    public ValidatableResponse validresponse;



    @BeforeMethod
    public void setup(){
        Payload = new payloadManager();
        assertaction = new assertActions();
        requestspec = RestAssured.given()
                .baseUri(API_URL.Base_url)
                .contentType(ContentType.JSON);




    }
}

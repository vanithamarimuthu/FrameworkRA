package Base;

import Actions.assertActions;
import Endpoint.API_URL;
import Modules.payloadManager;
import Payload.Response.Bookingresponse;
import com.fasterxml.jackson.core.JsonProcessingException;
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

    public Bookingresponse bookRes;
    public assertActions assertaction;

    public Response response;

    public JsonPath jsonPath;

    public ValidatableResponse validresponse;



    @BeforeMethod(alwaysRun = true)
    public void setup(){
        Payload = new payloadManager();
        assertaction = new assertActions();
        requestspec = RestAssured.given()
                .baseUri(API_URL.Base_url)
                .contentType(ContentType.JSON);




    }
    @BeforeMethod(alwaysRun = true)
    public  String gettoken() throws JsonProcessingException {
        Payload = new payloadManager();
        assertaction = new assertActions();
        requestspec = RestAssured.given()
                .baseUri(API_URL.Base_url).basePath("/auth");
               String token = Payload.setToken();

               response = requestspec.contentType(ContentType.JSON)
                       .body(token).when().post();
               validresponse=response.then().log().all();
               validresponse.statusCode(200);

               jsonPath = JsonPath.from(response.asString());
               return jsonPath.getString("token");



    }

}

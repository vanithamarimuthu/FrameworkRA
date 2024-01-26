package Test_CRUD;

import Base.BaseTest;
import Endpoint.API_URL;
import Payload.Request.Bookings;
import Payload.Response.Bookingresponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.apache.commons.compress.harmony.unpack200.IMatcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class TC_Integration extends BaseTest {

  String token;
  String boopingidPOJO;


    //Create booking
    @Test
    public void createTestBooking() throws JsonProcessingException {
        token = gettoken();

        assertThat(token).isNotNull();

        requestspec.basePath(API_URL.Create_url);

        response =  requestspec.when().body(Payload.createpayload()).post();
        validresponse = response.then().log().all();
        validresponse.statusCode(200);

        Bookingresponse bookres = Payload.JsontoObject(response.asString());
        boopingidPOJO = bookres.getBookingid().toString();



    }

    @Test(groups = "stage",dependsOnMethods = {"createTestBooking"})
    //Update the booking
    public void UpdateBooking() throws JsonProcessingException {

        requestspec.basePath(API_URL.Update_url+"/"+boopingidPOJO);

        response = RestAssured.given().spec(requestspec).cookie("token",token).when()
                .body(Payload.UpdatePayload()).put();
        validresponse = response.then().log().all();
        //validresponse.body("firstname", Matchers.is("Eula123455"));



        Bookings Updatetestresult =  Payload.JsontoObjectPUT_Request(response.asString());
        assertThat(Updatetestresult.getFirstname()).isEqualTo("Eula123455").isNotNull();
        assertThat(Updatetestresult.getLastname()).isNotNull();



    }

    //Delete the booking
    @Test(groups = "stage",dependsOnMethods = {"UpdateBooking"})
    public void DeleteBooking() throws JsonProcessingException {

        requestspec.basePath(API_URL.Update_url+"/"+boopingidPOJO).cookie("token",token);

        response = RestAssured.given().spec(requestspec).auth().basic("admin","password")
                .when()
                .delete();
        validresponse = response.then().log().all();
        validresponse.statusCode(201);

    }
    @Test(groups = "stage",dependsOnMethods = {"DeleteBooking"})
    public void Verify_Deleted_Booking_id() throws JsonProcessingException {

        requestspec.basePath(API_URL.Update_url+"/"+boopingidPOJO);

        response = RestAssured.given().spec(requestspec)
                .when()
                .get();
        validresponse = response.then().log().all();
        validresponse.statusCode(404);

    }
}

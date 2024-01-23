package Test_CRUD;

import Base.BaseTest;
import Endpoint.API_URL;
import Payload.Response.Bookingresponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TC_CreateBooking extends BaseTest {


    @Test(groups = {"Positive tc"})
    @Owner("Vanithamani")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify create booking works and id is generated")
    public void createbookingTest() throws JsonProcessingException {

        requestspec.basePath(API_URL.Create_url);

        response =  requestspec.when().body(Payload.createpayload()).post();
        validresponse = response.then().log().all();
        validresponse.statusCode(200);

        jsonPath = JsonPath.from(response.asString());
        String bookingid = jsonPath.getString("bookingid");

        Bookingresponse bookingstestresult =  Payload.JsontoObject(response.asString());
        assertThat(bookingstestresult.getBookingid().toString()).isNotEmpty().isNotNull();






    }

    @Test(groups = {"Negative tc"})
    public void createbooking_negativeTest() throws JsonProcessingException {

        requestspec.basePath(API_URL.Create_url);

        response =  requestspec.when().body(Payload.createpayload()).post();
        validresponse = response.then().log().all();
        validresponse.statusCode(200);

        jsonPath = JsonPath.from(response.asString());
        String bookingid = jsonPath.getString("bookingid");

        Bookingresponse bookingstestresult =  Payload.JsontoObject(response.asString());
        assertThat(bookingstestresult.getBookingid().toString()).isEqualTo("201");






    }
}



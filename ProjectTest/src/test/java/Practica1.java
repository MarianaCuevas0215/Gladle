import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

public class Practica1 {

    @Test
    public void Datos(){
        RestAssured.baseURI = String.format("https://api.quarantine.country/api/v1/summary/latest");

        Response response = given().log().all().header("Accept","application/json").get();

        String body = response.getBody().asString();

        System.out.println("Body Response: "+ body);
        System.out.println("Response status: " + response.getStatusCode());
        System.out.println("Response Headers: " + response.getHeaders());
        System.out.println("Response Content Type: " + response.contentType());
        assertEquals(200,response.getStatusCode());
        assertTrue(body.contains("summary"));
    }

}

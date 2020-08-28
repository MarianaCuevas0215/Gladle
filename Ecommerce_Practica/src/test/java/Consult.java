import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

public class Consult {

    @Test
    public void con_info_region_status_200() {

        RestAssured.baseURI = String.format("https://webapi.segundamano.mx/nga/api/v1.1/public/regions");
        Response response = given().queryParam("lang", "es").log().all()
                .queryParam("depth", "1")
                .get();

        String body = response.getBody().asString();

        System.out.println("Body Response: "+ body);
        System.out.println("Response status: " + response.getStatusCode());
        assertEquals(200,response.getStatusCode());
        assertNotNull(body);
        assertTrue(body.contains("Quintana Roo"));

    }
}

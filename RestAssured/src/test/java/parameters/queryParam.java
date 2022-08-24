package parameters;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class queryParam {
    @Test
    public void query()
    {
        //https://reqres.in/api/users?page=2

        given()
                .queryParam("page",2)
                .log().all()
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .log().all();
    }
}

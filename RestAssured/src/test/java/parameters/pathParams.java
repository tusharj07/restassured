package parameters;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class pathParams {
    @Test
    public void singleParam()
    {
        String path1 = "api";
        String path2 = "users";

        given()
                .pathParams("abc",path1)
                .pathParams("xyz",path2)
                .log().all()
                .when()
                .get("https://reqres.in/{abc}/{xyz}/2")
                .then()
                .log().all();
    }
}

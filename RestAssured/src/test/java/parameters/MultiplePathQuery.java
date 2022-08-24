package parameters;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class MultiplePathQuery
{
    @Test
    public void test()
    {
        String path1 = "users";
        String path2 = "MicrosoftLearning";
        String path3 = "repos";

        given()
                .pathParams("users",path1)
                .pathParams("username",path2)
                .pathParams("repos",path3)

                .queryParam("sort","created")
                .queryParam("per_page",5)
                .log().all()
                .when()
                .get("https://api.github.com/{users}/{username}/{repos}")

                .then()
                .log().all();
    }
}

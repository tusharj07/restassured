package auth;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken
{
    @Test
    public void bearer()
    {
        given()
                .auth()
                .oauth2("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")
                .body("{\n" +
                        "    \"name\" : \"test repo10\",\n" +
                        "    \"private\" : \"True\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .log().all()

                .when()
                .post("https://api.github.com/user/repos")
                .then()
                .log().all();
    }
}

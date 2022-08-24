package RequestChaining;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqChain
{
    @Test
    public void chaining()
    {
        String path1 = "users";
        String path2 = "MicrosoftLearning";
        String path3 = "repos";

        Response res = given()
                .pathParams("users", path1)
                .pathParams("username", path2)
                .pathParams("repos", path3)

                .queryParam("sort", "created")
                .queryParam("per_page", 30)
                .when()
                .get("https://api.github.com/{users}/{username}/{repos}");

        String repoName = res.body().jsonPath().get("[18].name");

        System.out.println(repoName);

        given()
                .pathParams("username",path2)
                .pathParams("rName",repoName)
                .when()
                .get("https://api.github.com/repos/{username}/{rName}")
                .then()
                .log().all()
                .assertThat().statusCode(200);

    }

}

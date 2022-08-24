package auth;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class oauth2 {
    @Test
    public void auths() {
        Response response = given()
                .formParams("client_id", "04d06b4fbb7381548169")
                .formParams("client_secret", "457f57186d25a87aef9ffe9963385cab495dd8fc")
                .formParams("grant_type", "authorization_code")
                .formParams("access_token_url", "https://github.com/login/oauth/access_token")
                .when()
                .post("http://github.com/authorizations");
        //String token = response.jsonPath().get("access_token");
        System.out.println(response);

//        given()
//                .auth().oauth2(token)
//
//                .when()
//                .post("https://api.github.com/user/repos")
//                .then()
//                .log().all();

    }
}
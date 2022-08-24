package differentPostReq;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
//import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.File;


public class jsonFile {
    @Test
    public void hashmap(){
        File file = new File("/home/raramuri/IdeaProjects/RestAssured/src/test/resources/jsonFiles/create.json");


        given()
                .body(file)

                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all();

    }
}
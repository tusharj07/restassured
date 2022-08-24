package differentPostReq;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
//import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

public class jsonObject {
    @Test
    public void hashmap(){
        JSONObject o1=new JSONObject();

        o1.put("name","tushar");
        o1.put("job","sdet");

        given()
                .body(o1)
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all();

    }
}
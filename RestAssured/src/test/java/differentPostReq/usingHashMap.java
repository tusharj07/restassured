package differentPostReq;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

public class usingHashMap {
    @Test
    public void hashmap(){
        HashMap map = new HashMap<>();
        map.put("name","tushar");
        map.put("job","sdet");

        given()
                .body(map)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all();

    }
}
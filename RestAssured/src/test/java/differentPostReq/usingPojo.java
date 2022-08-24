package differentPostReq;

import static io.restassured.RestAssured.*;

import POJOLibrary.pojoClass;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class usingPojo {

    @Test
    public void pojo(){
        pojoClass p = new pojoClass("thdauj","djas");

        given()
                .body(p)
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all();

    }
}
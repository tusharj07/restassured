package com.reqres.post;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;


public class loginSuccessful {
    @Test
    public void loginTest()
    {
        given()
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().time(lessThan(3000L));
    }
}

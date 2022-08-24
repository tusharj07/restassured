package com.reqres.post;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class loginUnsuccessful {
    @Test
    public void loginTest()
    {
        given()
                .body("{\n" +
                        "    \"email\": \"peter@klaven\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .assertThat().statusCode(400)
                .assertThat().time(lessThan(3000L));
    }
}

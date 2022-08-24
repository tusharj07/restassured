package com.reqres.put;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class update {
    @Test
    public void updateTest()
    {
        given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .assertThat().statusCode(201)
                .assertThat().time(lessThan(4000L))

                .body(matchesJsonSchemaInClasspath("jsonSchema/pUpdateSchema.json"));
    }
}

package com.reqres.post;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;


public class create
{
    @Test
    public void createTest()
    {
        given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .assertThat().statusCode(201)
                .assertThat().time(lessThan(3000L))

                .body(matchesJsonSchemaInClasspath("jsonSchema/createSchema.json"));
    }
}
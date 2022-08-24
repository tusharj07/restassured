package com.reqres.get;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;


public class listUsers
{
    @Test
    public void listUser()
    {
        when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().time(lessThan(3000L))
                .body(containsString("byron"))
                .body(matchesJsonSchemaInClasspath("jsonSchema/listUserSchema.json"));




    }
}
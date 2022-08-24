package com.reqres.delete;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;


public class delete{
    @Test
    public void listUser()
    {
        when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .assertThat().statusCode(200);




    }
}

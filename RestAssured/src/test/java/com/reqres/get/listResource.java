package com.reqres.get;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;


import static io.restassured.RestAssured.when;

public class listResource {
    @Test
    public void listResources()
    {
        when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().time(lessThan(4000L))

                .body(matchesJsonSchemaInClasspath("jsonSchema/listResourcesSchema.json"));




    }
}

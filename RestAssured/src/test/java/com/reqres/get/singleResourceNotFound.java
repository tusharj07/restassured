package com.reqres.get;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class singleResourceNotFound {
    @Test
    public void singleResourcesNotFound()
    {
        when()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .log().all()
                .assertThat().statusCode(404)
                .assertThat().time(lessThan(3000L));





    }
}

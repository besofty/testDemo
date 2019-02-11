package com.yu.softy.testdemo.cotroller;

import com.yu.softy.testdemo.TestdemoApplicationTests;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class AuthenticationItemControllerTest extends TestdemoApplicationTests {

    @Test
    public void getAuthenticationItemsTest(){
        given().get("/authentication_items")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("success", equalTo(true))
                .body("result.authenticationItems[0].code", equalTo("identity_auth"));
    }
}

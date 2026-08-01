package specs;

import io.restassured.specification.RequestSpecification;

import static allure.CustomAllureListener.withCustomTemplate;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;


public class BaseSpec {

    private static String token;

    public static RequestSpecification baseRequestSpec = with()
            .filter(withCustomTemplate())
            .log().all()
            .contentType(JSON)
            .baseUri("https://reqres.in")
            .basePath("/api") ;
}
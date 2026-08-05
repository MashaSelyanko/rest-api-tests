package specs.users;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;
import static specs.BaseSpec.baseRequestSpec;

public class UserSpecPut {

    public static RequestSpecification userRequestSpec = baseRequestSpec;

    // спецификация для ответа теста: 200 статус-код (получение списка пользователей)
    public static ResponseSpecification successfulPutUsersResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/users/users_put_response_schema.json"))
            .expectBody("data.data.name", notNullValue())
            .expectBody("data.data.email", notNullValue())
            .expectBody("data.data.role", notNullValue())
            .expectBody("data.updated_at", notNullValue())
            .build();

}

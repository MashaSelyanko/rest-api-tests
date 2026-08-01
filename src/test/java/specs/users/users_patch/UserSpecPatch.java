package specs.users.users_patch;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;
import static specs.BaseSpec.baseRequestSpec;

public class UserSpecPatch {

    public static RequestSpecification userRequestSpec = baseRequestSpec;

    // спецификация для ответа теста: 200 статус-код (получение списка пользователей)
    public static ResponseSpecification successfulPatchUsersResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/users/users_patch_response_schema.json"))
            .expectBody("name", notNullValue())
            .expectBody("email", notNullValue())
            .expectBody("role", notNullValue())
            .expectBody("updatedAt", notNullValue())
            .log(ALL)
            .build();

}

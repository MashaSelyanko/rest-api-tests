package specs.users.users_get;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;

public class UsersSpecGet {

// спецификация для ответа теста: 200 статус-код (получение списка пользователей)
    public static ResponseSpecification successfulGetUsersListResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/users/users_get_response_schema.json"))
            .expectBody("data[0].data.name", notNullValue())
            .expectBody("data[0].data.email", notNullValue())
            .expectBody("data[0].data.role", notNullValue())
            .expectBody("data[0].created_at", notNullValue())
            .expectBody("data[0].updated_at", notNullValue())
            .build();

    }
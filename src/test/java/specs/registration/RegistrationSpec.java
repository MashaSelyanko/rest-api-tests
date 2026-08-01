package specs.registration;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;
import static specs.BaseSpec.baseRequestSpec;

public class RegistrationSpec {

    public static RequestSpecification userRequestSpec = baseRequestSpec;

    // спецификация для ответа теста: 201 статус-код (создание пользователя)
    public static ResponseSpecification successfulRegistrationResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(201)
            .expectBody(matchesJsonSchemaInClasspath(
                    "schemas/registration/successful_registration_response_schema.json"))
            .expectBody("data.id", notNullValue())
            .expectBody("data.data.name", notNullValue())
            .expectBody("data.data.email", notNullValue())
            .expectBody("data.data.role", notNullValue())
            .expectBody("data.created_at", notNullValue())
            .build();

    // спецификация для ответа теста: 400 статус-код (ошибка построения запроса)
    public static ResponseSpecification wrongRegistrationResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(400)
            .expectContentType(ContentType.JSON)
            .expectBody(matchesJsonSchemaInClasspath(
                    "schemas/registration/invalid_registration_response_schema.json"))
            .expectBody("error", notNullValue())
            .build();
}
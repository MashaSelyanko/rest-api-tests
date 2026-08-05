package specs.users;


import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;

public class UserSpecDelete {

//    public static RequestSpecification userRequestSpec = baseRequestSpec;

    // спецификация для ответа: 204 статус-код (удаление пользователя)
    public static ResponseSpecification successfulDeleteUserResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(204)
            .build();
            }
package api_clients;

import io.qameta.allure.Step;
import models.registration.response.InvalidRegistrationResponseRecordsModel;
import models.registration.request.RegistrationBodyModel;
import models.registration.response.SuccessfulRegistrationResponseRecordsModel;
import test_data.TestData;
import tests.TestBase;
import static io.restassured.RestAssured.given;
import static specs.registration.RegistrationSpec.*;

public class RegisterPostApiClient extends TestBase {

    @Step("Успешная регистрация пользователя")
    public SuccessfulRegistrationResponseRecordsModel mainRequest(RegistrationBodyModel body) {
        return given(userRequestSpec)
                .config(timeoutConfig)
                .header("x-api-key", TestData.token)
                .body(body)
                .when()
                .post("/collections/users/records")
                .then()
                .spec(successfulRegistrationResponseSpec)
                .extract()
                .as(SuccessfulRegistrationResponseRecordsModel.class);
    }

    public InvalidRegistrationResponseRecordsModel invalidRequest(String invalidJson) {
    return given(userRequestSpec)
            .config(timeoutConfig)
            .header("x-api-key", TestData.token)
            .body(invalidJson)
            .when()
            .post("/collections/users/records")
            .then()
            .spec(wrongRegistrationResponseSpec)
            .extract()
            .as(InvalidRegistrationResponseRecordsModel.class);

}
}


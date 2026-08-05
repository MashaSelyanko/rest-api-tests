package api_clients;

import io.qameta.allure.Step;
import test_data.TestData;
import tests.TestBase;

import static io.restassured.RestAssured.given;
import static specs.registration.RegistrationSpec.userRequestSpec;
import static specs.users.UserSpecDelete.successfulDeleteUserResponseSpec;

public class UserDeleteApiClient extends TestBase {

    @Step("Удаление пользователя")
    public void mainRequestDeleteUser(String id) {
         given(userRequestSpec)
                .config(timeoutConfig)
                .header("x-api-key", TestData.token)
                .when()
                .delete("/collections/users/records/" + id)
                .then()
                .spec(successfulDeleteUserResponseSpec);
    }
}
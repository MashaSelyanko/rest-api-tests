package api_clients;

import io.qameta.allure.Step;
import models.users.users_get.UsersListResponseModel;
import test_data.TestData;
import tests.TestBase;

import static io.restassured.RestAssured.given;
import static specs.registration.RegistrationSpec.userRequestSpec;
import static specs.users.users_get.UsersSpecGet.successfulGetUsersListResponseSpec;

public class UserGetApiClient extends TestBase {

    @Step("Получение списка всех пользователей")
    public UsersListResponseModel mainRequestUser() {
        return given(userRequestSpec)
                .config(timeoutConfig)
                .header("x-api-key", TestData.token)
                .when()
                .get("/collections/users/records")
                .then()
                .spec(successfulGetUsersListResponseSpec)
                .extract()
                .as(UsersListResponseModel.class);
    }
}

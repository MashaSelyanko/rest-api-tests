package api_clients;

import io.qameta.allure.Step;
import models.registration.request.UserData;
import models.users.users_put.PutUsersResponseModel;
import test_data.TestData;
import tests.TestBase;
import static io.restassured.RestAssured.given;
import static specs.registration.RegistrationSpec.userRequestSpec;
import static specs.users.users_put.UserSpecPut.successfulPutUsersResponseSpec;

public class UserPutApiClient extends TestBase {

    @Step("Изменение пользователя")
    public PutUsersResponseModel mainRequestPutUser(UserData body, String id) {
        return given(userRequestSpec)
                .config(timeoutConfig)
                .header("x-api-key", TestData.token)
                .body(body)
                .when()
                .put("/collections/users/records/" + id)
                .then()
                .spec(successfulPutUsersResponseSpec)
                .extract()
                .as(PutUsersResponseModel.class);
    }
}
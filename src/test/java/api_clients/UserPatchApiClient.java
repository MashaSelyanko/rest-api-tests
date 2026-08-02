package api_clients;

import io.qameta.allure.Step;
import models.registration.request.UserData;
import models.users.users_patch.PatchUsersResponseModel;
import test_data.TestData;
import tests.TestBase;
import static io.restassured.RestAssured.given;
import static specs.registration.RegistrationSpec.userRequestSpec;
import static specs.users.users_patch.UserSpecPatch.successfulPatchUsersResponseSpec;

public class UserPatchApiClient extends TestBase {

    @Step("Частичное изменение пользователя")
    public PatchUsersResponseModel mainRequestPatchUser(UserData body, String id) {
        return given(userRequestSpec)
                .config(timeoutConfig)
                .header("x-api-key", TestData.token)
                .body(body)
                .when()
                .patch("/collections/users/records/" + id)
                .then()
                .spec(successfulPatchUsersResponseSpec)
                .extract()
                .as(PatchUsersResponseModel.class);
    }
}
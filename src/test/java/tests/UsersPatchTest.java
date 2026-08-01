package tests;

import models.registration.request.RegistrationBodyModel;
import models.registration.request.UserData;
import models.registration.response.SuccessfulRegistrationResponseRecordsModel;
import models.users.users_patch.PatchUsersResponseModel;
import models.users.users_put.PutUsersResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_data.TestData;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class UsersPatchTest extends TestBase {

    @DisplayName("Успешное частичное обновление пользователя: 200 статус-код")
    @Test

    public void successfulRegistrationTest() {
        //создание пользователя
        String expectedName = TestData.getRandomName();
        String expectedEmail = TestData.getRandomEmail();
        String getRandomRole = TestData.getRandomRole();
        UserData userData = new UserData(expectedName, expectedEmail, getRandomRole);

        RegistrationBodyModel request = new RegistrationBodyModel(userData);

        SuccessfulRegistrationResponseRecordsModel registrationResponse
                = api.register.mainRequest(request);

        //обновление пользователя
        String userId = registrationResponse.data().id();
        UserData requestPatch = new UserData(
                TestData.getRandomName(),
                TestData.getRandomEmail(),
                TestData.getRandomRole()
        );

        PatchUsersResponseModel patchResponse = api.userPatch.mainRequestPatchUser(requestPatch, userId);

        step("Проверка правильности дисериализации", () -> {
            // Проверяем, что ответ сервера не пустой
            assertThat(patchResponse).isNotNull();
        });

        step("Проверка измененных данных пользователя через PATCH", () -> {
            // Сверяем измененные данные с тем, что отправляли в запросе
            assertThat(patchResponse.name()).isEqualTo(requestPatch.name());
            assertThat(patchResponse.email()).isEqualTo(requestPatch.email());
            assertThat(patchResponse.role()).isEqualTo(requestPatch.role());
        });
    }
}


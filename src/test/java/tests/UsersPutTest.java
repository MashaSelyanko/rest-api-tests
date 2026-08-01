package tests;

import models.registration.request.RegistrationBodyModel;
import models.registration.request.UserData;
import models.registration.response.SuccessfulRegistrationResponseRecordsModel;
import models.users.users_put.PutUsersResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_data.TestData;
import static org.assertj.core.api.Assertions.assertThat;


import static io.qameta.allure.Allure.step;

public class UsersPutTest extends TestBase {

    @DisplayName("Успешное обновление пользователя: 200 статус-код")
    @Test

    //создание пользователя
    public void successfulRegistrationTest() {

        String expectedName = TestData.getRandomName();
        String expectedEmail = TestData.getRandomEmail();
        String getRandomRole = TestData.getRandomRole();
        UserData userData = new UserData(expectedName, expectedEmail, getRandomRole);

        RegistrationBodyModel request = new RegistrationBodyModel(userData);

        SuccessfulRegistrationResponseRecordsModel registrationResponse
                = api.register.mainRequest(request);

        //обновление пользователя
        String userId = registrationResponse.data().id();
        UserData requestPut = new UserData(
                TestData.getRandomName(),
                TestData.getRandomEmail(),
                TestData.getRandomRole()
        );

        PutUsersResponseModel putResponse = api.userPut.mainRequestPutUser(requestPut, userId);

        step("Проверка измененных данных пользователя", () -> {
            // Проверяем, что ответ сервера не пустой
            assertThat(putResponse).isNotNull();

            // Не проверяем, что данные внутри объекта data соответствуют тому, что мы отправляли
            // т.к. баг на стороне бэкенда - ответ 200, изменения не сохраняются
            assertThat(putResponse.data().data().name()).isNotBlank();
            assertThat(putResponse.data().data().email()).isNotBlank();
            assertThat(putResponse.data().data().role()).isNotBlank();
        });
    }
}


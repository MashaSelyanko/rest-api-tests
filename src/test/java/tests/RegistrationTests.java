package tests;

import models.registration.request.UserData;
import models.registration.response.InvalidRegistrationResponseRecordsModel;
import models.registration.request.RegistrationBodyModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import models.registration.response.SuccessfulRegistrationResponseRecordsModel;
import test_data.TestData;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTests extends TestBase {

    @DisplayName("Позитивный тест - создание пользователя: 201 статус-код")
    @Test
    public void successfulRegistrationTest() {

        String expectedName = TestData.getRandomName();
        String expectedEmail = TestData.getRandomEmail();
        String getRandomRole = TestData.getRandomRole();

        UserData userData = new UserData(expectedName, expectedEmail, getRandomRole);
        RegistrationBodyModel request = new RegistrationBodyModel(userData);

        SuccessfulRegistrationResponseRecordsModel registrationResponse
                = api.register.mainRequest(request);

        step("Проверка соответствия name)", () -> {
            assertThat(registrationResponse.data().data().name())
                    .as("Проверка на соответствие name")
                    .isEqualTo(expectedName);
        });

        step("Проверка соответствия email)", () -> {
            assertThat(registrationResponse.data().data().email())
                    .as("Проверка на соответствие email")
                    .isEqualTo(expectedEmail);
        });

        step("Проверка соответствия role)", () -> {
            assertThat(registrationResponse.data().data().role())
                    .as("Проверка на соответствие role")
                    .isEqualTo(getRandomRole);
        });

        step("Проверка, что ID пользователя — положительное число", () -> {
            assertThat(registrationResponse.data().id())
                    .as("Проверка, что id не null")
                    .isNotNull()
                    .isNotEmpty();
        });

        step("Проверка, что createdAt не null", () -> {
            assertThat(registrationResponse.data().createdAt()).isNotNull();
        });
    }

    @DisplayName("Негативный тест - отправка невалидного JSON (два значения в поле name)")
    @Test
    void createUser_invalidBody_returns400() {

        String invalidJson = TestData.getInvalidJsonWithListName();

        InvalidRegistrationResponseRecordsModel invalidRegistrationResponse
                = api.register.invalidRequest(invalidJson);

        step("Верификация сообщения об ошибке валидации бэкенда (400)", () -> {
            String actualError = invalidRegistrationResponse.error();

            assertThat(actualError)
                    .as("Проверка текста ошибки при невалидном Json в запросе")
                    .isEqualTo(TestData.EXPECTED_ERROR_INVALID_JSON);
        });
    }
}


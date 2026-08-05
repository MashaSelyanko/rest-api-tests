package tests;

import models.registration.request.RegistrationBodyModel;
import models.registration.request.UserData;
import models.registration.response.SuccessfulRegistrationResponseRecordsModel;
import models.users.users_get.UsersListResponseModel;
import models.users.users_patch.PatchUsersResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test_data.TestData;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class UsersDeleteTest extends TestBase {

   @DisplayName("Успешное удаление пользователя: 204 статус-код")
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

       //удаление пользователя
       String userId = registrationResponse.data().id();
       api.userDelete.mainRequestDeleteUser(userId);

      //убеждаемся, что пользователь действительно удален
      step("Проверка отсутствия пользователя в общем списке", () -> {
         // Делаем GET-запрос на получение актуального списка
         UsersListResponseModel usersList = api.userGet.mainRequestUser();

         //ищем, есть ли в списке пользователь с таким же ID
         boolean isDeletedUserFound = usersList.data().stream()
                 .anyMatch(user -> user.id().equals(userId));

         //проверяем, что его там нет
         assertThat(isDeletedUserFound)
                 .as("Удаленный пользователь с ID %s не должен присутствовать в списке", userId)
                 .isFalse();
});
      }
}


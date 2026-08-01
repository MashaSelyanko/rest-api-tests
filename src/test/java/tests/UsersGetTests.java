package tests;

import models.users.users_get.UserRecord;
import models.users.users_get.UsersListResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class UsersGetTests extends TestBase {

    @DisplayName("Позитивный тест - получение списка пользователей: 200 статус-код")
    @Test
    public void successfulGetUsersTest() {
        UsersListResponseModel userRequest = api.userGet.mainRequestUser();

        step("Проверка мета-данных ответа и пагинации", () -> {
            assertThat(userRequest.data()).isNotEmpty();
            assertThat(userRequest.meta().total()).isGreaterThan(0);
            assertThat(userRequest.meta().page()).isEqualTo(1);
        });

        // Извлекаем первого пользователя для последующих проверок
        UserRecord firstUser = userRequest.data().get(0);

        step("Проверка мета-данных записи пользователя (ID и дата создания)", () -> {
            assertThat(firstUser.id()).isNotNull();
            assertThat(firstUser.createdAt()).isNotNull();
        });

        step("Проверка профиля пользователя", () -> {
            assertThat(firstUser.data().name()).isNotNull();
            assertThat(firstUser.data().email()).isNotNull();
            assertThat(firstUser.data().role()).isNotNull();
        });
    }

}


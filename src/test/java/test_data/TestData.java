package test_data;

import net.datafaker.Faker;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;

public class TestData {

    public static String token = "dev_04464afad5d367ce712b8ae19acff00b73a730c19fb677ac";

    public static Faker faker = new Faker();

    public static @NonNull String getRandomName() {
        return "Usr_" + System.currentTimeMillis();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    private static final List<String> ROLES = List.of("admin", "manager", "user");

    public static String getRandomRole() {
        return ROLES.get(faker.random().nextInt(ROLES.size()));
    }

    public static String getInvalidJsonWithListName() {
        return """
                {
                "email": "jane@example.com",
                "name": "Jane Doe",
                "email": "jane@example.com"
                }
                """;
    }

    public static final String
    EXPECTED_ERROR_INVALID_JSON = "invalid_request_body",
    AUTH_CREDENTIALS_NOT_PROVIDED_ERROR ="missing_api_key";
}


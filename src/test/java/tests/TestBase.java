package tests;

import api_clients.ApiClient;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.jupiter.api.BeforeAll;
import test_data.TestData;

public class TestBase {

    protected static final ApiClient api = new ApiClient();


@BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    public static RestAssuredConfig timeoutConfig = RestAssured.config()
            .httpClient(HttpClientConfig.httpClientConfig()
                    .setParam("http.connection.timeout", 5000)
                    .setParam("http.socket.timeout", 10000));

}

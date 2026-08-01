package models.registration.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Данные пользователя
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserData(String name, String email, String role) {}

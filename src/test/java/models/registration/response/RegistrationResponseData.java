package models.registration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import models.registration.request.UserData;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RegistrationResponseData(
        String id,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        UserData data
) {}

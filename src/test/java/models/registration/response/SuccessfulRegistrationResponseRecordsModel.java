package models.registration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SuccessfulRegistrationResponseRecordsModel(
        RegistrationResponseData data
) {}

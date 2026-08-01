package models.registration.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InvalidRegistrationResponseRecordsModel(
        @JsonProperty("error") String error) {}

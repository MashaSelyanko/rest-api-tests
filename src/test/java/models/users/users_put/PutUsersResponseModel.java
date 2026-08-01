package models.users.users_put;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import models.users.users_get.UserRecord;

@JsonIgnoreProperties(ignoreUnknown = true)


public record PutUsersResponseModel(
        @JsonProperty("data")UserRecord data) {}

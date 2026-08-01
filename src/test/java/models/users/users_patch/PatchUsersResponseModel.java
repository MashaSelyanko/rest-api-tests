package models.users.users_patch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PatchUsersResponseModel(
        @JsonProperty("name") String name,
        @JsonProperty("email") String email,
        @JsonProperty("role") String role,
        @JsonProperty("updatedAt") String updatedAt
) {}
package models.users.users_get;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UsersListResponseModel(
        List<UserRecord> data,
        Meta meta
) {}
package models.users.users_get;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import models.registration.request.UserData;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserRecord(
        String id,
        @JsonProperty("collection_id") String collectionId,
        @JsonProperty("project_id") Integer projectId,
        @JsonProperty("app_user_id") String appUserId,
        @JsonProperty("created_by") Integer createdBy,
        @JsonProperty("created_at") String createdAt,
        @JsonProperty("updated_at") String updatedAt,
        @JsonProperty("deleted_at") String deletedAt,
        UserData data
) {}
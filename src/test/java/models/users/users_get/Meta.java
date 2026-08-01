package models.users.users_get;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Meta(
        Integer page,
        Integer limit,
        Integer total,
        Integer pages
) {}
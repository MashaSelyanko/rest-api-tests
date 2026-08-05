package api_clients;


public class ApiClient {

    public final RegisterPostApiClient register = new RegisterPostApiClient();
    public final UserGetApiClient userGet = new UserGetApiClient();
    public final UserPutApiClient userPut = new UserPutApiClient();
    public final UserPatchApiClient userPatch = new UserPatchApiClient();
    public final UserDeleteApiClient userDelete = new UserDeleteApiClient();
}
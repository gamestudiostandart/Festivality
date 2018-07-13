package test.mb.festivality.repository.communication.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class XAPIClient {

    public XAPIClient() {
        apiClientId = "testing-account-cli";
        apiToken = "$2y$10$C/quaRQUsrWa30hjQJuckOXbW9kIZ.W3G1TlLMYg6lr/XDUes7SM.";
    }

    @SerializedName("apiClientId")
    @Expose
    private String apiClientId;
    @SerializedName("apiToken")
    @Expose
    private String apiToken;

    public String getApiClientId() {
        return apiClientId;
    }

    public void setApiClientId(String apiClientId) {
        this.apiClientId = apiClientId;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    @Override
    public String toString() {
        return "{\"apiClientId\":\"" + apiClientId + "\",\"apiToken\":\"" + apiToken + "\"}";
    }
}

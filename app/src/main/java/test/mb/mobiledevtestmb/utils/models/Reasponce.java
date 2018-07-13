package test.mb.mobiledevtestmb.utils.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/*The model is needed for retrofit GsonConverterFactory*/
public class Reasponce {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("userAuthenticated")
    @Expose
    private boolean userAuthenticated;
    @SerializedName("apiAuthenticated")
    @Expose
    private boolean apiAuthenticated;
    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("responseSize")
    @Expose
    private int responseSize;

    @SerializedName("response")
    @Expose
    private ArrayList<User> response = null;

    @SerializedName("error")
    @Expose
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isUserAuthenticated() {
        return userAuthenticated;
    }

    public void setUserAuthenticated(boolean userAuthenticated) {
        this.userAuthenticated = userAuthenticated;
    }

    public boolean isApiAuthenticated() {
        return apiAuthenticated;
    }

    public void setApiAuthenticated(boolean apiAuthenticated) {
        this.apiAuthenticated = apiAuthenticated;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(int responseSize) {
        this.responseSize = responseSize;
    }

    public ArrayList<User> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<User> response) {
        this.response = response;
    }

}

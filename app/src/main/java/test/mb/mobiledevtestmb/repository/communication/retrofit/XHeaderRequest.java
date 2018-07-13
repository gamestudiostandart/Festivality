package test.mb.mobiledevtestmb.repository.communication.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class XHeaderRequest {

    public XHeaderRequest() {
        deviceId = "F334BABB-FF0B-4B05-9688-99C71089FD4F";
        pushToken = "1234234df567";
    }

    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("pushToken")
    @Expose
    private String pushToken;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    @Override
    public String toString() {
        return "{\"deviceId\":\"" + deviceId + "\",\"pushToken\":\"" + pushToken + "\"}";
    }
}

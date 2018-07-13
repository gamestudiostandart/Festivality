package test.mb.festivality.utils.models;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import test.mb.festivality.utils.Fields;

public class FileVariations {
    @SerializedName(Fields.SMALL)
    @Expose
    private String small;
    @SerializedName(Fields.ORIGINAL)
    @Expose
    private String original;
    @SerializedName(Fields.TINY)
    @Expose
    private String tiny;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTiny() {
        return tiny;
    }

    public void setTiny(String tiny) {
        this.tiny = tiny;
    }

    FileVariations(JSONObject jsonObject) {
        try {
            setSmall(jsonObject.getString(Fields.SMALL));
            setOriginal(jsonObject.getString(Fields.ORIGINAL));
            setTiny(jsonObject.getString(Fields.TINY));
        } catch (JSONException e) {
            Log.d("catch JSON addVariatio:", e.getMessage());
        }
    }
}

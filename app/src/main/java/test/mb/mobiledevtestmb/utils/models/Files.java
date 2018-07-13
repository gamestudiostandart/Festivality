package test.mb.mobiledevtestmb.utils.models;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import test.mb.mobiledevtestmb.utils.Fields;

public class Files {
    @SerializedName(Fields.DEFAULT)
    @Expose
    private String _default;
    @SerializedName(Fields.VARIATIONS)
    @Expose
    private FileVariations variations;

    public String getDefault() {
        return _default;
    }

    public void setDefault(String _default) {
        this._default = _default;
    }

    public FileVariations getVariations() {
        return variations;
    }

    public void setVariations(FileVariations variations) {
        this.variations = variations;
    }

    public Files(JSONObject jsonObject) {
        String defaultString = null;
        String variationString = null;
        try {
            defaultString = jsonObject.getString(Fields.DEFAULT);
            variationString = jsonObject.getString(Fields.VARIATIONS);
            variations = new FileVariations(new JSONObject(variationString));
        } catch (JSONException e) {
            Log.d("catch JSON addFile:", e.getMessage());
        }
        setDefault(defaultString);
    }
}

package test.mb.festivality.utils.models;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import test.mb.festivality.utils.Fields;

public class Medium {

    @SerializedName(Fields.TYPE)
    @Expose
    private String type;
    @SerializedName(Fields.FILES)
    @Expose
    private Files files;
    @SerializedName(Fields.LABEL)
    @Expose
    private String label;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Files getFiles() {
        return files;
    }

    public void setFiles(Files files) {
        this.files = files;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Medium (){

    }

    public Medium (JSONObject jsonObject){
        try {
            setType(jsonObject.getString(Fields.TYPE));
            setLabel(jsonObject.getString(Fields.LABEL));
            String filesString = jsonObject.getString(Fields.FILES);
            setFiles(new Files(new JSONObject(filesString)));
        } catch (Exception e) {
            Log.d("catch JSON addMedium:", e.getMessage());
        }
    }
}

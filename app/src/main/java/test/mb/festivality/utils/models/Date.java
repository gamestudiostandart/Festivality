package test.mb.festivality.utils.models;

import android.content.ContentValues;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Date {

    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void fromDatabaseConvert(){
        //        String list = getArguments().getString(LIST);
//
//        Log.d(TAG, "onCreate " + list);
//        selectedUsersList = new Gson().fromJson(list, new TypeToken<ArrayList<UserHelperModel>>() {}.getType());
    }


    public ContentValues toDatabaseConvert(ContentValues values, int id){
        values.put("id", id);
        if(getStartDate() != null){values.put("startDate", getStartDate());}else {values.putNull("startDate");}
        if(getEndDate() != null){values.put("endDate", getEndDate());}else {values.putNull("endDate");}
        return values;
    }

}

package test.mb.festivality.utils.parser.convert.stringtoarraymedium;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import test.mb.festivality.utils.models.Fields;
import test.mb.festivality.utils.models.Medium;

public class StringToArrayMediumConvertImpl implements StringToArrayMediumConverter {

    @Override
    public ArrayList<Medium> convert(String object) {
        ArrayList<Medium> list = null;
        try {
            JSONArray jsonArray = new JSONArray(object);
            list = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject mediaJSON = jsonArray.getJSONObject(i);
                list.add(new Medium(mediaJSON));
            }
        } catch (Exception e) {
            Log.d(Fields.LOG,  "StringToArrayMediumConvertImpl e = " + e.getMessage());
        }
        return list;
    }
}

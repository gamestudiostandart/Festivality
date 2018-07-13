package test.mb.mobiledevtestmb.utils.parser.convert.usertypestostring;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import test.mb.mobiledevtestmb.utils.Fields;

public class UserTypeToStringConvertImpl implements UserTypeToStringConverter {

    @Override
    public String convert(String object) {
        String result = "";
        ArrayList<String> list = null;
        try {
            JSONArray jsonArray = new JSONArray(object);
            list = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String mediaString = jsonObject.getString(Fields.TEXT);
                list.add(mediaString);
            }
            result = TextUtils.join(", ", list);
        } catch (Exception e) {
            Log.d(Fields.LOG, "UserTypeToStringConvertImpl e = " + e.getMessage());
        }
        return result;
    }
}

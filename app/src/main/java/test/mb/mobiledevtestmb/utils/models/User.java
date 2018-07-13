package test.mb.mobiledevtestmb.utils.models;

import android.content.ContentValues;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import test.mb.mobiledevtestmb.repository.communication.userlist.interfaces.OnFinishedListener;
import test.mb.mobiledevtestmb.utils.Fields;
import test.mb.mobiledevtestmb.utils.models.seach.UserField;
import test.mb.mobiledevtestmb.utils.parser.convert.stringtoarraymedium.StringToArrayMediumConvertImpl;
import test.mb.mobiledevtestmb.utils.parser.convert.stringtoarraymedium.StringToArrayMediumConverter;
import test.mb.mobiledevtestmb.utils.parser.convert.usertypestostring.UserTypeToStringConvertImpl;
import test.mb.mobiledevtestmb.utils.parser.convert.usertypestostring.UserTypeToStringConverter;

/*Model for one news*/
public class User {

    public ArrayList<UserField> getList(){
        ArrayList<UserField>list = getCustomFields().getList();
        list.add(new UserField("Featured", String.valueOf(getIsFeatured())));
        list.add(new UserField("Children", getChildren()));
        list.add(new UserField("Type", getType()));
        list.add(new UserField("Likes", String.valueOf(getLikes())));
        return list;
    }

    @SerializedName(Fields.ID)
    @Expose
    private int id = 0;
    @SerializedName(Fields.IS_FEATURED)
    @Expose
    private int isFeatured = 0;
    @SerializedName(Fields.TYPE)
    @Expose
    private String type = null;
    @SerializedName(Fields.CUSTOM_FIELDS)
    @Expose
    private CustomFields customFields;
    @SerializedName(Fields.DATE)
    @Expose
    private Date date;
    @SerializedName(Fields.LIKES)
    @Expose
    private int likes = 0;
    @SerializedName(Fields.OBJECT)
    @Expose
    private String object;
    @SerializedName(Fields.SHARE)
    @Expose
    private String share;
    @SerializedName(Fields.SLUG)
    @Expose
    private String slug;
    @SerializedName(Fields.RSVP)
    @Expose
    private String rsvp;
    @SerializedName(Fields.CHILDREN)
    @Expose
    private String children = null;
    @SerializedName(Fields.MEDIA)
    @Expose
    private ArrayList<Medium> media = null;
    @SerializedName(Fields.ILIKE)
    @Expose
    private String ilike;
    @SerializedName(Fields.IRATE)
    @Expose
    private String irate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIsFeatured() {
        return isFeatured;
    }
    public void setIsFeatured(int isFeatured) {
        this.isFeatured = isFeatured;
    }
    public String getType() {

        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public CustomFields getCustomFields() {
        return customFields;
    }
    public void setCustomFields(CustomFields customFields) {
        this.customFields = customFields;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public String getObject() {
        return object;
    }
    public void setObject(String object) {
        this.object = object;
    }
    public String getShare() {
        return share;
    }
    public void setShare(String share) {
        this.share = share;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public String getRsvp() {
        return rsvp;
    }
    public void setRsvp(String rsvp) {
        this.rsvp = rsvp;
    }
    public String getChildren() {
        return children;
    }
    public void setChildren(String children) {
        this.children = children;
    }
    public ArrayList<Medium> getMedia() {
        return media;
    }
    public void setMedia(ArrayList<Medium> media) {
        this.media = media;
    }
    public String getIlike() {
        return ilike;
    }
    public void setIlike(String ilike) {
        this.ilike = ilike;
    }
    public String getIrate() {
        return irate;
    }
    public void setIrate(String irate) {
        this.irate = irate;
    }

    public User() {
    }

    public void fromDatabaseConvert(){
        //        String list = getArguments().getString(LIST);
//
//        Log.d(TAG, "onCreate " + list);
//        selectedUsersList = new Gson().fromJson(list, new TypeToken<ArrayList<UserHelperModel>>() {}.getType());
    }

    public ContentValues toDatabaseConvert(ContentValues values){

        values.put(Fields.ID, getId());
        values.put(Fields.IS_FEATURED, getIsFeatured());
        values.put(Fields.LIKES, getLikes());

        if(getObject() != null){values.put(Fields.OBJECT, getObject());} else {values.putNull(Fields.OBJECT);}
        if(getShare() != null){values.put(Fields.SHARE, getShare());} else {values.putNull(Fields.SHARE);}
        if(getSlug() != null){values.put(Fields.SLUG, getSlug());} else {values.putNull(Fields.SLUG);}
        if(getRsvp() != null){values.put(Fields.RSVP, getRsvp());} else {values.putNull(Fields.RSVP);}
        if(getIlike() != null){values.put(Fields.ILIKE, getIlike());} else {values.putNull(Fields.ILIKE);}
        if(getIrate() != null){values.put(Fields.IRATE, getIrate());} else {values.putNull(Fields.IRATE);}
        if(getType() != null){values.put(Fields.TYPE, new Gson().toJson(getType()));} else {values.putNull(Fields.TYPE);}
        if(getMedia() != null){values.put(Fields.MEDIA, new Gson().toJson(getMedia()));} else {values.putNull(Fields.MEDIA);}
        return values;
    }


    public User(JSONObject jsonObject, OnFinishedListener listener) {
        int id = 0;
        try {
            id = jsonObject.getInt(Fields.ID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            setId(jsonObject.getInt(Fields.ID));
            setIsFeatured(jsonObject.getInt(Fields.IS_FEATURED));
            setLikes(jsonObject.getInt(Fields.LIKES));
            setObject(jsonObject.getString(Fields.OBJECT));

            setShare(jsonObject.getString(Fields.SHARE));
            setSlug(jsonObject.getString(Fields.SLUG));
            setRsvp(jsonObject.getString(Fields.RSVP));
            setIlike(jsonObject.getString(Fields.ILIKE));
            setIrate(jsonObject.getString(Fields.IRATE));

            String typeString = jsonObject.getString(Fields.TYPE);
            UserTypeToStringConverter converter = new UserTypeToStringConvertImpl();
            setType(converter.convert(typeString));

            String mediaString = jsonObject.getString(Fields.MEDIA);
            StringToArrayMediumConverter converterMedia = new StringToArrayMediumConvertImpl();
            setMedia(converterMedia.convert(mediaString));

            String fieldsString = jsonObject.getString(Fields.CUSTOM_FIELDS);
            if (!fieldsString.equals("0")) {
                JSONObject fieldsJSON = new JSONObject(fieldsString);
                setCustomFields(new CustomFields(fieldsJSON));
            }
        } catch (Exception e) {
            Log.d("User: ",  "id = " + id + " e " + e.getMessage());
        }
        listener.onFinishedAddUser(this);
    }
}
package test.mb.festivality.utils.models;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;

import test.mb.festivality.MyApp;
import test.mb.festivality.R;
import test.mb.festivality.utils.Fields;
import test.mb.festivality.utils.models.seach.UserField;

public class CustomFields {

    public CustomFields() {

    }

    @SerializedName(Fields.FULL_NAME)
    @Expose
    private String fullName;
    @SerializedName(Fields.FIRST_NAME)
    @Expose
    private String firstName;
    @SerializedName(Fields.LAST_NAME)
    @Expose
    private String lastName;
    @SerializedName(Fields.EMAIL)
    @Expose
    private String email;
    @SerializedName(Fields.PUBLIC_EMAIL)
    @Expose
    private String publicEmail;
    @SerializedName(Fields.COMPANY)
    @Expose
    private String company;
    @SerializedName(Fields.POSITION)
    @Expose
    private String position;
    @SerializedName(Fields.GENDER)
    @Expose
    private String gender;
    @SerializedName(Fields.COUNTRY_CODE)
    @Expose
    private String countryCode;
    @SerializedName(Fields.PHONE)
    @Expose
    private String phone;
    @SerializedName(Fields.CITY)
    @Expose
    private String city;
    @SerializedName(Fields.AGE)
    @Expose
    private int age = 0;
    @SerializedName(Fields.ATTENDEE_PROVIDING)
    @Expose
    private String attendeeProviding = null;
    @SerializedName(Fields.ATTENDEE_LOOKING_FOR)
    @Expose
    private String attendeeLookingFor = null;
    @SerializedName(Fields.POSITION_TYPE)
    @Expose
    private String positionType = null;
    @SerializedName(Fields.ATTENDEE_TYPE)
    @Expose
    private String attendeeType = null;
    @SerializedName(Fields.INDUSTRY_TAGS)
    @Expose
    private String industryTags = null;
    @SerializedName(Fields.INDUSTRY_COMPLIMENTARY_TAGS)
    @Expose
    private String industryComplimentaryTags = null;
    @SerializedName(Fields.COMPANY_SIZE)
    @Expose
    private String companySize;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPublicEmail() {
        return publicEmail;
    }
    public void setPublicEmail(String publicEmail) {
        this.publicEmail = publicEmail;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAttendeeProviding() {
        return attendeeProviding;
    }
    public void setAttendeeProviding(String attendeeProviding) {
        this.attendeeProviding = attendeeProviding;
    }
    public String getAttendeeLookingFor() {
        return attendeeLookingFor;
    }
    public void setAttendeeLookingFor(String attendeeLookingFor) {
        this.attendeeLookingFor = attendeeLookingFor;
    }
    public String getPositionType() {
        return positionType;
    }
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
    public String getAttendeeType() {
        return attendeeType;
    }
    public void setAttendeeType(String attendeeType) {
        this.attendeeType = attendeeType;
    }
    public String getIndustryTags() {
        return industryTags;
    }
    public void setIndustryTags(String industryTags) {
        this.industryTags = industryTags;
    }
    public String getIndustryComplimentaryTags() {
        return industryComplimentaryTags;
    }
    public void setIndustryComplimentaryTags(String industryComplimentaryTags) {
        this.industryComplimentaryTags = industryComplimentaryTags;
    }
    public String getCompanySize() {
        return companySize;
    }
    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public ContentValues toDatabaseConvert(ContentValues values, int id) {
        values.put(Fields.ID_CUSTOM_FIELS_TABLES, id);

        if (getFullName() != null) {
            values.put(Fields.FULL_NAME, getFullName());
        } else {
            values.putNull(Fields.FULL_NAME);
        }
        if (getFirstName() != null) {
            values.put(Fields.FIRST_NAME, getFirstName());
        } else {
            values.putNull(Fields.FIRST_NAME);
        }
        if (getLastName() != null) {
            values.put(Fields.LAST_NAME, getLastName());
        } else {
            values.putNull(Fields.LAST_NAME);
        }
        if (getEmail() != null) {
            values.put(Fields.EMAIL, getEmail());
        } else {
            values.putNull(Fields.EMAIL);
        }
        if (getPublicEmail() != null) {
            values.put(Fields.PUBLIC_EMAIL, getPublicEmail());
        } else {
            values.putNull(Fields.PUBLIC_EMAIL);
        }
        if (getCompany() != null) {
            values.put(Fields.COMPANY, getCompany());
        } else {
            values.putNull(Fields.COMPANY);
        }
        if (getPosition() != null) {
            values.put(Fields.POSITION, getPosition());
        } else {
            values.putNull(Fields.POSITION);
        }
        if (getGender() != null) {
            values.put(Fields.GENDER, getGender());
        } else {
            values.putNull(Fields.GENDER);
        }
        if (getCountryCode() != null) {
            values.put(Fields.COUNTRY_CODE, getCountryCode());
        } else {
            values.putNull(Fields.COUNTRY_CODE);
        }
        if (getPhone() != null) {
            values.put(Fields.PHONE, getPhone());
        } else {
            values.putNull(Fields.PHONE);
        }
        if (getCity() != null) {
            values.put(Fields.CITY, getCity());
        } else {
            values.putNull(Fields.CITY);
        }
        if (getCompanySize() != null) {
            values.put(Fields.COMPANY_SIZE, getCompanySize());
        } else {
            values.putNull(Fields.COMPANY_SIZE);
        }
        values.put(Fields.AGE, getAge());
        if (getAttendeeProviding() != null) {
            values.put(Fields.ATTENDEE_PROVIDING, getAttendeeProviding());
        } else {
            values.putNull(Fields.ATTENDEE_PROVIDING);
        }
        if (getAttendeeLookingFor() != null) {
            values.put(Fields.ATTENDEE_LOOKING_FOR, getAttendeeLookingFor());
        } else {
            values.putNull(Fields.ATTENDEE_LOOKING_FOR);
        }
        if (getPositionType() != null) {
            values.put(Fields.POSITION_TYPE, getPositionType());
        } else {
            values.putNull(Fields.POSITION_TYPE);
        }
        if (getAttendeeType() != null) {
            values.put(Fields.ATTENDEE_TYPE, getAttendeeType());
        } else {
            values.putNull(Fields.ATTENDEE_TYPE);
        }
        if (getIndustryTags() != null) {
            values.put(Fields.INDUSTRY_TAGS, getIndustryTags());
        } else {
            values.putNull(Fields.INDUSTRY_TAGS);
        }
        if (getIndustryComplimentaryTags() != null) {
            values.put(Fields.INDUSTRY_COMPLIMENTARY_TAGS, getIndustryComplimentaryTags());
        } else {
            values.putNull(Fields.INDUSTRY_COMPLIMENTARY_TAGS);
        }
        return values;
    }

    public CustomFields(JSONObject jsonObject) {
        try {
            setFullName(jsonObject.getString(Fields.FULL_NAME));
            setFirstName(jsonObject.getString(Fields.FIRST_NAME));
            setLastName(jsonObject.getString(Fields.LAST_NAME));
            setEmail(jsonObject.getString(Fields.EMAIL));
            setPublicEmail(jsonObject.getString(Fields.PUBLIC_EMAIL));
            setCompany(jsonObject.getString(Fields.COMPANY));
            setPosition(jsonObject.getString(Fields.POSITION));
            setGender(jsonObject.getString(Fields.GENDER));
            setCountryCode(jsonObject.getString(Fields.COUNTRY_CODE));
            setPhone(jsonObject.getString(Fields.PHONE));
            setCity(jsonObject.getString(Fields.CITY));
            setAge(jsonObject.getInt(Fields.AGE));
            setCompanySize(jsonObject.getString(Fields.COMPANY_SIZE));
            setAttendeeProviding(TextUtils.join(", ", new Gson().fromJson(jsonObject.getString(Fields.ATTENDEE_PROVIDING), ArrayList.class)));
            setAttendeeLookingFor(TextUtils.join(", ", new Gson().fromJson(jsonObject.getString(Fields.ATTENDEE_LOOKING_FOR), ArrayList.class)));
            setPositionType(TextUtils.join(", ", new Gson().fromJson(jsonObject.getString(Fields.POSITION_TYPE), ArrayList.class)));
            setAttendeeType(TextUtils.join(", ", new Gson().fromJson(jsonObject.getString(Fields.ATTENDEE_TYPE), ArrayList.class)));
            setIndustryTags(TextUtils.join(", ", new Gson().fromJson(jsonObject.getString(Fields.INDUSTRY_TAGS), ArrayList.class)));
            setIndustryComplimentaryTags(TextUtils.join(", ", new Gson().fromJson(jsonObject.getString(Fields.INDUSTRY_COMPLIMENTARY_TAGS), ArrayList.class)));
        } catch (Exception e) {
            Log.d(Fields.LOG, "CustomFields e = " + e.getMessage());
        }
    }

    public ArrayList<UserField> getList(){
        ArrayList<UserField>list = new ArrayList<>();
        if(getFirstName() != null ||  getFirstName().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.first_name), getFirstName()));}
        if(getLastName() != null ||  getLastName().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.last_name), getLastName()));}
        if(getPosition() != null ||  getPosition().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.position), getPosition()));}
        if(getCompany() != null ||  getCompany().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.company), getCompany()));}
        if(getCompanySize() != null ||  getCompanySize().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.company_size), getCompanySize()));}
        if(getPhone() != null ||  getPhone().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.phone), getPhone()));}
        if(getEmail() != null ||  getEmail().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.email), getEmail()));}
        if(getPublicEmail() != null ||  getPublicEmail().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.public_email), getPublicEmail()));}
        if(getCity() != null ||  getCity().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.city), getCity()));}
        list.add(new UserField(MyApp.getContext().getResources().getString(R.string.age), getAge() == 0?null:String.valueOf(getAge())));

        if(getAttendeeProviding() != null ||  getAttendeeProviding().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.attendee_providing), getAttendeeProviding().replaceAll(", ", "\n")));}
        if(getAttendeeLookingFor() != null ||  getAttendeeLookingFor().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.attendee_looking_for), getAttendeeLookingFor().replaceAll(", ", "\n")));}
        if(getPositionType() != null ||  getPositionType().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.position_type), getPositionType().replaceAll(", ", "\n")));}
        if(getAttendeeType() != null ||  getAttendeeType().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.attendee_type), getAttendeeType().replaceAll(", ", "\n")));}
        if(getIndustryTags() != null ||  getIndustryTags().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.industry_tags), getIndustryTags().replaceAll(", ", "\n")));}
        if(getIndustryComplimentaryTags() != null ||  getIndustryComplimentaryTags().length() != 0){list.add(new UserField(MyApp.getContext().getResources().getString(R.string.industry_complimentary_tags), getIndustryComplimentaryTags().replaceAll(", ", "\n")));}
        return list;
    }

}

package test.mb.mobiledevtestmb.utils.models.seach;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import test.mb.mobiledevtestmb.utils.Fields;

public class SearchFilter {

    private ArrayList<FilterModel>list;
    private String search = "";

    private FilterModel type = new FilterModel(Fields.TYPE, false);
    private FilterModel fullName = new FilterModel(Fields.FULL_NAME, true);
    private FilterModel company = new FilterModel(Fields.COMPANY, false);
    private FilterModel position = new FilterModel(Fields.POSITION, false);
    private FilterModel gender = new FilterModel(Fields.GENDER, false);
    private FilterModel city = new FilterModel(Fields.CITY, false);
    private FilterModel attendeeProviding = new FilterModel(Fields.ATTENDEE_PROVIDING, false);
    private FilterModel attendeeLookingFor = new FilterModel(Fields.ATTENDEE_LOOKING_FOR, false);
    private FilterModel positionType  = new FilterModel(Fields.POSITION_TYPE, false);
    private FilterModel attendeeType = new FilterModel(Fields.ATTENDEE_TYPE, false);
    private FilterModel industryTags = new FilterModel(Fields.INDUSTRY_TAGS, false);
    private FilterModel industryComplimentaryTags = new FilterModel(Fields.INDUSTRY_COMPLIMENTARY_TAGS, false);

    private FilterModel companySize = new FilterModel(Fields.COMPANY_SIZE, false);
    private FilterModel age = new FilterModel(Fields.AGE, false);

    private int companySizefromValue;
    private int companySizeToValue;
    private int ageValuefrom = 20;
    private int ageValueTo = 30;

    public FilterModel getCompanySize() {
        return companySize;
    }
    public void setCompanySize(FilterModel companySize) {
        this.companySize = companySize;
    }
    public FilterModel getAge() {
        return age;
    }
    public void setAge(FilterModel age) {
        this.age = age;
    }
    public int getCompanySizefromValue() {
        return companySizefromValue;
    }
    public void setCompanySizefromValue(int companySizefromValue) {
        this.companySizefromValue = companySizefromValue;
    }
    public int getCompanySizeToValue() {
        return companySizeToValue;
    }
    public void setCompanySizeToValue(int companySizeToValue) {
        this.companySizeToValue = companySizeToValue;
    }
    public int getAgeValuefrom() {
        return ageValuefrom;
    }
    public void setAgeValuefrom(int ageValuefrom) {
        this.ageValuefrom = ageValuefrom;
    }
    public int getAgeValueTo() {
        return ageValueTo;
    }
    public void setAgeValueTo(int ageValueTo) {
        this.ageValueTo = ageValueTo;
    }
    public FilterModel getType() {
        return type;
    }
    public void setType(FilterModel type) {
        this.type = type;
    }
    public FilterModel getFullName() {
        return fullName;
    }
    public void setFullName(FilterModel fullName) {
        this.fullName = fullName;
    }
    public FilterModel getCompany() {
        return company;
    }
    public void setCompany(FilterModel company) {
        this.company = company;
    }
    public FilterModel getPosition() {
        return position;
    }
    public void setPosition(FilterModel position) {
        this.position = position;
    }
    public FilterModel getGender() {
        return gender;
    }
    public void setGender(FilterModel gender) {
        this.gender = gender;
    }
    public FilterModel getCity() {
        return city;
    }
    public void setCity(FilterModel city) {
        this.city = city;
    }
    public FilterModel getAttendeeProviding() {
        return attendeeProviding;
    }
    public void setAttendeeProviding(FilterModel attendeeProviding) {
        this.attendeeProviding = attendeeProviding;
    }
    public FilterModel getAttendeeLookingFor() {
        return attendeeLookingFor;
    }
    public void setAttendeeLookingFor(FilterModel attendeeLookingFor) {
        this.attendeeLookingFor = attendeeLookingFor;
    }
    public FilterModel getPositionType() {
        return positionType;
    }
    public void setPositionType(FilterModel positionType) {
        this.positionType = positionType;
    }
    public FilterModel getAttendeeType() {
        return attendeeType;
    }
    public void setAttendeeType(FilterModel attendeeType) {
        this.attendeeType = attendeeType;
    }
    public FilterModel getIndustryTags() {
        return industryTags;
    }
    public void setIndustryTags(FilterModel industryTags) {
        this.industryTags = industryTags;
    }
    public FilterModel getIndustryComplimentaryTags() {
        return industryComplimentaryTags;
    }
    public void setIndustryComplimentaryTags(FilterModel industryComplimentaryTags) {
        this.industryComplimentaryTags = industryComplimentaryTags;
    }
    public ArrayList<FilterModel> getList() {
        if(list == null){
            list = new ArrayList<>();
            list.add(type);
            list.add(fullName);
            list.add(company);
            list.add(position);
            list.add(gender);
            list.add(attendeeProviding);
            list.add(attendeeLookingFor);
            list.add(positionType);
            list.add(attendeeType);
            list.add(industryTags);
            list.add(industryComplimentaryTags);
        }
        return list;
    }
    public void setList(ArrayList<FilterModel> list) {
        this.list = list;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }














    public String getSelection(){
        ArrayList<FilterModel> list = getListForSearch();

        String result = null;
        String start = null;
        String end = null;

        if(list.size() != 0){
            if(list.size() == 1){
                result = list.get(0).getValue() + " like '%" + getSearch() + "%'";
            } else {
                result = "(";
                for(int i = 0; i < list.size();i++){
                    if(i == list.size() - 1){
                        result = result + list.get(i).getValue() + " like '%" + search + "%')";
                    } else {
                        result = result + list.get(i).getValue() + " like '%" + search + "%' OR ";
                    }
                }
            }
        }

        Log.d("asdasd", "result = " + result);
        return result;
    }

//    public String getHeaving() {
//        String heaving = "(" +
//                KEY_BODY + " like '%" + getSearch() + "%' " +
//                KEY_TITLE + " like '%" + inputText + "%' OR " +
//                KEY_TITLE + " like '%" + inputText + "%' OR " +
//                KEY_TITLE + " like '%" + inputText + "%' OR " +
//                KEY_TITLE + " like '%" + inputText + "%' OR " +
//                KEY_TITLE + " like '%" + inputText + "%' OR " +
//                KEY_TITLE + " like '%" + inputText + "%' OR " +
//                KEY_TITLE + " like '%" + inputText + "%' OR " +
//                KEY_TITLE + " like '%" + inputText + "%')";
//        ArrayList<FilterModel> list = getLIstForSort();
//        if(list.size() != 0){
//            if(list.size() == 1){
//                if(list.get(0).getValue().equals(Fields.AGE)){
//                    heaving = "(sum(" + Fields.AGE + ") > " + ageValuefrom + " AND " + "sum(" + Fields.AGE + ") < " + ageValuefrom + ")";
//                    Log.d("asdasd", heaving);
//                    groupBy = Fields.AGE;
//                } else {
//
//                }
//            } else {
//
//            }
//
//        }
//        return heaving;
//    }

    private void chackField(ArrayList<FilterModel>list, FilterModel filterModel){
        if(filterModel.isCheck()){
            list.add(filterModel);
        }
    }

    private ArrayList<FilterModel> getListForSearch(){
        ArrayList<FilterModel>list = new ArrayList<>();
        chackField(list, type);
        chackField(list, fullName);
        chackField(list, company);
        chackField(list, position);
        chackField(list, gender);
        chackField(list, attendeeProviding);
        chackField(list, attendeeLookingFor);
        chackField(list, positionType);
        chackField(list, attendeeType);
        chackField(list, industryTags);
        chackField(list, industryComplimentaryTags);
        return list;
    }

    private ArrayList<FilterModel> getLIstForSort(){
        ArrayList<FilterModel>list = new ArrayList<>();
        chackField(list, companySize);
        chackField(list, age);
        return list;
    }


    //    Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
//            KEY_TIME, KEY_TITLE, KEY_COLOR, KEY_BODY},
//
//            "(" +
//                    KEY_BODY + " like '%" + inputText + "%' OR " +
//                    KEY_TITLE + " like '%" + inputText + "%' OR " +
//                    KEY_TITLE + " like '%" + inputText + "%' OR " +
//                    KEY_TITLE + " like '%" + inputText + "%' OR " +
//                    KEY_TITLE + " like '%" + inputText + "%' OR " +
//                    KEY_TITLE + " like '%" + inputText + "%' OR " +
//                    KEY_TITLE + " like '%" + inputText + "%' OR " +
//                    KEY_TITLE + " like '%" + inputText + "%' OR " +
//                    KEY_TITLE + " like '%" + inputText + "%')" , null,
//            null, null, KEY_TIME + " DESC", null);



    public Cursor getSearchResult(SQLiteDatabase DB){

//        if(listForSearch.size() == 0 || listForSort.size() == 0){
//
//        }

//        WHERE (last_name = 'Davis' OR last_name = 'Jones')
//        AND employee_id < 50;


//        Cursor cursor = DB.query();
        Cursor cursor;
        String body  = "";


        return cursor = null;
    }

    public String getQwery(){
        List<FilterModel> list = Arrays.asList(
                type, fullName, company, position, gender,
                city, attendeeProviding, attendeeLookingFor,
                positionType, attendeeType, industryTags, industryComplimentaryTags);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isCheck()){

            }
        }

        String a = "s";
        return a;
    }
}

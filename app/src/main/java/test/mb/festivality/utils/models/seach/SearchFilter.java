package test.mb.festivality.utils.models.seach;

import android.util.Log;

import java.util.ArrayList;

import test.mb.festivality.MyApp;
import test.mb.festivality.R;
import test.mb.festivality.utils.models.Fields;

public class SearchFilter {

    private FilterModel fullName = new FilterModel(Fields.FULL_NAME, true, MyApp.getContext().getResources().getString(R.string.name));
    private FilterModel company = new FilterModel(Fields.COMPANY, false, MyApp.getContext().getResources().getString(R.string.company));
    private FilterModel position = new FilterModel(Fields.POSITION, false, MyApp.getContext().getResources().getString(R.string.position));
    private FilterModel city = new FilterModel(Fields.CITY, false, MyApp.getContext().getResources().getString(R.string.city));
    private FilterModel type = new FilterModel(Fields.TYPE, false, MyApp.getContext().getResources().getString(R.string.type));
    private FilterModel attendeeProviding = new FilterModel(Fields.ATTENDEE_PROVIDING, false, MyApp.getContext().getResources().getString(R.string.attendee_providing));
    private FilterModel attendeeLookingFor = new FilterModel(Fields.ATTENDEE_LOOKING_FOR, false, MyApp.getContext().getResources().getString(R.string.attendee_looking_for));
    private FilterModel positionType  = new FilterModel(Fields.POSITION_TYPE, false, MyApp.getContext().getResources().getString(R.string.position_type));
    private FilterModel attendeeType = new FilterModel(Fields.ATTENDEE_TYPE, false, MyApp.getContext().getResources().getString(R.string.attendee_type));
    private FilterModel industryTags = new FilterModel(Fields.INDUSTRY_TAGS, false, MyApp.getContext().getResources().getString(R.string.industry_tags));
    private FilterModel industryComplimentaryTags = new FilterModel(Fields.INDUSTRY_COMPLIMENTARY_TAGS, false, MyApp.getContext().getResources().getString(R.string.industry_complimentary_tags));
    private FilterModel age = new FilterModel(Fields.AGE, true, MyApp.getContext().getResources().getString(R.string.age));

    private int ageFrom = 0;
    private int ageTo = 100;
    private ArrayList<FilterModel>list;
    private String search = "";

    public FilterModel getType() {
        return type;
    }
    public void setType(FilterModel type) {
        this.type = type;
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
    public FilterModel getCity() {
        return city;
    }
    public void setCity(FilterModel city) {
        this.city = city;
    }
    public int getAgeFrom() {
        return ageFrom;
    }
    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }
    public int getAgeTo() {
        return ageTo;
    }
    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
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
        ArrayList<String> list = getListForSearch();
        String result = "";
        if(list.size() != 0){
            if(list.size() == 1){
                result = list.get(0);
                if(list.get(0).substring(0, 1).equals("(")){
                    result = result.replace("(","");
                    result = result.replace(")","");
                }
            } else {
                if(list.get(list.size() - 1).substring(0, 1).equals("(")){

                    result = "(";
                    for(int i = 0; i < list.size() - 1;i++){
                        if(i != 0){
                            result = result + " OR ";
                        }
                        result = result + list.get(i);
                    }
                    result = result + ")" + " AND " + list.get(list.size() - 1);
                } else {
                    for(int i = 0; i < list.size();i++){
                        if(i != 0){
                            result = result + " OR ";
                        }
                        result = result + list.get(i);
                    }
                }
//                result = "(";
//                result = result + ")";
            }
        }

        Log.d("getSelection", "getSelection = " + result);
        return result;
    }
    private void chackField(ArrayList<String>list, FilterModel filterModel){
        String result = null;
        if(filterModel.isCheck()){
            if(filterModel.getValue().equals(Fields.AGE)){
                result = "(" + filterModel.getValue() + " > " + ageFrom + " AND " + filterModel.getValue() + " < " + ageTo + ")";
            } else {
                result = filterModel.getValue() + " like '%" + search + "%'";
            }
            list.add(result);
        }
    }
    private ArrayList<String> getListForSearch(){
        ArrayList<String>list = new ArrayList<>();
        chackField(list, fullName);
        chackField(list, company);
        chackField(list, position);
        chackField(list, city);

        chackField(list, type);
        chackField(list, attendeeProviding);
        chackField(list, attendeeLookingFor);
        chackField(list, positionType);
        chackField(list, attendeeType);
        chackField(list, industryTags);
        chackField(list, industryComplimentaryTags);
        chackField(list, age);
        return list;
    }
    public ArrayList<FilterModel> getList() {
        if(list == null){
            list = new ArrayList<>();

            list.add(fullName);
            list.add(company);
            list.add(position);
            list.add(city);

            list.add(type);
            list.add(attendeeProviding);
            list.add(attendeeLookingFor);
            list.add(positionType);
            list.add(attendeeType);
            list.add(industryTags);
            list.add(industryComplimentaryTags);
            list.add(age);
        }
        return list;
    }
}
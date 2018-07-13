package test.mb.festivality.utils.models.seach;

import android.util.Log;

import java.util.ArrayList;

import test.mb.festivality.MyApp;
import test.mb.festivality.R;
import test.mb.festivality.utils.models.Fields;

public class SearchFilter {

    private ArrayList<FilterModel>list;
    private String search = "";

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
        Log.d("getSelection", "getSelection = " + result);
        return result;
    }

    private void chackField(ArrayList<FilterModel>list, FilterModel filterModel){
        if(filterModel.isCheck()){
            list.add(filterModel);
        }
    }

    private ArrayList<FilterModel> getListForSearch(){
        ArrayList<FilterModel>list = new ArrayList<>();
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
        return list;
    }
}

package test.mb.mobiledevtestmb.utils.models.seach;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FilterModel {

    public FilterModel(String value, boolean check) {
        this.value = value;
        this.check = check;
    }

    private String value;
    private boolean check;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}

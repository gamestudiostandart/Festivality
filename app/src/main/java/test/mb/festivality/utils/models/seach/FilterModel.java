package test.mb.festivality.utils.models.seach;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FilterModel {

    public FilterModel(String value, boolean check, String name) {
        this.value = value;
        this.check = check;
        this.name = name;
    }

    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

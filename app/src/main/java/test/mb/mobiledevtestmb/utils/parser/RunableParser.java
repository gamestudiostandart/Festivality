package test.mb.mobiledevtestmb.utils.parser;

import org.json.JSONObject;
import java.util.concurrent.Callable;

import test.mb.mobiledevtestmb.repository.communication.userlist.interfaces.OnFinishedListener;
import test.mb.mobiledevtestmb.utils.models.User;
import test.mb.mobiledevtestmb.repository.database.DBHelper;

public class RunableParser implements Callable<User> {

    private JSONObject jsonObject;
    private OnFinishedListener listener;

    public RunableParser(JSONObject jsonObject, OnFinishedListener listener) {
        this.jsonObject = jsonObject;
        this.listener = listener;
    }

    @Override
    public User call() throws Exception {
        return new User(jsonObject, listener);
    }
}

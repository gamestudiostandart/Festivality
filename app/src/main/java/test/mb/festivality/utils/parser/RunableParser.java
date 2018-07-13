package test.mb.festivality.utils.parser;

import org.json.JSONObject;
import java.util.concurrent.Callable;

import test.mb.festivality.repository.communication.userlist.interfaces.GetDataListener;
import test.mb.festivality.utils.models.User;

public class RunableParser implements Callable<User> {

    private JSONObject jsonObject;
    private GetDataListener listener;

    public RunableParser(JSONObject jsonObject, GetDataListener listener) {
        this.jsonObject = jsonObject;
        this.listener = listener;
    }

    @Override
    public User call() throws Exception {
        return new User(jsonObject, listener);
    }
}

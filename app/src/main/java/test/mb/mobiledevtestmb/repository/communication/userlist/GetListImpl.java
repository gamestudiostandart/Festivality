package test.mb.mobiledevtestmb.repository.communication.userlist;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.mb.mobiledevtestmb.utils.models.User;
import test.mb.mobiledevtestmb.repository.communication.retrofit.XAPIClient;
import test.mb.mobiledevtestmb.repository.communication.retrofit.XHeaderRequest;
import test.mb.mobiledevtestmb.repository.communication.retrofit.RetrofitClient;
import test.mb.mobiledevtestmb.repository.communication.userlist.interfaces.OnFinishedListener;
import test.mb.mobiledevtestmb.repository.database.DBHelper;
import test.mb.mobiledevtestmb.utils.parser.RunableParser;

public class GetListImpl implements GetListInteractor {

    @Override
    public void getList(final OnFinishedListener listener) {
        Call<String> call = RetrofitClient.getInstance().getApiService().getList(new XAPIClient(), new XHeaderRequest());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, final Response<String> response) {
                if (response.body() != null) {
                    new Thread(new Runnable() {
                        public void run() {
                            JSONObject argJSON = null;
                            try {
                                argJSON = new JSONObject(response.body());
                                String mresponse = argJSON.getString("response");
                                JSONArray responseJSON = new JSONArray(mresponse);
                                List<Callable<User>> listtasks = new ArrayList<>();
                                for (int i = 0; i < responseJSON.length(); i++) {
                                    final JSONObject userJSON = responseJSON.getJSONObject(i);
                                    Callable<User> ran = new RunableParser(userJSON, listener);
                                    listtasks.add(ran);
                                }
                                startExecute(listener, listtasks);
                            } catch (JSONException e) {
                                listener.onFailedGetList(e.getMessage());
                                Log.d("finish", "JSONException");
                            }
                        }
                    }).start();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("finish", "onFailure " + t.toString());
                listener.onFailedGetList(t.toString());
            }
        });
    }

    private void startExecute(OnFinishedListener listener, List<Callable<User>> listtasks) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        try {
            List<Future<User>> list = es.invokeAll(listtasks);
            for (Future<User> fut : list) {
                es.shutdown();
                listener.onFinishedGetList();
            }
        } catch (Exception e) {
            Log.d("finish", "catch JSONException " + e);
            listener.onFinishedGetList();
            es.shutdown();
        } finally {
            Log.d("finish", "finally");
            listener.onFinishedGetList();
            es.shutdown();
        }
    }
}
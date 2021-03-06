package test.mb.festivality.repository.communication.userlist;


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
import test.mb.festivality.utils.models.User;
import test.mb.festivality.repository.communication.retrofit.XAPIClient;
import test.mb.festivality.repository.communication.retrofit.XHeaderRequest;
import test.mb.festivality.repository.communication.retrofit.RetrofitClient;
import test.mb.festivality.repository.communication.userlist.interfaces.GetDataListener;
import test.mb.festivality.utils.parser.RunableParser;

public class GetDataImpl implements GetDataInteractor {

    private ExecutorService es;

    @Override
    public void getList(final GetDataListener listener) {
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
                                int size = responseJSON.length();
                                int curentProcent = 0;

                                for (int i = 0; i < size; i++) {

                                    final JSONObject userJSON = responseJSON.getJSONObject(i);
                                    Callable<User> ran = new RunableParser(userJSON, listener);
                                    listtasks.add(ran);
                                    int runTimeProcent = i / (size / 100);
                                    if(runTimeProcent != curentProcent){
                                        curentProcent = runTimeProcent;
                                        listener.onProgress(i / (size / 100));
                                    }
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

    @Override
    public void closeConection() {
        if(es != null)
        es.shutdownNow();
    }

    private void startExecute(GetDataListener listener, List<Callable<User>> listtasks) {
        es = Executors.newFixedThreadPool(1);
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
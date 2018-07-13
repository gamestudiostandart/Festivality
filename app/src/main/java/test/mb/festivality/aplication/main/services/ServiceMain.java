package test.mb.festivality.aplication.main.services;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.util.Log;

import test.mb.festivality.repository.database.DBHelper;
import test.mb.festivality.utils.models.User;
import test.mb.festivality.repository.communication.userlist.GetDataImpl;
import test.mb.festivality.repository.communication.userlist.GetDataInteractor;
import test.mb.festivality.repository.communication.userlist.interfaces.GetDataListener;

public class ServiceMain extends IntentService implements GetDataListener {

    public final static String RECEIVER_LISTENER = "receiverTager";
    private ResultReceiver receiver;
    private int users = 0;
    private boolean notify = true;
    private GetDataInteractor getDataInteractor;
    private boolean serviceIsRun = false;

    public ServiceMain() {
        super(".services.ServiceMain");
    }

    @Override
    protected void onHandleIntent(Intent intent) {}

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        receiver = intent.getParcelableExtra(RECEIVER_LISTENER);
        if(!serviceIsRun){
            getDataInteractor = new GetDataImpl();
            serviceIsRun = true;
            users = 0;
            Log.d("startTread()", "startTread");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getDataInteractor.getList(ServiceMain.this);
                }
            }).start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        getDataInteractor.closeConection();
        super.onDestroy();
    }

    @Override
    public  void onFinishedAddUser(User user) {
        DBHelper.getInstance().addUdser(user);
        users++;
        if(users > 50){
            receiver.send(Activity.RESULT_OK, new Bundle());
            users = 0;
        }
    }

    @Override
    public void onFailedGetList(String message) {
        receiver.send(Activity.RESULT_OK, new Bundle());
        serviceIsRun = false;
        this.stopSelf();

    }

    @Override
    public void onFinishedGetList() {
        getDataInteractor.closeConection();
        receiver.send(Activity.RESULT_OK, new Bundle());
        serviceIsRun = false;
        this.stopSelf();
    }

    @Override
    public void onProgress(int progress) {
        Log.d("finish", "progress" + progress);
    }
}

package test.mb.mobiledevtestmb.aplication.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import test.mb.mobiledevtestmb.R;
import test.mb.mobiledevtestmb.aplication.main.ActivityMain;
import test.mb.mobiledevtestmb.repository.SharedPreferencesManager;
import test.mb.mobiledevtestmb.utils.fragmentAnimator.MFragmentManager;
import test.mb.mobiledevtestmb.utils.fragmentAnimator.NewFragment;
import test.mb.mobiledevtestmb.utils.fragmentAnimator.ReplaceToLeft;
import test.mb.mobiledevtestmb.utils.fragmentAnimator.ReplaceToRight;

public class ActivityLogin extends AppCompatActivity implements FragmentPermission.OnFragmentInteractionListener {

    private final int NOTIFICATION_FRAGMENT = 1;
    private final int LOCATION_FRAGMENT = 2;
    private final int BLUETOOTH_FRAGMENT = 3;
    private final int GET_STARTED_FRAGMENT = 4;

    private MFragmentManager mFragmentManager = new MFragmentManager();
    private int mCurentFragment;
    boolean mShowDialog = false;

    private FragmentPermission fragmentNotification, fragmentLocation, fragmentBluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_permission);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(getResources().getColor(R.color.colorLoginIcons));
//        }

        fragmentNotification = FragmentPermission.newInstance(R.drawable.ic_notifications, R.string.get_up_to_the, R.string.allow_festival_to_send, R.string.notifications);
        fragmentLocation = FragmentPermission.newInstance(R.drawable.ic_explore, R.string.enable_smart_location, R.string.get_guidance, R.string.location);
        fragmentBluetooth = FragmentPermission.newInstance(R.drawable.ic_bluetooth, R.string.enable_blueTooth, R.string.we_can_do_anything, R.string.blueTooth);


        boolean hasVisited = SharedPreferencesManager.getInstance(this).isFirstVisited();
        if (!hasVisited) {
            mCurentFragment = NOTIFICATION_FRAGMENT;
            mFragmentManager.setAction(new NewFragment());
            mFragmentManager.doTransaction(getSupportFragmentManager(), fragmentNotification, R.id.fl_conteiner_fragments);
        } else {
            startActivity(new Intent(this, ActivityMain.class));
            this.finish();
        }
    }

    public void permissionDone() {
        SharedPreferencesManager.getInstance(this).setFirstVisited(true);
        startActivity(new Intent(this, ActivityMain.class));
        this.finish();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (mShowDialog) {
            mShowDialog = false;
            skip();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mShowDialog = true;
        }
    }

    @Override
    public void permissionEnable() {
        if (mCurentFragment == NOTIFICATION_FRAGMENT) {
            showCustomDialog(getResources().getString(R.string.notifications));
        } else if (mCurentFragment == LOCATION_FRAGMENT) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(ActivityLogin.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_FRAGMENT);
            } else {
                showCustomDialog(getResources().getString(R.string.location));
            }
        } else if (mCurentFragment == BLUETOOTH_FRAGMENT) {
            showCustomDialog(getResources().getString(R.string.blueTooth));}
    }

    public void showCustomDialog(String head){
        new AlertDialog.Builder(ActivityLogin.this)
                .setTitle(head)
                .setMessage(R.string.exist_permission)
                .setCancelable(true)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        skip();
                    }
                }).show();
    }



    @Override
    public void skip() {
        mFragmentManager.setAction(new ReplaceToLeft());
        if (mCurentFragment == NOTIFICATION_FRAGMENT) {
            mCurentFragment = LOCATION_FRAGMENT;
            mFragmentManager.doTransaction(getSupportFragmentManager(), fragmentLocation, R.id.fl_conteiner_fragments);
        } else if (mCurentFragment == LOCATION_FRAGMENT) {
            mCurentFragment = BLUETOOTH_FRAGMENT;
            mFragmentManager.doTransaction(getSupportFragmentManager(), fragmentBluetooth, R.id.fl_conteiner_fragments);
        } else if (mCurentFragment == BLUETOOTH_FRAGMENT) {
            mCurentFragment = GET_STARTED_FRAGMENT;
            mFragmentManager.doTransaction(getSupportFragmentManager(), FragmentConfirm.newInstance(), R.id.fl_conteiner_fragments);
        }
    }

    @Override
    public void onBackPressed() {
        mFragmentManager.setAction(new ReplaceToRight());
        if (mCurentFragment == NOTIFICATION_FRAGMENT) {
            this.finish();
        } else if (mCurentFragment == LOCATION_FRAGMENT) {
            mCurentFragment = NOTIFICATION_FRAGMENT;
            mFragmentManager.doTransaction(getSupportFragmentManager(), fragmentNotification, R.id.fl_conteiner_fragments);
        } else if (mCurentFragment == BLUETOOTH_FRAGMENT) {
            mCurentFragment = LOCATION_FRAGMENT;
            mFragmentManager.doTransaction(getSupportFragmentManager(), fragmentLocation, R.id.fl_conteiner_fragments);
        } else if (mCurentFragment == GET_STARTED_FRAGMENT) {
            mCurentFragment = BLUETOOTH_FRAGMENT;
            mFragmentManager.doTransaction(getSupportFragmentManager(), fragmentBluetooth, R.id.fl_conteiner_fragments);
        }

    }
}

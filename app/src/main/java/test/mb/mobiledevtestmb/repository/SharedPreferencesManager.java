package test.mb.mobiledevtestmb.repository;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesManager {

    private static final String PREF_NAME = "t-9947.xml";
    private static final String KEY = "t-2482";

    private static SharedPreferencesManager sInstance;
    private final SharedPreferences mPref;

    private SharedPreferencesManager(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SharedPreferencesManager(context);
        }
    }

    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if (sInstance == null) {
            initializeInstance(context);
        }
        return sInstance;
    }

    public void setFirstVisited(boolean value) {
        mPref.edit().putBoolean(KEY, value)
                .apply();
    }

    public boolean isFirstVisited() {
        return mPref.getBoolean(KEY, false);
    }
}
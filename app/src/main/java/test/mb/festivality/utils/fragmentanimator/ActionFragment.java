package test.mb.festivality.utils.fragmentanimator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public interface ActionFragment {
    void setFragment(FragmentManager fragmentManager, Fragment fragment, int layoutId);
}

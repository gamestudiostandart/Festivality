package test.mb.mobiledevtestmb.utils.fragmentAnimator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class NewFragment implements ActionFragment {

    @Override
    public void setFragment(FragmentManager fragmentManager, Fragment fragment, int layoutId) {
        String tag = fragment.getClass().getSimpleName();
        if (fragmentManager.findFragmentByTag(tag) == null)
            fragmentManager.beginTransaction().replace(layoutId, fragment, tag).commitAllowingStateLoss();
    }
}

package test.mb.festivality.utils.fragmentAnimator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import test.mb.festivality.R;

public class ReplaceToRight implements ActionFragment {

    @Override
    public void setFragment(FragmentManager fragmentManager, Fragment fragment, int layoutId) {
        String tag = fragment.getClass().getSimpleName();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_left_to_rigth_new_fr
                , R.anim.slide_left_to_right_old_fr);
        fragmentTransaction.replace(layoutId, fragment, tag);
        fragmentTransaction.commit();
    }
}

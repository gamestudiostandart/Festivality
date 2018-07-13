package test.mb.mobiledevtestmb.utils.fragmentAnimator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class MFragmentManager {

    private ActionFragment mActionFragment;

    public void setAction(ActionFragment mActionFragment){
        this.mActionFragment = mActionFragment;
    }

    public  void doTransaction(FragmentManager fragmentManager, Fragment fragment, int layoutId){
        if(mActionFragment == null){
            mActionFragment = new NewFragment();
        }
        mActionFragment.setFragment(fragmentManager, fragment, layoutId);

    }
}

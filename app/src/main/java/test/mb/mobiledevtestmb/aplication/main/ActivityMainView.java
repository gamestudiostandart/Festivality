package test.mb.mobiledevtestmb.aplication.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.ArrayList;

import test.mb.mobiledevtestmb.utils.models.User;

public interface ActivityMainView extends MvpView {

    @StateStrategyType(SkipStrategy.class)
    void setNewList(ArrayList<User> list);

}

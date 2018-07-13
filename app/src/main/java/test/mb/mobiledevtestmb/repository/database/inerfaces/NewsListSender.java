package test.mb.mobiledevtestmb.repository.database.inerfaces;

import java.util.ArrayList;

import test.mb.mobiledevtestmb.utils.models.User;

public interface NewsListSender {
    void takeList(ArrayList<User> list);
}

package test.mb.festivality.repository.database.inerfaces;

import java.util.ArrayList;

import test.mb.festivality.utils.models.User;

public interface NewsListSender {
    void takeList(ArrayList<User> list);
}

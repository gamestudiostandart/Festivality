package test.mb.mobiledevtestmb.repository.database;




import test.mb.mobiledevtestmb.repository.database.inerfaces.NewsListSender;
import test.mb.mobiledevtestmb.utils.models.seach.SearchFilter;

public interface DBHelperInteractor {

    void getListUsers(int startOfSet, SearchFilter searchFilter, NewsListSender listener);
}

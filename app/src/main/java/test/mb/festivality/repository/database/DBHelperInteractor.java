package test.mb.festivality.repository.database;




import test.mb.festivality.repository.database.inerfaces.NewsListSender;
import test.mb.festivality.utils.models.seach.SearchFilter;

public interface DBHelperInteractor {

    void getListUsers(int startOfSet, SearchFilter searchFilter, NewsListSender listener);
}

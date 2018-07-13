package test.mb.mobiledevtestmb.aplication.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;

import test.mb.mobiledevtestmb.utils.Fields;
import test.mb.mobiledevtestmb.repository.database.DBHelper;
import test.mb.mobiledevtestmb.repository.database.inerfaces.NewsListSender;
import test.mb.mobiledevtestmb.utils.models.User;
import test.mb.mobiledevtestmb.repository.database.DBHelperInteractor;
import test.mb.mobiledevtestmb.utils.models.seach.SearchFilter;

@InjectViewState
public class ActivityMainPresenter extends MvpPresenter<ActivityMainView> implements NewsListSender {

    ActivityMainPresenter() {
        dbHelperInteractor = DBHelper.getInstance();
    }

    private DBHelperInteractor dbHelperInteractor;
    private ArrayList<User> list;
    private SearchFilter searchFilter;

    private boolean isServerConnection = false;
    private boolean isLoading = false;
    private boolean isPaging = false;
    private boolean isEndOfDatabase = false;
    private int visibleItemCount;
    private int totalItemCount;
    private int firstVisibleItem;

    public ArrayList<User> getList() {
        return list;
    }

    public boolean isPaging() {
        return isPaging;
    }

    public void setEndOfDatabase(boolean endOfDatabase) {
        isEndOfDatabase = endOfDatabase;
        doPaging();
    }

    private void doPaging(){
        if (!isPaging && !isEndOfDatabase && !isLoading &&
                (firstVisibleItem + (visibleItemCount * 3)) >= totalItemCount) {
            isLoading = true;
            isPaging = true;
            dbHelperInteractor.getListUsers(list.size(), getSearchFilter(), ActivityMainPresenter.this);
        }
    }

    public void initPaging(RecyclerView recyclerView, final LinearLayoutManager layoutManager){
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = layoutManager.getItemCount();
                firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                doPaging();
            }
        });
    }

    public void setPaging(boolean paging) {
        isPaging = paging;
    }

    public SearchFilter getSearchFilter() {
        if (searchFilter == null) {
            searchFilter = new SearchFilter();
        }
        return searchFilter;
    }

    public void getNew() {
        if (!isLoading) {
            isLoading = true;
            isPaging = false;
            if (list == null) {
                list = new ArrayList<>();
            }
            list.clear();
            dbHelperInteractor.getListUsers(list.size(), getSearchFilter(), ActivityMainPresenter.this);
        }
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    @Override
    public synchronized void takeList(ArrayList<User> list) {
        if (isPaging) {
            if (list.size() < Fields.REQWEST_TO_DATABASE_LIMIT) {
                isEndOfDatabase = true;
            }
        } else {
            isEndOfDatabase = false;
        }
        getViewState().setNewList(list);
        this.list.addAll(list);
    }

    public boolean isServerConnection() {
        return isServerConnection;
    }

    public void setServerConnection(boolean serverConnection) {
        isServerConnection = serverConnection;
    }
}
package test.mb.festivality.aplication.main;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.Objects;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;
import test.mb.festivality.R;
import test.mb.festivality.aplication.main.services.ServiceMain;
import test.mb.festivality.utils.models.User;

public class ActivityMain extends MvpAppCompatActivity implements ActivityMainView, ReceiverMainResult.Receiver {

    @InjectPresenter
    ActivityMainPresenter mPresenter;

    private AdapterUsers adapterUsers;
    private FrameLayout progress;
    private RecyclerView recyclerView;
    private ReceiverMainResult mReceiver;
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_list);

        progress = findViewById(R.id.progress);
        mDrawer = findViewById(R.id.mDrawer);

        mReceiver = new ReceiverMainResult(new Handler());
        mReceiver.setReceiver(this);

        initUserList();
        initSortList();
        initToolbar();

        if (mPresenter.getList() == null) {
            startConnection();
        } else {
            setNewList(mPresenter.getList());
        }
    }

    public void startConnection() {
        if (!mPresenter.isServerConnection()) {
            mPresenter.setServerConnection(true);
            Intent serviceIntent = new Intent(this, ServiceMain.class);
            serviceIntent.putExtra(ServiceMain.RECEIVER_LISTENER, mReceiver);
            startService(serviceIntent);
        }
    }

    private void initUserList() {
        adapterUsers = new AdapterUsers(this);
        LinearLayoutManager layoutManagerUsers = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        recyclerView.setLayoutManager(layoutManagerUsers);
        OverScrollDecoratorHelper.setUpOverScroll(recyclerView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        recyclerView.setAdapter(adapterUsers);
        mPresenter.initPaging(recyclerView, layoutManagerUsers);
    }

    private void initSortList() {
        AdapterSortList adapterSortList = new AdapterSortList(this, mPresenter.getSearchFilter().getList());
        LinearLayoutManager layoutManagerGroups = new LinearLayoutManager(this);
        RecyclerView rv_sort = findViewById(R.id.rv_sort);
        rv_sort.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        rv_sort.setLayoutManager(layoutManagerGroups);
        OverScrollDecoratorHelper.setUpOverScroll(rv_sort, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        rv_sort.setAdapter(adapterSortList);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.m_search);

        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));

        toolbar.setNavigationIcon(R.drawable.ic_sort);
        Objects.requireNonNull(toolbar.getNavigationIcon()).setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.openDrawer(Gravity.START);
            }
        });

        MenuItem btn_search = toolbar.getMenu().findItem(R.id.btn_search);
        btn_search.getIcon().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);

        final SearchView searchView = (SearchView) btn_search.getActionView();
        searchView.setQueryHint("Search");
        searchView.setBackgroundColor(getResources().getColor(R.color.colorTrans));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() == 0) {
                    if (mPresenter.getSearchFilter().getSearch().length() != 0) {
                        mPresenter.getSearchFilter().setSearch(newText);
                        mPresenter.getNew();
                    }
                } else {
                    mPresenter.getSearchFilter().setSearch(newText);
                    mPresenter.getNew();
                }
                return true;
            }
        });
    }

    @Override
    public void onReceiveResult(int resultCode, final Bundle resultData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mPresenter.getList() == null) {
                    mPresenter.getNew();
                } else {
                    mPresenter.setEndOfDatabase(false);
                }
            }
        });
    }

    @Override
    public void setNewList(final ArrayList<User> list) {
        postList(list);
        if (progress.getVisibility() != View.GONE && list.size() > 0) {
            progress.setVisibility(View.GONE);
        }
    }

    public void postList(final ArrayList<User> list) {
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                if (mPresenter.isPaging()) {
                    adapterUsers.paging(list);
                    mPresenter.setPaging(false);
                } else {
                    adapterUsers.animateTo(list);
                }
                if (mPresenter.getList().size() == adapterUsers.getItemCount()) {
                    mPresenter.setLoading(false);
                }
            }
        });
    }
}

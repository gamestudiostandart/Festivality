package test.mb.festivality.aplication.userpage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.gson.Gson;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import test.mb.festivality.R;
import test.mb.festivality.utils.models.User;
import test.mb.festivality.utils.views.BlurBuilder;

public class ActivityUserPage extends AppCompatActivity {

    public static final String USER_OBJEKT = "Userobject";
    private double statusTransection;
    private ImageView iv_user;
    private ImageView iv_toolbar_user;
    private AppBarLayout app_bar;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_user_page);

        user = new Gson().fromJson(getIntent().getStringExtra(USER_OBJEKT), User.class);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(user.getCustomFields().getFullName());

        iv_toolbar_user = findViewById(R.id.iv_toolbar_user);
        iv_user = findViewById(R.id.iv_user);
        app_bar = findViewById(R.id.app_bar);

        iv_toolbar_user.setAlpha(0f);
        iv_user.setAlpha(0f);

        initAppBarLayout();
        initBackgraundPhoto(user);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterUserFields adapter = new AdapterUserFields();
        recyclerView.setAdapter(adapter);
        adapter.setList(user.getList());

        FloatingActionButton fab = findViewById(R.id.fab);
        if (!TextUtils.isEmpty(user.getCustomFields().getPhone())) {
            fab.setVisibility(View.VISIBLE);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentmobileCall = new Intent(Intent.ACTION_DIAL);
                intentmobileCall.setData(Uri.parse("tel:" + Uri.encode(String.valueOf(user.getCustomFields().getPhone()))));
                intentmobileCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentmobileCall);
            }
        });
    }

    private void initAppBarLayout() {
        app_bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                double status = 100 + (verticalOffset / (appBarLayout.getTotalScrollRange() / 100));
                if (status < 0) {
                    status = 0;
                }
                if (statusTransection != status) {
                    statusTransection = status;
                    double pixImH = 0.88 * status;
                    int pxUpImH = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, ((int) pixImH), ActivityUserPage.this.getResources().getDisplayMetrics());
                    FrameLayout.LayoutParams lParamsForImageInToolbar = new FrameLayout.LayoutParams(pxUpImH, pxUpImH);
                    lParamsForImageInToolbar.gravity = Gravity.CENTER;
                    iv_toolbar_user.setLayoutParams(lParamsForImageInToolbar);
                }
            }
        });
    }

    private void initBackgraundPhoto(User user) {
        Glide.with(getApplicationContext())
                .load(user.getMedia().get(0).getFiles().getVariations().getOriginal())
                .asBitmap()
                .into(new SimpleTarget<Bitmap>(100, 100) {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                        iv_toolbar_user.setImageBitmap(resource);
                        AlphaAnimation animation1 = new AlphaAnimation(0.0f, 1.0f);
                        animation1.setDuration(300);
                        animation1.setStartOffset(600);
                        iv_toolbar_user.setAlpha(1f);
                        iv_toolbar_user.startAnimation(animation1);

                        Bitmap resultBmp = BlurBuilder.fastblur(resource, 1f, 15);
                        iv_user.setImageBitmap(resultBmp);
                        iv_user.setAlpha(1f);
                        AlphaAnimation animation2 = new AlphaAnimation(0.0f, 1.0f);
                        animation2.setDuration(300);
                        animation2.setStartOffset(300);
                        iv_user.startAnimation(animation2);
                    }
                });
    }
}
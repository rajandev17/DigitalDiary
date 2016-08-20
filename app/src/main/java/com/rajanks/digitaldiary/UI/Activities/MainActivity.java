package com.rajanks.digitaldiary.UI.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.rajanks.digitaldiary.R;
import com.rajanks.digitaldiary.UI.CustomViews.AmazeTextView;
import com.rajanks.digitaldiary.UI.Fragments.Feed.FeedFragment;
import com.rajanks.digitaldiary.UI.Fragments.Gallery.GalleryFragment;
import com.rajanks.digitaldiary.Util.AppBase;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FrameLayout mainFrame;
    private Context context;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        initViews();
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mainFrame = (FrameLayout) findViewById(R.id.main);
        setSupportActionBar(toolbar);
        SpannableString s = new SpannableString("VBHS");
        s.setSpan(new TypefaceSpan("elite.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        setUpNavDrawer(toolbar);
        getSupportFragmentManager().beginTransaction().add(R.id.main,FeedFragment.newInstance(1)).commit();
    }

    private void setUpNavDrawer(Toolbar toolbar) {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setCheckedItem(0);
        navigationView.setNavigationItemSelectedListener(this);
        View header = LayoutInflater.from(context).inflate(R.layout.nav_header_home, navigationView);
        AmazeTextView name = (AmazeTextView) header.findViewById(R.id.student_name);
        AmazeTextView email = (AmazeTextView) header.findViewById(R.id.student_detail);
        CircularImageView studentPic = (CircularImageView) header.findViewById(R.id.student_image);
        name.setText(AppBase.getInstance().getName());
        email.setText(AppBase.getInstance().getDetail());
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_noti : getSupportFragmentManager().beginTransaction().replace(R.id.main,FeedFragment.newInstance(1)).commit(); break;
            case R.id.nav_report :  break;
            case R.id.nav_gallery : getSupportFragmentManager().beginTransaction().replace(R.id.main,new GalleryFragment()).commit(); break;
            case R.id.nav_logout : this.finish();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

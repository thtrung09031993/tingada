package hci201.tingada;

import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TabHomeActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private int default_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_home);

        mViewPager = (ViewPager) findViewById(R.id.container);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);


        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.account));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.chat_tab));

        //Creating tab
        final TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new SettingProfileFragment(), "");
        adapter.addFragment(new FindLoverFragment(), "");
        adapter.addFragment(new MatchingFragment(), "");

        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.setCurrentItem(getIntent().getIntExtra("tab", 1));
    }

}

package com.qinzitravel;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.activity_collector.BaseActivity;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.fragment_container.FragmentContainer;
import com.fragment_container.ViewPagerAdapter;

import static com.activity_collector.ActivityCollector.finishAll;

public class MainActivity extends BaseActivity {

    private FragmentContainer currentFragment;
    private ViewPagerAdapter adapter;
    private AHBottomNavigation bottomNavigation;

    private AHBottomNavigationViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitUi();
    }

    private void InitUi() {
        bottomNavigation = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.view_pager);

        // Create Item
        AHBottomNavigationItem sight = new AHBottomNavigationItem(R.string.navigationSight, R.drawable.ic_navigation_sight, R.color.colorNavigation);
        AHBottomNavigationItem travel = new AHBottomNavigationItem(R.string.navigationTravel, R.drawable.ic_navigation_travel, R.color.colorNavigation);
        AHBottomNavigationItem repast = new AHBottomNavigationItem(R.string.navigationRepast, R.drawable.ic_navigation_repast, R.color.colorNavigation);
        AHBottomNavigationItem hotel = new AHBottomNavigationItem(R.string.navigationHotel, R.drawable.ic_navigation_hotel, R.color.colorNavigation);
        AHBottomNavigationItem user = new AHBottomNavigationItem(R.string.navigationUser, R.drawable.ic_navigation_user, R.color.colorNavigation);

        // Add Item
        bottomNavigation.addItem(sight);
        bottomNavigation.addItem(travel);
        bottomNavigation.addItem(repast);
        bottomNavigation.addItem(hotel);
        bottomNavigation.addItem(user);

        // Customize notification (title, background, typeface)
        bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

        // Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#03A9F4"));

        // Manage titles
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        // Set current item programmatically
        bottomNavigation.setCurrentItem(0);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                if (currentFragment == null) {
                    currentFragment = adapter.getCurrentFragment();
                }

                if (wasSelected) {
                    currentFragment.refresh();
                    return true;
                }

                if (currentFragment != null) {
                    currentFragment.willBeHidden();
                }

                viewPager.setCurrentItem(position, false);

                if (currentFragment == null) {
                    return true;
                }

                currentFragment = adapter.getCurrentFragment();
                currentFragment.willBeDisplayed();

                return true;
            }
        });
        viewPager.setOffscreenPageLimit(4);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        currentFragment = adapter.getCurrentFragment();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
        bottomNavigation.setCurrentItem(0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAll();
    }
}

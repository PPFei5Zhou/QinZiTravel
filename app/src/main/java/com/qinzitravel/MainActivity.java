package com.qinzitravel;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitUi();
    }

    private void InitUi() {
        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

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

        // Manage titles
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
    }
}

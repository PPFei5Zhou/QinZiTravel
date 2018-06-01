package com.fragment_hotel;

import android.content.Intent;
import android.drm.DrmStore;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qinzitravel.R;

public class Collapsing_Hotel_Activity extends AppCompatActivity {

    public static final String HOTEL_NAME = "hotel_name";
    public static final String HOTEL_IMAGE_ID = "hotel_image_id";

    android.support.v7.widget.Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbar;
    ImageView hotelImageView;
    TextView hotelPrice;
    TextView hotelAddress;
    TextView hotelContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_hotel);

        Intent intent = getIntent();
        String hotelName = intent.getStringExtra(HOTEL_NAME);
        int hotelIamgeId = intent.getIntExtra(HOTEL_IMAGE_ID, 0);
        int position = intent.getIntExtra("position", 0);

        toolbar = findViewById(R.id.hotel_toolbar);
        collapsingToolbar = findViewById(R.id.hotel_collapsing_toolbar);
        hotelImageView = findViewById(R.id.hotel_image_view);
        hotelPrice = findViewById(R.id.hotel_price);
        hotelAddress = findViewById(R.id.hotel_address);
        hotelContent = findViewById(R.id.hotel_content);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collapsingToolbar.setTitle(hotelName);
        Glide.with(this).load(hotelIamgeId).into(hotelImageView);
        String hotelPricesText = generateHotelPrice(position);
        String hotelAddressText = generateHotelAddress(position);
        String hotelContentText = generateHotelContent(position);
        hotelPrice.setText(hotelPricesText);
        hotelAddress.setText(hotelAddressText);
        hotelContent.setText(hotelContentText);
    }

    private String generateHotelContent(int position) {
        StringBuilder sightContent = new StringBuilder();
        switch (position) {
            case 0:
                sightContent.append(getString(R.string.hotel_info_1));
                break;
            case 1:
                sightContent.append(getString(R.string.hotel_info_2));
                break;
            case 2:
                sightContent.append(getString(R.string.hotel_info_3));
                break;
            case 3:
                sightContent.append(getString(R.string.hotel_info_4));
                break;
            case 4:
                sightContent.append(getString(R.string.hotel_info_5));
                break;
        }
        return sightContent.toString();
    }

    private String generateHotelPrice(int position) {
        StringBuilder sightContent = new StringBuilder();
        switch (position) {
            case 0:
                sightContent.append(getString(R.string.hotel_price_1));
                break;
            case 1:
                sightContent.append(getString(R.string.hotel_price_2));
                break;
            case 2:
                sightContent.append(getString(R.string.hotel_price_3));
                break;
            case 3:
                sightContent.append(getString(R.string.hotel_price_4));
                break;
            case 4:
                sightContent.append(getString(R.string.hotel_price_5));
                break;
        }
        return sightContent.toString();
    }

    private String generateHotelAddress(int position) {
        StringBuilder sightContent = new StringBuilder();
        switch (position) {
            case 0:
                sightContent.append(getString(R.string.hotel_address_1));
                break;
            case 1:
                sightContent.append(getString(R.string.hotel_address_2));
                break;
            case 2:
                sightContent.append(getString(R.string.hotel_address_3));
                break;
            case 3:
                sightContent.append(getString(R.string.hotel_address_4));
                break;
            case 4:
                sightContent.append(getString(R.string.hotel_address_5));
                break;
        }
        return sightContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}

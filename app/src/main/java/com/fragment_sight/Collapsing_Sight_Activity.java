package com.fragment_sight;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.activity_collector.BaseActivity;
import com.bumptech.glide.Glide;
import com.qinzitravel.MainActivity;
import com.qinzitravel.R;

public class Collapsing_Sight_Activity extends BaseActivity {

    public static final String SIGHT_NAME = "sight_name";
    public static final String SIGHT_IMAGE_ID = "sight_image_id";

    private android.support.v7.widget.Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private ImageView sightImageView;
    private TextView sightPrice;
    private TextView sightAddress;
    private TextView sightContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_sight);

        Intent intent = getIntent();
        String sightName = intent.getStringExtra(SIGHT_NAME);
        int sightImageId = intent.getIntExtra(SIGHT_IMAGE_ID, 0);
        int position = intent.getIntExtra("position", 0);

        toolbar = findViewById(R.id.toolbar);
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        sightImageView = findViewById(R.id.sight_image_view);
        sightPrice = findViewById(R.id.sight_price);
        sightAddress = findViewById(R.id.sight_address);
        sightContent = findViewById(R.id.sight_content);

        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collapsingToolbar.setTitle(sightName);
        Glide.with(this).load(sightImageId).into(sightImageView);
        String sightPricesText = generateSightPrice(position);
        String sightAddressText = generateSightAddress(position);
        String sightContentText = generateSightContent(position);
        sightPrice.setText(sightPricesText);
        sightAddress.setText(sightAddressText);
        sightContent.setText(sightContentText);
    }

    private String generateSightContent(int position) {
        StringBuilder sightContent = new StringBuilder();
        switch (position) {
            case 0:
                sightContent.append(getString(R.string.sight_info_1));
                break;
            case 1:
                sightContent.append(getString(R.string.sight_info_2));
                break;
            case 2:
                sightContent.append(getString(R.string.sight_info_3));
                break;
            case 3:
                sightContent.append(getString(R.string.sight_info_4));
                break;
            case 4:
                sightContent.append(getString(R.string.sight_info_5));
                break;
        }
        return sightContent.toString();
    }

    private String generateSightPrice(int position) {
        StringBuilder sightContent = new StringBuilder();
        switch (position) {
            case 0:
                sightContent.append(getString(R.string.sight_price_1));
                break;
            case 1:
                sightContent.append(getString(R.string.sight_price_2));
                break;
            case 2:
                sightContent.append(getString(R.string.sight_price_3));
                break;
            case 3:
                sightContent.append(getString(R.string.sight_price_4));
                break;
            case 4:
                sightContent.append(getString(R.string.sight_price_5));
                break;
        }
        return sightContent.toString();
    }

    private String generateSightAddress(int position) {
        StringBuilder sightContent = new StringBuilder();
        switch (position) {
            case 0:
                sightContent.append(getString(R.string.sight_address_1));
                break;
            case 1:
                sightContent.append(getString(R.string.sight_address_2));
                break;
            case 2:
                sightContent.append(getString(R.string.sight_address_3));
                break;
            case 3:
                sightContent.append(getString(R.string.sight_address_4));
                break;
            case 4:
                sightContent.append(getString(R.string.sight_address_5));
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

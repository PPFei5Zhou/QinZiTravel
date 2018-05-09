package com.fragment_sight;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.activity_collector.BaseActivity;
import com.bumptech.glide.Glide;
import com.qinzitravel.R;

public class Collapsing_Sight extends BaseActivity {

    public static final String SIGHT_NAME = "sight_name";
    public static final String SIGHT_IMAGE_ID = "sight_image_id";

    private android.support.v7.widget.Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private ImageView sightImageView;
    private TextView sightContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_sight);

        Intent intent = getIntent();
        String sightName = intent.getStringExtra(SIGHT_NAME);
        int sightImageId = intent.getIntExtra(SIGHT_IMAGE_ID, 0);

        toolbar = findViewById(R.id.toolbar);
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        sightImageView = findViewById(R.id.sight_image_view);
        sightContent = findViewById(R.id.sight_content);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(sightName);
        Glide.with(this).load(sightImageId).into(sightImageView);
        String sightContentText = generateSightContent(sightName);
        sightContent.setText(sightContentText);
    }

    private String generateSightContent(String sightName) {
        StringBuilder sightContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            sightContent.append(sightName);
        }
        return sightContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

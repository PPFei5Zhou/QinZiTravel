package com.collapsingToolbar;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qinzitravel.R;

public class CollapsingToolbar extends com.activity_collector.BaseActivity {

    public static final String ITEM_NAME = "item_name";

    public static final String ITEM_IMAGE_ID = "item_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);
        Intent intent = getIntent();
        String itemName = intent.getStringExtra(ITEM_NAME);
        int itemImageId = intent.getIntExtra(ITEM_IMAGE_ID, 0);
        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ImageView itemImageView = findViewById(R.id.item_image_view);
        TextView itemContentText = findViewById(R.id.item_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(itemName);
        Glide.with(this).load(itemImageId).into(itemImageView);
        String itemContent = generateItemContent(itemName);
        itemContentText.setText(itemContent);
    }

    private String generateItemContent(String itemName) {
        StringBuilder itemContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            itemContent.append(itemName);
        }
        return itemContent.toString();
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

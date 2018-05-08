package com.fragment_container;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Entity.TestItem;
import com.bumptech.glide.Glide;
import com.collapsingToolbar.CollapsingToolbar;
import com.qinzitravel.R;

import java.util.ArrayList;
import java.util.List;

public class SightFragmentAdapter extends RecyclerView.Adapter<SightFragmentAdapter.ViewHolder> {

    private Context mContext;

    private List<TestItem> mTestItem;

    public SightFragmentAdapter(List<TestItem> itemList) {
        mTestItem = itemList;
    }

    @Override
    public SightFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.test_item, parent, false);
//        final ViewHolder holder = new ViewHolder(view);
//        holder.itemName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                TestItem testItem = mTestItem.get(position);
//                Intent intent = new Intent(mContext, CollapsingToolbar.class);
//                intent.putExtra(CollapsingToolbar.ITEM_NAME, testItem.getName());
//                intent.putExtra(CollapsingToolbar.ITEM_IMAGE_ID, testItem.getImageId());
//                mContext.startActivity(intent);
//            }
//        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TestItem testItem = mTestItem.get(position);
        holder.itemName.setText(testItem.getName());
        Glide.with(mContext).load(testItem.getImageId()).into(holder.itemImage);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView itemImage;
        TextView itemName;

        ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            itemImage = view.findViewById(R.id.item_image);
            itemName = view.findViewById(R.id.item_name);
        }
    }

    @Override
    public int getItemCount() {
        return mTestItem.size();
    }
}

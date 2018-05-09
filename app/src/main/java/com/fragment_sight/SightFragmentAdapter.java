package com.fragment_sight;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Entity.SightTestItem;
import com.bumptech.glide.Glide;
import com.qinzitravel.R;

import java.util.List;

public class SightFragmentAdapter extends RecyclerView.Adapter<SightFragmentAdapter.ViewHolder> {

    private static final String TAG = "SightFragmentAdapter";

    private Context mContext;

    private List<SightTestItem> mSightTestItem;

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

    public SightFragmentAdapter(List<SightTestItem> itemList) {
        mSightTestItem = itemList;
    }

    @Override
    public SightFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.test_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int position = holder.getAdapterPosition();
                    SightTestItem sightTestItem = mSightTestItem.get(position);
                    Intent intent = new Intent(mContext, Collapsing_Sight.class);
                    intent.putExtra(Collapsing_Sight.SIGHT_NAME, sightTestItem.getName());
                    intent.putExtra(Collapsing_Sight.SIGHT_IMAGE_ID, sightTestItem.getImageId());
                    mContext.startActivity(intent);
                } catch (ArrayIndexOutOfBoundsException e) {
                    Log.d(TAG, "ArrayIndexOutOfBoundsException: position == -1");
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SightTestItem sightTestItem = mSightTestItem.get(position);
        holder.itemName.setText(sightTestItem.getName());
        Glide.with(mContext).load(sightTestItem.getImageId()).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return mSightTestItem.size();
    }
}

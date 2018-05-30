package com.fragment_sight;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Entity.TestItem;
import com.bumptech.glide.Glide;
import com.qinzitravel.R;

import java.util.List;

public class SightFragmentAdapter extends RecyclerView.Adapter<SightFragmentAdapter.ViewHolder> {

    private static final String TAG = "SightFragmentAdapter";

    private Context mContext;

    private List<TestItem> mTestItem;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener = onItemClickListener;
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

    public SightFragmentAdapter(List<TestItem> itemList) {
        mTestItem = itemList;
    }

    @Override
    public SightFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.test_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        TestItem testItem = mTestItem.get(position);
        holder.itemName.setText(testItem.getName());
        Glide.with(mContext).load(testItem.getImageId()).into(holder.itemImage);

        if (mOnItemClickListener != null) {
            holder.cardView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mTestItem.size();
    }
}

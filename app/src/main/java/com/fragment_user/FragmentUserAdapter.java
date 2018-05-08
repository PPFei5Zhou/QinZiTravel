package com.fragment_user;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinzitravel.R;

import java.util.List;

/**
 * Created by zhou on 18-5-3.
 */

public class FragmentUserAdapter extends RecyclerView.Adapter<FragmentUserAdapter.ViewHolder> {

    private Context mContext;

    private List<FragmentUserContainer> mUserList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView user_image;
        TextView user_text;

        public ViewHolder(View view) {
            super(view);
            user_image = view.findViewById(R.id.user_image);
            user_text = view.findViewById(R.id.user_text);
        }
    }

    public FragmentUserAdapter(List<FragmentUserContainer> userList) {
         mUserList = userList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FragmentUserContainer fragmentUserContainer = mUserList.get(position);
        holder.user_image.setImageResource(fragmentUserContainer.getImageId());
        holder.user_text.setText(fragmentUserContainer.getUser_text());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }
}

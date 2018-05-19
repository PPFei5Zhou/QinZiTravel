package com.fragment_user;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Entity.UserListItem;
import com.qinzitravel.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by zhou on 18-5-3.
 */

public class UserFragmentAdapter extends RecyclerView.Adapter<UserFragmentAdapter.ViewHolder> {

    private static final String TAG = "UserFragmentAdapter";

    private Context mContext;

    private View view;

    private List<UserListItem> mUserList;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener = onItemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        ImageView user_image;
        TextView user_text;

        public ViewHolder(View view) {
            super(view);
            linearLayout = (LinearLayout) view;
            user_image = view.findViewById(R.id.user_image);
            user_text = view.findViewById(R.id.user_text);
        }
    }

    public UserFragmentAdapter(List<UserListItem> userList) {
         mUserList = userList;
    }


    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        view = LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        UserListItem userListItem = mUserList.get(position);
        holder.user_image.setImageResource(userListItem.getImageId());
        holder.user_text.setText(userListItem.getUser_text());

        if (mOnItemClickListener != null) {
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }
}
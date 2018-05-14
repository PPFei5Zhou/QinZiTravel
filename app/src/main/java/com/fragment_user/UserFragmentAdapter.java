package com.fragment_user;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Entity.UserListItem;
import com.qinzitravel.R;

import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by zhou on 18-5-3.
 */

public class UserFragmentAdapter extends RecyclerView.Adapter<UserFragmentAdapter.ViewHolder> {

    private static final String TAG = "UserFragmentAdapter";

    private Context mContext;

    private List<UserListItem> mUserList;

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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                UserListItem userListItem = mUserList.get(position);
                Log.d(TAG, "onClick: " + userListItem.getUser_text());
                switch (userListItem.getUser_text()) {
                    case "Account":
                        Log.d(TAG, "switch " + userListItem.getUser_text());
                        Intent intent = new Intent(mContext, LoginActivity.class);
                        mContext.startActivity(intent);
                        break;
                    case "Info":
                        Log.d(TAG, "switch " + userListItem.getUser_text());
                        break;
                    case "Order":
                        Log.d(TAG, "switch " + userListItem.getUser_text());
                        break;
                    case "Setting":
                        Log.d(TAG, "switch " + userListItem.getUser_text());
                        break;
                    case "Exit":
                        Log.d(TAG, "switch " + userListItem.getUser_text());
                        SharedPreferences.Editor editor = mContext.getSharedPreferences("loginStatus", Context.MODE_PRIVATE).edit();
                        editor.putInt("loginStatus", 0);
                        editor.apply();

                        // test log
                        SharedPreferences pref = mContext.getSharedPreferences("loginStatus", Context.MODE_PRIVATE);
                        int loginStatus = pref.getInt("loginStatus", 0);
                        Log.d(TAG, "======================================>login status is " + loginStatus);

                        // update ui

                        break;
                    default:
                        break;
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserListItem userListItem = mUserList.get(position);
        holder.user_image.setImageResource(userListItem.getImageId());
        holder.user_text.setText(userListItem.getUser_text());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }
}
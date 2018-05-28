package com.fragment_user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.Entity.User;
import com.qinzitravel.R;

import org.litepal.crud.DataSupport;

import java.util.List;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView user_name = findViewById(R.id.user_name);
        TextView user_phone = findViewById(R.id.user_phone);
        TextView user_email = findViewById(R.id.user_email);
        TextView user_address = findViewById(R.id.user_address);

        Intent intent = getIntent();
        String phone = intent.getStringExtra("userPhone");

        List<User> users = DataSupport.select("username", "email", "useraddress")
                .where("phone = ?", phone)
                .find(User.class);
        String username = users.get(0).getUsername();
        String email = users.get(0).getEmail();
        String address = users.get(0).getUseraddress();

        user_name.setText(username);
        user_phone.setText(phone);
        user_email.setText(email);
        user_address.setText(address);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }
}

package com.fragment_container;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.Entity.SightTestItem;
import com.fragment_sight.SightFragmentAdapter;
import com.fragment_user.UserFragmentAdapter;
import com.Entity.UserListItem;
import com.qinzitravel.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentContainer extends Fragment {

    private static final String TAG = "FragmentContainer";

    private FrameLayout fragmentContainer;
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;

    private UserFragmentAdapter userAdapter;
    List<UserListItem> userListItemList = new ArrayList<>();
    private UserListItem[] users = {new UserListItem("用户信息", R.drawable.ic_user_info),
            new UserListItem("订单", R.drawable.ic_user_order),
            new UserListItem("设置", R.drawable.ic_user_setting),
            new UserListItem("退出", R.drawable.ic_user_exit)};

    private List<SightTestItem> sightTestItemList = new ArrayList<>();
    private SightFragmentAdapter sightAdapter;
    private SightTestItem[] items = {new SightTestItem("test1", R.drawable.test1),
            new SightTestItem("test2", R.drawable.test2),
            new SightTestItem("test3", R.drawable.test3),
            new SightTestItem("test4", R.drawable.test4),
            new SightTestItem("test5", R.drawable.test5)};

    public static FragmentContainer newInstance(int index) {
        FragmentContainer fragmentContainer = new FragmentContainer();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragmentContainer.setArguments(b);
        return fragmentContainer;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    /**
     * load selected navigation item content
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        if (getArguments().getInt("index", 0) == 0) {
            View view = inflater.inflate(R.layout.fragment_sight, container, false);
            initSight(view);
            return view;
        } else if (getArguments().getInt("index", 1) == 1) {
            View view = inflater.inflate(R.layout.fragment_travel, container, false);
            initTravel(view);
            return view;
        } else if (getArguments().getInt("index", 2) == 2) {
            View view = inflater.inflate(R.layout.fragment_repast, container, false);
            initRepast(view);
            return view;
        } else if (getArguments().getInt("index", 3) == 3) {
            View view = inflater.inflate(R.layout.fragment_hotel, container, false);
            initHotel(view);
            return view;
        } else {
            View view = inflater.inflate(R.layout.fragment_user, container, false);
            initUser(view);
            return view;
        }
    }

    private void initSight(View view) {

        sightTestItemList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(items.length);
            sightTestItemList.add(items[index]);
        }

        fragmentContainer = view.findViewById(R.id.fragment_sight);
        recyclerView = view.findViewById(R.id.fragment_sight_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        sightAdapter = new SightFragmentAdapter(sightTestItemList);
        recyclerView.setAdapter(sightAdapter);
    }

    private void initTravel(View view) {
        fragmentContainer = view.findViewById(R.id.fragment_travel);
    }

    private void initRepast(View view) {
        fragmentContainer = view.findViewById(R.id.fragment_repast);
    }

    private void initHotel(View view) {
        fragmentContainer = view.findViewById(R.id.fragment_hotel);
    }

    private void initUser(View view) {
        initUserList();

        fragmentContainer = view.findViewById(R.id.fragment_user);
        recyclerView = view.findViewById(R.id.fragment_user_recycler_view);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        userAdapter = new UserFragmentAdapter(userListItemList);
        recyclerView.setAdapter(userAdapter);
    }

    /**
     * Refresh
     */
    public void refresh() {
        if (getArguments().getInt("index", 0) > 0 && recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    /**
     * Called when a fragment will be displayed
     */
    public void willBeDisplayed() {
        // Do what you want here, for example animate the content
        if (fragmentContainer != null) {
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            fragmentContainer.startAnimation(fadeIn);
        }
    }

    /**
     * Called when a fragment will be hidden
     */
    public void willBeHidden() {
        if (fragmentContainer != null) {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
            fragmentContainer.startAnimation(fadeOut);
        }
    }

    public boolean isLogin() {
        /**
         * check user login status
         * @return true is login
         */
        SharedPreferences pref = getActivity().getSharedPreferences("loginStatus", Context.MODE_PRIVATE);
        int loginStatus = pref.getInt("loginStatus", 0);
        Log.d(TAG, "======================================>login status is " + loginStatus);
        if (loginStatus == 1) {
            return true;
        }
        return false;
    }

    private void initUserList() {
        if (isLogin()) {
            userListItemList.add(users[0]);
            userListItemList.add(users[1]);
            userListItemList.add(users[2]);
            userListItemList.add(users[3]);
        } else {
            userListItemList.add(users[4]);
            userListItemList.add(users[2]);
        }
    }
}

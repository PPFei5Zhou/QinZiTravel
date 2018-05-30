package com.fragment_container;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.Entity.TestItem;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.SupportMapFragment;
import com.fragment_sight.Collapsing_Sight_Activity;
import com.fragment_sight.SightFragmentAdapter;
import com.fragment_user.LoginActivity;
import com.fragment_user.UserFragmentAdapter;
import com.Entity.UserListItem;
import com.fragment_user.UserInfoActivity;
import com.qinzitravel.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentContainer extends Fragment {

    private static final String TAG = "FragmentContainer";

    private FrameLayout fragmentContainer;
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private Intent intent;

    private UserFragmentAdapter userAdapter;
    List<UserListItem> userListItemList = new ArrayList<>();

    private List<TestItem> testItemList = new ArrayList<>();
    private SightFragmentAdapter sightAdapter;
    private TestItem[] items = {new TestItem("南宁万达乐园", R.drawable.sight_1),
            new TestItem("卡乐星球", R.drawable.sight_2),
            new TestItem("欢乐城堡儿童乐园", R.drawable.sight_3),
            new TestItem("马尔代夫水上乐园", R.drawable.sight_4),
            new TestItem("积木创意乐园", R.drawable.sight_5)};

    MapView mMapView;
    AMap mAmap;

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
            Log.d(TAG, "==========================>onCreateView: sight");
            View view = inflater.inflate(R.layout.fragment_sight, container, false);
            initSight(view);
            return view;
        } else if (getArguments().getInt("index", 1) == 1) {
            Log.d(TAG, "==========================>onCreateView: travel");
            View view = inflater.inflate(R.layout.fragment_travel, container, false);
            mMapView = view.findViewById(R.id.map);
            mMapView.onCreate(savedInstanceState);
            FragmentManager fragmentManager = getChildFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            try {
                MapsInitializer.initialize(getContext());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            SupportMapFragment supportMapFragment = new SupportMapFragment();
            transaction.replace(R.id.map, supportMapFragment);
            transaction.commit();
            mAmap = supportMapFragment.getMap();

            return view;
        } else if (getArguments().getInt("index", 2) == 2) {
            Log.d(TAG, "==========================>onCreateView: hotel");
            View view = inflater.inflate(R.layout.fragment_repast, container, false);
            initRepast(view);
            return view;
        } else if (getArguments().getInt("index", 3) == 3) {
            Log.d(TAG, "==========================>onCreateView: repast");
            View view = inflater.inflate(R.layout.fragment_hotel, container, false);
            initHotel(view);
            return view;
        } else {
            Log.d(TAG, "==========================>onCreateView: user");
            View view = inflater.inflate(R.layout.fragment_user, container, false);
            initUser(view);
            return view;
        }
    }

    private void initSight(View view) {

        testItemList.clear();
        for (int i = 0; i < items.length; i++) {
            testItemList.add(items[i]);
        }

        fragmentContainer = view.findViewById(R.id.fragment_sight);
        recyclerView = view.findViewById(R.id.fragment_sight_recycler_view);

        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        sightAdapter = new SightFragmentAdapter(testItemList);
        recyclerView.setAdapter(sightAdapter);
        sightAdapter.setOnItemClickListener(new SightFragmentAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "you click " + position, Toast.LENGTH_SHORT).show();
                intent = new Intent(getActivity(), Collapsing_Sight_Activity.class);
                intent.putExtra(Collapsing_Sight_Activity.SIGHT_NAME, testItemList.get(position).getName());
                intent.putExtra(Collapsing_Sight_Activity.SIGHT_IMAGE_ID, testItemList.get(position).getImageId());
                intent.putExtra("position", position);
                getActivity().startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    private void initRepast(View view) {
    }

    private void initHotel(View view) {
    }

    private void initUser(View view) {
        initUserList();

        fragmentContainer = view.findViewById(R.id.fragment_user);
        recyclerView = view.findViewById(R.id.fragment_user_recycler_view);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        userAdapter = new UserFragmentAdapter(userListItemList);
        recyclerView.setAdapter(userAdapter);

        userAdapter.setOnItemClickListener(new UserFragmentAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0:
                        intent = getActivity().getIntent();
                        String userPhone = intent.getStringExtra("loginData");
                        Toast.makeText(getContext(), "logingData is: " + userPhone, Toast.LENGTH_SHORT).show();
                        intent = new Intent(getActivity(), UserInfoActivity.class);
                        getActivity().overridePendingTransition(0, 0);
                        intent.putExtra("userPhone", userPhone);
                        getActivity().startActivity(intent);
                        break;
                    case 3:
                        Toast.makeText(getActivity(), R.string.login_out, Toast.LENGTH_SHORT).show();

                        intent = new Intent(getActivity(), LoginActivity.class);
                        getActivity().startActivity(intent);
                        getActivity().overridePendingTransition(0, 0);
                        break;
                }
            }
        });
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
//        if (fragmentContainer != null) {
//            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
//            fragmentContainer.startAnimation(fadeIn);
//        }
    }

    /**
     * Called when a fragment will be hidden
     */
    public void willBeHidden() {
//        if (fragmentContainer != null) {
//            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
//            fragmentContainer.startAnimation(fadeOut);
//        }
    }

    public boolean isLogin() {
        /**
         * check user login status
         * @return true is login
         */
        intent = getActivity().getIntent();
        int loginStatus = intent.getIntExtra("loginStatus", 0);
        if (loginStatus == 1) {
            return true;
        }
        return false;
    }

    private void initUserList() {
        String info = getActivity().getString(R.string.user_info);
        String order = getActivity().getString(R.string.user_order);
        String setting = getActivity().getString(R.string.user_setting);
        String exit = getActivity().getString(R.string.user_exit);
        UserListItem[] users = {
                new UserListItem(info, R.drawable.ic_user_info),
                new UserListItem(order, R.drawable.ic_user_order),
                new UserListItem(setting, R.drawable.ic_user_setting),
                new UserListItem(exit, R.drawable.ic_user_exit)};

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

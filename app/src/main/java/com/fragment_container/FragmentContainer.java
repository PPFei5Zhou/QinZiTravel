package com.fragment_container;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.Entity.SightTestItem;
import com.fragment_sight.SightFragmentAdapter;
import com.fragment_user.FragmentUserAdapter;
import com.fragment_user.FragmentUserContainer;
import com.qinzitravel.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentContainer extends Fragment {
    private FrameLayout fragmentContainer;
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;

    private List<SightTestItem> sightTestItemList = new ArrayList<>();
    private SightTestItem[] items = {new SightTestItem("test1", R.drawable.test1),
            new SightTestItem("test2", R.drawable.test2),
            new SightTestItem("test3", R.drawable.test3),
            new SightTestItem("test4", R.drawable.test4),
            new SightTestItem("test5", R.drawable.test5)};
    private SightFragmentAdapter sightAdapter;

    public static FragmentContainer newInstance(int index) {
        FragmentContainer fragmentContainer = new FragmentContainer();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragmentContainer.setArguments(b);
        return fragmentContainer;
    }

    @Nullable
    @Override
    /**
     * load selected navigation item content
     */
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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

    private void initUser(View view) {
        FragmentUserContainer[] users = {new FragmentUserContainer("user info", R.drawable.ic_user_info),
                new FragmentUserContainer("order", R.drawable.ic_user_order),
                new FragmentUserContainer("setting", R.drawable.ic_user_setting),
                new FragmentUserContainer("exit", R.drawable.ic_user_exit)};

        List<FragmentUserContainer> fragmentUserContainerList = new ArrayList<>();

        FragmentUserAdapter adapter = new FragmentUserAdapter(fragmentUserContainerList);

        fragmentUserContainerList.add(users[0]);
        fragmentUserContainerList.add(users[1]);
        fragmentUserContainerList.add(users[2]);
        fragmentUserContainerList.add(users[3]);

        fragmentContainer = view.findViewById(R.id.fragment_user);
        recyclerView = view.findViewById(R.id.fragment_user_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initHotel(View view) {

    }

    private void initRepast(View view) {

    }

    private void initTravel(View view) {

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
}

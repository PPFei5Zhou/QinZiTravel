package com.fragment_container;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.fragment_container.FragmentContainer;

import java.util.ArrayList;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<FragmentContainer> fragments = new ArrayList<>();
    private FragmentContainer currentFragment;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments.clear();
        fragments.add(FragmentContainer.newInstance(0));
        fragments.add(FragmentContainer.newInstance(1));
        fragments.add(FragmentContainer.newInstance(2));
        fragments.add(FragmentContainer.newInstance(3));
        fragments.add(FragmentContainer.newInstance(4));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((FragmentContainer) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    /**
     * Get the current fragment
     */
    public FragmentContainer getCurrentFragment() {
        return currentFragment;
    }
}

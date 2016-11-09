package com.dimas.gastrointenistal.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dimas.gastrointenistal.views.fragments.BantuanFragment;

/**
 * Created by rama on 11/9/16.
 */

public class BantuanItemAdapter extends FragmentStatePagerAdapter {
    public BantuanItemAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return BantuanFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 6;
    }
}

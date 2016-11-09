package com.hardy.pakarapel.views.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;

import com.hardy.pakarapel.R;
import com.hardy.pakarapel.views.fragments.BantuanFragment;

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

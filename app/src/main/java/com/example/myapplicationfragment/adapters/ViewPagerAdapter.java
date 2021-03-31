package com.example.myapplicationfragment.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplicationfragment.ui.ChangeFragment;
import com.example.myapplicationfragment.ui.ChildFragment;
import com.example.myapplicationfragment.ui.TextFragment;

public class ViewPagerAdapter  extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TextFragment();
            case 1:
                return new ChangeFragment();
            case 2:
                return new ChildFragment();

            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 3;
    }
}

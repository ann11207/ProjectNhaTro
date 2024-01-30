package com.example.projectnhatro;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.projectnhatro.fragments.AccountFragment;
import com.example.projectnhatro.fragments.HomeFragment;
import com.example.projectnhatro.fragments.SearchFragment;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull MainActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new SearchFragment();
            case 1:
                return  new HomeFragment();
            case 2:
                return new AccountFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

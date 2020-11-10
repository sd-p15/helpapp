package com.haroonstudios.mini.nagraj_dzwiek.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.haroonstudios.mini.nagraj_dzwiek.Fragments.FileViewerFragment;
import com.haroonstudios.mini.nagraj_dzwiek.Fragments.RecordFragment;

public class MyTabAdapter extends FragmentPagerAdapter
{


    //tablica nagrywania konstruktor
    String[] titles = {"Record","Saved Recording"};

    public MyTabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public MyTabAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }


    @NonNull
    @Override
    public Fragment getItem(int i) {
        //przelacznik
        switch (i)
        {
            case 0:
                return new RecordFragment();
            case 1:
                return new FileViewerFragment();



        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }


    //metod ktora popiera tytul strony
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

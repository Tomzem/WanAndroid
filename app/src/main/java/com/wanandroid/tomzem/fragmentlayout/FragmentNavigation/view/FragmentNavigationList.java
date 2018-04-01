package com.wanandroid.tomzem.fragmentlayout.FragmentNavigation.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wanandroid.tomzem.R;

/**
 * Created by Tomzem on 2018/4/1.
 */

@SuppressLint("ValidFragment")
public class FragmentNavigationList extends Fragment {
    private String mTitle;

    public static FragmentNavigationList getInstance(String title) {
        FragmentNavigationList sf = new FragmentNavigationList();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_simple_card, null);
        TextView card_title_tv = (TextView) v.findViewById(R.id.card_title_tv);
        card_title_tv.setText(mTitle);

        return v;
    }
}
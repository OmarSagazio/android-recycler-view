package com.mauro.myrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mauro on 26/03/2017
 */
public class CategoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        getChildFragmentManager()
            .beginTransaction()
            .add(R.id.head_category_container, new HeadCategoryFragment())
            .commit();

        getChildFragmentManager()
            .beginTransaction()
            .add(R.id.category_container, new SubCategoryFragment())
            .commit();

        return view;
    }
}

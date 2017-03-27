package com.mauro.myrecyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mauro on 27/03/2017
 */
public class HeadCategoryFragment extends Fragment {

    private RecyclerView mHeadCategoryRecyclerView;
    private HeadCategoryAdapter mHeadCategoryAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_head, container, false);

        mHeadCategoryRecyclerView = (RecyclerView) view.findViewById(R.id.head_category_recycler_view);
        mHeadCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        CategoryLab categoryLab = CategoryLab.get(getActivity());
        List<Category> categories = categoryLab.getThreeCategories();

        mHeadCategoryAdapter = new HeadCategoryAdapter(categories);
        mHeadCategoryRecyclerView.setAdapter(mHeadCategoryAdapter);

        return view;
    }


    // -------------------------------------
    //              ViewHolder
    // -------------------------------------
    private class HeadCategoryHolder extends RecyclerView.ViewHolder {

        public TextView mTitleTextView;

        public HeadCategoryHolder(View itemView) {
            super(itemView);

            mTitleTextView = (TextView) itemView;
        }
    }


    // -------------------------------------
    //              Adapter
    // -------------------------------------
    private class HeadCategoryAdapter extends RecyclerView.Adapter<HeadCategoryHolder> {

        private List<Category> mCategories;

        public HeadCategoryAdapter(List<Category> categories) {
            mCategories = categories;
        }

        @Override
        public HeadCategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new HeadCategoryHolder(view);
        }

        @Override
        public void onBindViewHolder(HeadCategoryHolder holder, int position) {
            Category category = mCategories.get(position);
            holder.mTitleTextView.setText(category.getName());
        }

        @Override
        public int getItemCount() {
            return mCategories.size();
        }
    }

}

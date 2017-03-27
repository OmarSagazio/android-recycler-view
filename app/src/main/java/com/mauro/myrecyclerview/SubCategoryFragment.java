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
 * Created by Mauro on 26/03/2017
 */
public class SubCategoryFragment extends Fragment {

    private RecyclerView mSubCategoryRecyclerView;
    private SubCategoryAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subcategory_list, container, false);

        mSubCategoryRecyclerView = (RecyclerView) view.findViewById(R.id.subcategory_recycler_view);
        mSubCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CategoryLab categoryLab = CategoryLab.get(getActivity());
        List<Category> categories = categoryLab.getCategories();

        mAdapter = new SubCategoryAdapter(categories);
        mSubCategoryRecyclerView.setAdapter(mAdapter);

        return view;
    }

    // -------------------------------------
    //              ViewHolder
    // -------------------------------------
    private class SubCategoryHolder extends RecyclerView.ViewHolder {

        public TextView mTitleTextView;

        public SubCategoryHolder(View itemView) {
            super(itemView);

            mTitleTextView = (TextView) itemView;
        }
    }


    // -------------------------------------
    //              Adapter
    // -------------------------------------
    private class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryHolder> {

        private List<Category> mCategories;

        public SubCategoryAdapter(List<Category> categories) {
            mCategories = categories;
        }

        @Override
        public SubCategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new SubCategoryHolder(view);
        }

        @Override
        public void onBindViewHolder(SubCategoryHolder holder, int position) {
            Category category = mCategories.get(position);
            holder.mTitleTextView.setText(category.getName());
        }

        @Override
        public int getItemCount() {
            return mCategories.size();
        }
    }


}

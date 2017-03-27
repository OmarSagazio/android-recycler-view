package com.mauro.myrecyclerview;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mauro on 26/03/2017
 */
public class CategoryLab {

    private static CategoryLab sCategoryLab;
    private List<Category> mCategories;
    private List<Category> mThreeCategories;

    private CategoryLab(Context context) {

        mCategories = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Category category = new Category("Cat #" + i);
            mCategories.add(category);
        }

        mThreeCategories = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Category category = new Category("Head Category #" + i);
            mThreeCategories.add(category);
        }

    }


    public static CategoryLab get(Context context) {
        if (sCategoryLab == null) {
            sCategoryLab = new CategoryLab(context);
        }
        return sCategoryLab;
    }

    public List<Category> getCategories() {
        return mCategories;
    }
    public List<Category> getThreeCategories() {
        return mThreeCategories;
    }
}

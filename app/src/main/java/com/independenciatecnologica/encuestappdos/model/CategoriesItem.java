package com.independenciatecnologica.encuestappdos.model;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.independenciatecnologica.encuestappdos.R;
import com.independenciatecnologica.encuestappdos.adapter.CategoriesAdapter;

import static com.independenciatecnologica.encuestappdos.util.Constanst.TAG;

public class CategoriesItem {
    private String name;
    private String categories;

    public String getCategories() {
        categories = name;
        Log.d(TAG,"categorie:"+categories);
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public CategoriesItem(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @BindingAdapter({"categories"})
    public static void loadImage(ImageView view, String categories){
        Log.d(TAG,"load image..");
        int image = 0;

        switch (categories){
            case "money":
                image = R.drawable.ic_money;
                break;
            case "sport":
                image = R.drawable.ic_sport;
                break;
            case "music":
                image = R.drawable.ic_music;
                break;
        }

        Glide.with(view.getContext())
                .load(image)
                .apply(RequestOptions.circleCropTransform())
                .into(view);
    }
}

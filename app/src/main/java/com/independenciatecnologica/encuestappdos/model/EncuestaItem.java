package com.independenciatecnologica.encuestappdos.model;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.independenciatecnologica.encuestappdos.R;

import static com.independenciatecnologica.encuestappdos.util.Constanst.TAG;

public class EncuestaItem {
    private String id;
    private String name;
    private String lastName;
    private String categories;

    public EncuestaItem(int id , String name ,String lastName,String categories){
        this.id = String.valueOf(id);
        this.name = name ;
        this.lastName = lastName;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @BindingAdapter({"categories"})
    public static void loadImage(ImageView view,String categories){
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

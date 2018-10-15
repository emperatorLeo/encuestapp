package com.independenciatecnologica.encuestappdos.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.independenciatecnologica.encuestappdos.R;
import com.independenciatecnologica.encuestappdos.databinding.SpinnerItemCategoriesBinding;
import com.independenciatecnologica.encuestappdos.model.CategoriesItem;
import static com.independenciatecnologica.encuestappdos.util.Constanst.TAG;
import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends ArrayAdapter{
    private int[] images;
    private String[] categoriesName;
    private Context context;
    private LayoutInflater inflater;
    private List<CategoriesItem> items;

    public CategoriesAdapter(Context appContext,ArrayList<CategoriesItem> list){
        super(appContext,0,list);
        context=appContext;
        items = list;
       /* this.context = appContext;
        this.items = mItems;
        inflater = (LayoutInflater.from(appContext));*/
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){

            inflater = LayoutInflater.from(parent.getContext());
            SpinnerItemCategoriesBinding binding = DataBindingUtil.inflate(inflater,
                    R.layout.spinner_item_categories,parent,false);
            binding.setCategories(items.get(position));
            binding.executePendingBindings();
            return binding.getRoot();

        }else {
            Log.d(TAG, "in categories adapter: convertview is not null");
            return super.getView(position, convertView, parent);
        }
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        SpinnerItemCategoriesBinding binding;
        if(convertView==null){
             inflater = LayoutInflater.from(parent.getContext());
             binding = DataBindingUtil.inflate(inflater,
                    R.layout.spinner_item_categories,parent,false);
            binding.setCategories(items.get(position));
            binding.executePendingBindings();
            convertView = binding.getRoot();
            return convertView;
        }

        return convertView;
    }
}

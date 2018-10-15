package com.independenciatecnologica.encuestappdos.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.independenciatecnologica.encuestappdos.R;
import com.independenciatecnologica.encuestappdos.adapter.CategoriesAdapter;
import com.independenciatecnologica.encuestappdos.databinding.FragmentAddEncuestaBinding;
import com.independenciatecnologica.encuestappdos.model.CategoriesItem;

import java.util.ArrayList;
import java.util.List;

public class AddFragment extends Fragment  {
    private LayoutInflater inflater;
    private CategoriesAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
       return initBinding();
        }

     private View initBinding(){
         adapter = new CategoriesAdapter(getActivity().getApplicationContext(),feed());
         FragmentAddEncuestaBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_encuesta,null,false);
         binding.spinner.setAdapter(adapter);
         binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 Log.d("Leo","position"+position);
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });
         View view = binding.getRoot();
         return view;

     }

     private ArrayList<CategoriesItem> feed(){
        ArrayList<CategoriesItem>lista = new ArrayList<>();
        lista.add(new CategoriesItem("money"));
        lista.add(new CategoriesItem("sport"));
        lista.add(new CategoriesItem("music"));
        return lista;
     }
}

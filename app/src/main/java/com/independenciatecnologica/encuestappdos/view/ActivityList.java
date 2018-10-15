package com.independenciatecnologica.encuestappdos.view;

import android.databinding.DataBindingUtil;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.independenciatecnologica.encuestappdos.adapter.EncuestaAdapter;
import com.independenciatecnologica.encuestappdos.model.EncuestaItem;
import com.independenciatecnologica.encuestappdos.R;
import com.independenciatecnologica.encuestappdos.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;
import static com.independenciatecnologica.encuestappdos.util.Constanst.TAG;

public class ActivityList extends AppCompatActivity {
    ActivityListBinding binding;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();

        binding.poll.setOnClickListener((View.OnClickListener) v -> fragmentGo());
    }

    private void initDataBinding(){
        binding = DataBindingUtil.setContentView(this,R.layout.activity_list);

        binding.rvPollList.setAdapter(new EncuestaAdapter(feedingList()));
        binding.rvPollList.setLayoutManager(new LinearLayoutManager(this));
        binding.setActivity(new ActivityList());
        manager = binding.getActivity().getSupportFragmentManager();
        emptyState(feedingList().size());
        if(manager==null){
            Log.d(TAG,"manage is null");
            manager = this.getSupportFragmentManager();
        }else Log.d(TAG,"manage is not null");

    }

    private List<EncuestaItem> feedingList(){
        List<EncuestaItem> lista = new ArrayList<>();
        lista.add(new EncuestaItem(00,"leo","santana","sport"));
        lista.add(new EncuestaItem(01,"deli","santana","money"));
        lista.add(new EncuestaItem(02,"jessi","santana","music"));

        return lista;
        }

    private void emptyState(int listSize) {
        if (listSize != 0) {
            binding.tvPlaceHolder.setVisibility(View.GONE);
        }
    }

    private void fragmentGo(){
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        /**proobing replace instead add */
        transaction.replace(R.id.list_content,new AddFragment()).commit();
    }

    public void goToAdd(){
        Log.d(TAG,"inside of goToAdd");
        if(manager==null){
            Log.d(TAG,"manager is null");
        }else Log.d(TAG,"manager is null");

       // FragmentManager fragmentManager = getSupportFragmentManager();
        manager = binding.getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new AddFragment();
        transaction.add(R.id.list_content,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        /*String mesajes = manager == null ? "manager is null" : "manager is not null";
        Log.d(TAG,mesajes);
        manager = getSupportFragmentManager();

        if(manager == null)Log.d(TAG,"manager is null");
        else Log.d(TAG,"");

        if(transaction==null)Log.d(TAG,"transaction is null");
        if(!isFinishing()){

        }else{
            Log.d(TAG,"Activity was finished");
        }*/

        /** fragmentOne = new FragmentOne();
         FragmentTransaction transaction = manager.beginTransaction();
         transaction.add(R.id.fragment_content,fragmentOne).commit(); */

        }
}

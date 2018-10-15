package com.independenciatecnologica.encuestappdos.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.independenciatecnologica.encuestappdos.model.EncuestaItem;
import com.independenciatecnologica.encuestappdos.R;
import com.independenciatecnologica.encuestappdos.databinding.EncuestaItemBinding;

import java.util.ArrayList;
import java.util.List;

public class EncuestaAdapter extends RecyclerView.Adapter<EncuestaAdapter.EncuestaHolder> {
    private List<EncuestaItem> ListItem = new ArrayList<>();

    public EncuestaAdapter(List<EncuestaItem>items){
        this.ListItem.addAll(items);
    }

    @NonNull
    @Override
    public EncuestaHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        EncuestaItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.encuesta_item,viewGroup,false);

        return new EncuestaHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EncuestaHolder holder, int i) {
          EncuestaItem item = ListItem.get(i);
          holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return ListItem.size();
    }

    public class EncuestaHolder extends RecyclerView.ViewHolder{
        private EncuestaItemBinding binding;

        public EncuestaHolder(EncuestaItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
           /* if(ListItem == null|| ListItem.size()==0){
                binding.
            }*/
        }
        public void bind(EncuestaItem item){
            binding.setItem(item);
            binding.executePendingBindings();
        }
    }
}

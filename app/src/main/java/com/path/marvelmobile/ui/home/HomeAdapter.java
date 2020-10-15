package com.path.marvelmobile.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.path.marvelmobile.R;
import com.path.marvelmobile.databinding.RcviewHomeItemBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public abstract class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private ArrayList<String> list;
    public HomeAdapter(ArrayList<String> list){
        this.list = list;
    }

    public abstract void onSelected(String object);

    public void AddList(ArrayList<String> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         LayoutInflater inflater = LayoutInflater.from(parent.getContext());
         RcviewHomeItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.rcview_home_item,parent,false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyViewHolder viewHolder = new MyViewHolder(holder.binding);
        viewHolder.bindTo(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {
       RcviewHomeItemBinding binding;
        public MyViewHolder(@NonNull RcviewHomeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(int position){
            binding.tvCharacter.setOnClickListener(v->{
               onSelected(binding.tvCharacter.getText().toString());
            });

        }
    }
}

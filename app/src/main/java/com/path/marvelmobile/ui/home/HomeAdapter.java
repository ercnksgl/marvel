package com.path.marvelmobile.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.path.marvelmobile.R;
import com.path.marvelmobile.databinding.RcviewHomeItemBinding;
import com.path.marvelmobile.remote.response.getCharacters.GetCharactersResult;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public abstract class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private ArrayList<GetCharactersResult> list;
    public HomeAdapter(ArrayList<GetCharactersResult> list){
        this.list = list;
    }

    public abstract void onSelected(String object);
    public abstract void fetchData();

    public void AddList(List<GetCharactersResult> list){
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
            String imgUrl = list.get(position).getThumbnail().getPath() +"."+ list.get(position).getThumbnail().getExtension();
            Glide.with(binding.getRoot().getContext()).load(imgUrl).into(binding.imgCharacter);

            if(position == list.size() -1)
                fetchData();

        }
    }
}

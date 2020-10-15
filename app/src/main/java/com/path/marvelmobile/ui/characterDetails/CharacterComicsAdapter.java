package com.path.marvelmobile.ui.characterDetails;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.path.marvelmobile.R;
import com.path.marvelmobile.databinding.RcviewCharacterDetailsItemBinding;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterComicsAdapter extends RecyclerView.Adapter<CharacterComicsAdapter.MyViewHolder> {

    private ArrayList<String> list;
    public CharacterComicsAdapter(ArrayList<String> list){
        this.list = list;
    }


    public void setList(List<String> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         LayoutInflater inflater = LayoutInflater.from(parent.getContext());
         RcviewCharacterDetailsItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.rcview_character_details_item,parent,false);

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
        RcviewCharacterDetailsItemBinding binding;
        public MyViewHolder(@NonNull RcviewCharacterDetailsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(int position){
            binding.tvComic.setText(list.get(position));
        }
    }
}

package com.example.mypets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.MyViewHolder> {

    private List<Pets> petListItem;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameDisplay;
        TextView summary;

        public MyViewHolder(View itemView) {
            super(itemView);

            nameDisplay = itemView.findViewById(R.id.displayed);
            //summary = itemView.findViewById(R.id.summary);
        }
    }

    public PetAdapter(Context context, List<Pets> petListItem) {
        this.petListItem = petListItem;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String fullName = petListItem.get(position).getName() + " "
                + petListItem.get(position).getBreed() + " "
                + petListItem.get(position).getGender() + " "
                + petListItem.get(position).getWeight();

        holder.nameDisplay.setText(fullName);

    }

    @Override
    public int getItemCount() {
        return petListItem.size();
    }

}

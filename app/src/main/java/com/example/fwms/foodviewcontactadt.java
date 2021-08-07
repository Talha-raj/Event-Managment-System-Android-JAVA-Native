package com.example.fwms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class foodviewcontactadt extends RecyclerView.Adapter<foodviewcontactadt.ViewHolder> {

    Context context;
    List<Food> foodLists;
    RecyclerView rvfood;
    final View.OnClickListener onClickListener = new Myonclicklistner();
    public  static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowguestname;
        TextView rowfooddetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowguestname = itemView.findViewById(R.id.foodorderguest);
            rowfooddetail= itemView.findViewById(R.id.foodDetials);
        }
    }

    public  foodviewcontactadt(Context context, List<Food> foodLists,RecyclerView rvfood){
        this.context = context;
        this.foodLists = foodLists;
        this.rvfood = rvfood;



    }
    @NonNull
    @Override
    public foodviewcontactadt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.foodviewdata,parent,false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  foodviewcontactadt.ViewHolder holder, int position) {

        Food food = foodLists.get(position);
        holder.rowguestname.setText(""+food.getGuestname());
        holder.rowfooddetail.setText(""+food.getFooddetails());

    }

    @Override
    public int getItemCount() {
        return foodLists.size();
    }

    private class Myonclicklistner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
                int itempo = rvfood.getChildLayoutPosition(v);
                String pname = foodLists.get(itempo).getGuestname();
            Toast.makeText(context, pname, Toast.LENGTH_SHORT).show();

        }
    }
}

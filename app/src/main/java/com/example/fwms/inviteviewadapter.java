package com.example.fwms;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class inviteviewadapter extends RecyclerView.Adapter<inviteviewadapter.ViewHolder> {

    Context context;
    List<Inviteview> invitev;
    RecyclerView invitelist;
    final View.OnClickListener onClickListener = new Myonclicklistner();
    public  static class ViewHolder extends RecyclerView.ViewHolder{

        TextView eventname;
        TextView eventtype;
        TextView eventdate;
        TextView eventlocation;
        TextView eventcontact;
        TextView eventdesc;
        Button choosefood;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventname = itemView.findViewById(R.id.eventnamei);
            eventtype = itemView.findViewById(R.id.evennametinvite);
            eventdate = itemView.findViewById(R.id.dateinvite);
            eventlocation = itemView.findViewById(R.id.locationinvite);
            eventcontact = itemView.findViewById(R.id.contactinvite);
            eventdesc = itemView.findViewById(R.id.descinvite);
            choosefood = itemView.findViewById(R.id.foodbtn);

        }
    }
    public inviteviewadapter(Context context, List<Inviteview> invitev,RecyclerView invitelist){
        this.context = context;
        this.invitev = invitev;
        this.invitelist = invitelist;


    }

    public inviteviewadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inviteviewdata,parent,false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull inviteviewadapter.ViewHolder holder, int position) {
        Inviteview inviteview = invitev.get(position);
        holder.eventname.setText(""+inviteview.getEventname());
        holder.eventtype.setText(""+inviteview.getEventType());
        holder.eventdate.setText(""+inviteview.getEventdate());
        holder.eventlocation.setText(""+inviteview.getEventlocation());
        holder.eventcontact.setText(""+inviteview.getEventcontact());
        holder.eventdesc.setText(""+inviteview.getEventdesc());
        holder.choosefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup parentView = (ViewGroup) v.getParent();
                parentView.removeView(v);
                Intent i = new Intent(context,RegisterFood.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        holder.eventcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Google_Maps.class);
                intent.putExtra("locationdata",holder.eventcontact.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return invitev.size();
    }

    private class Myonclicklistner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itempo = invitelist.getChildLayoutPosition(v);
            String ename = invitev.get(itempo).getEventname();
            String etyoe = invitev.get(itempo).getEventType();
            String edate = invitev.get(itempo).getEventdate();
            String elocation = invitev.get(itempo).getEventlocation();
            String econtact = invitev.get(itempo).getEventcontact();
            String edesc = invitev.get(itempo).getEventdesc();


            Toast.makeText(context, ename, Toast.LENGTH_SHORT).show();

        }
    }
}

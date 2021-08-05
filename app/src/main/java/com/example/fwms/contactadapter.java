package com.example.fwms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class contactadapter extends RecyclerView.Adapter<contactadapter.ViewHolder> {
    Context context;
    List<Contacts> contactsList;
    RecyclerView recyclerView;
    final View.OnClickListener onClickListener = new MyonClickListener();
    public  static class ViewHolder extends RecyclerView.ViewHolder{
            TextView rowId;
            TextView rowetypename;
            TextView rowename;
            //CalendarView datetime;
            TextView rowdatetime;
            TextView rowcontact;
            TextView rowdesc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowId= itemView.findViewById(R.id.vid);
            rowetypename = itemView.findViewById(R.id.etypeview);
            rowename = itemView.findViewById(R.id.enameview);
            rowdatetime = itemView.findViewById(R.id.edatatimeview);
            rowcontact = itemView.findViewById(R.id.econtactview);
            rowdesc = itemView.findViewById(R.id.edescview);


        }
    }
    public contactadapter(Context context, List<Contacts> contactsList, RecyclerView rview){
        this.context = context;
        this.contactsList = contactsList;
        this.recyclerView = rview;
    }

    @NonNull
    @Override
    public contactadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.singledata, viewGroup, false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull contactadapter.ViewHolder holder, int i) {
        Contacts contact = contactsList.get(i);
        holder.rowId.setText(""+contact.getId());
        holder.rowetypename.setText(""+contact.getEvent_type());
        holder.rowename.setText(""+contact.getEvent_name());
        holder.rowdatetime.setText(contact.getEvent_dattime());
        holder.rowcontact.setText(""+contact.getEvent_contact());
        holder.rowdesc.setText(""+contact.getEvent_describtiont());


    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    private class MyonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = recyclerView.getChildLayoutPosition(v);
            String item = contactsList.get(itemPosition).getEvent_name();
            Toast.makeText(context, item, Toast.LENGTH_SHORT).show();
        }
    }
}

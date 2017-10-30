package com.example.displaycontentproviderapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.ViewHolder> {

    List<Person> persons;
    Context context;

    public PersonListAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.tvName.setText(person.getName());
        holder.tvAge.setText(person.getAge());
        holder.tvGender.setText(person.getGender());
        holder.tvPhone.setText(person.getPhone());
        holder.tvAddress.setText(person.getAddress());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvAge;
        TextView tvGender;
        TextView tvPhone;
        TextView tvAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvAddress = itemView.findViewById(R.id.tvAddress);
        }
    }
}

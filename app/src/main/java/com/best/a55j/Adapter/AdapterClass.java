package com.best.a55j.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.best.a55j.R;
import com.best.a55j.User.Users;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Users> list;
    int ONLINE = 0;
    int OFFLINE = 1;

    public AdapterClass(Context context, ArrayList<Users> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ONLINE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.online, parent, false);
            return new Mode(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offline, parent, false);
            return new Mode1(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Users users = list.get(position);
        if (holder instanceof Mode ) {
            TextView textView = ((Mode) holder).textView;
            textView.setText(users.getName());
        }
        if (holder instanceof Mode1 ) {
            TextView textView = ((Mode1) holder).textView1;
            textView.setText(users.getName());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        Users users = list.get(position);
         if (users.isAvailable()) {
           return ONLINE;
        } else {
           return OFFLINE;
        }
    }

    public class Mode extends RecyclerView.ViewHolder {
        public View view;
        TextView textView;

        public Mode(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            textView = itemView.findViewById(R.id.txtBtnOnline);
        }
    }

    public class Mode1 extends RecyclerView.ViewHolder {
        public View view;
        TextView textView1;

        public Mode1(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            textView1 = itemView.findViewById(R.id.txtBtnOffline);
        }
    }
}

package com.best.a55j;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.best.a55j.Adapter.AdapterClass;
import com.best.a55j.User.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        open();
        ArrayList<Users> list = getData();
        refresh(list);
    }

    public void open() {
        recyclerView = findViewById(R.id.recyclerviewM);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

    public void refresh(ArrayList<Users> list) {
        AdapterClass adapterClass = new AdapterClass(context, list);
        recyclerView.setAdapter(adapterClass);
    }

    public ArrayList<Users> getData() {
        ArrayList<Users> list = new ArrayList<>();
                list.add(new Users("Alisher ", true));
                //list.add(new Users("Begzod ", false));

        return list;
    }
}
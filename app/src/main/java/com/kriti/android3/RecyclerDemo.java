package com.kriti.android3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerDemo extends AppCompatActivity {

    RecyclerView recyclerView; MyRecyclerAdapter adapter;
    //String[] names = {"One", "Two", "Three", "Four", "Five"};
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Integer> images = new ArrayList<Integer>();
    //int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);
        recyclerView = findViewById(R.id.recyclerView);

        names.add("One");
        names.add("Two");
        names.add("Three");
        names.add("Four");
        names.add("Five");

        images.add(R.drawable.one);
        images.add(R.drawable.two);
        images.add(R.drawable.three);
        images.add(R.drawable.four);
        images.add(R.drawable.five);

        adapter = new MyRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>
    {
        class MyViewHolder extends RecyclerView.ViewHolder
        {
            ImageView imageView; TextView textView;
            public MyViewHolder(@NonNull View itemView)
            {
                super(itemView);
                imageView = itemView.findViewById(R.id.recyclerImage);
                textView = itemView.findViewById(R.id.recyclerText);
            }
        }

        @NonNull
        @Override
        public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(RecyclerDemo.this);
            View view = inflater.inflate(R.layout.recycler_layout, parent, false);
            return new MyRecyclerAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyRecyclerAdapter.MyViewHolder holder, int position) {
            holder.imageView.setImageResource(images.get(position));
            holder.textView.setText(names.get(position));

            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   names.add("New");
                   images.add(R.drawable.one);
                   adapter.notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return names.size();
        }
    }
}
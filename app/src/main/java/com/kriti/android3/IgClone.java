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

import java.util.ArrayList;

public class IgClone extends AppCompatActivity {

    RecyclerView recyclerView; IgAdapter adapter;
    ArrayList<IgInfo> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ig_clone);

        recyclerView = findViewById(R.id.igRecyclerView);
        adapter = new IgAdapter();
        recyclerView.setAdapter(adapter);

        for (int i=0; i<9; i++)
        {
            IgInfo post = new IgInfo();
            post.setLiked(false);
            post.setImage(i);
            list.add(post);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    class IgAdapter extends RecyclerView.Adapter<IgAdapter.IgViewHolder>
    {
        class IgViewHolder extends RecyclerView.ViewHolder
        {
            ImageView igPost, igLiked;

            public IgViewHolder(@NonNull View itemView)
            {
                super(itemView);
                igPost = itemView.findViewById(R.id.igPost);
                igLiked = itemView.findViewById(R.id.igLike);
            }
        }

        @NonNull
        @Override
        public IgAdapter.IgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(IgClone.this);
            View view = inflater.inflate(R.layout.ig_clone_layout, parent, false);
            return new IgAdapter.IgViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull IgAdapter.IgViewHolder holder, int position)
        {
            int image = list.get(position).getImage();
            boolean liked = list.get(position).isLiked();

            holder.igPost.setImageResource(image);

            if (liked)
            {
                holder.igLiked.setImageResource(R.drawable.full_heart);
            }
            else
            {
                holder.igLiked.setImageResource(R.drawable.empty_heart);
            }

            holder.igLiked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (liked)
                    {
                        list.get(position).setLiked(false);
                    }
                    else
                    {
                        list.get(position).setLiked(true);
                    }

                    adapter.notifyDataSetChanged();
                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}
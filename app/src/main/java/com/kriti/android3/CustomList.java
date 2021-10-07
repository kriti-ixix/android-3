package com.kriti.android3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomList extends AppCompatActivity {

    String[] names = {"One", "Two", "Three", "Four", "Five"};
    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        listView = findViewById(R.id.customListView);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int i) {
            return names[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null)
            {
                view = getLayoutInflater().inflate(R.layout.custom_layout, viewGroup, false);
            }

            TextView textView = view.findViewById(R.id.customTextView);
            ImageView imageView = view.findViewById(R.id.customImageView);

            textView.setText(names[i]);
            imageView.setImageResource(images[i]);

            return view;
        }
    }
}
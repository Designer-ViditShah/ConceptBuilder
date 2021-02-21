package com.example.conceptbuilder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conceptbuilder.databinding.CommonLayoutBinding;

public class myAdapter extends RecyclerView.Adapter<myAdapter.holder>
{
    String title[], subtitle[];

    public myAdapter(String[] title, String[] subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.common_layout,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.tv1.setText(title[position]);
        String sample = subtitle[position].substring(0, Math.min(subtitle[position].length(), 150));
        holder.tv2.setText(sample);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }


    class holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv1,tv2;
        public holder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.imageView);
            tv1 = (TextView)itemView.findViewById(R.id.main_title);
            tv2 = (TextView)itemView.findViewById(R.id.sub_title);
        }
    }
}

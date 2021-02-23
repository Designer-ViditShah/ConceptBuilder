package com.example.conceptbuilder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.example.conceptbuilder.databinding.CommonLayoutBinding;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.holder>
{
    ArrayList title, subtitle, photolist;
    int length_photos = 0;

    // set listener for onclick event
    private View.OnClickListener onItemClickListener;
    public void setOnItemClickListener(View.OnClickListener clickListener) {
        onItemClickListener = clickListener;
    }
    public myAdapter(ArrayList title, ArrayList subtitle, ArrayList photolist) {
        this.title = title;
        this.subtitle = subtitle;
        this.photolist = photolist;
        length_photos = photolist.size();
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
        holder.tv1.setText(title.get(position).toString());
        String sample = subtitle.get(position).toString().substring(0, Math.min(subtitle.get(position).toString().length(), 150));
        holder.tv2.setText(sample);
        ImageView imageView = holder.itemView.findViewById(R.id.imageView);
        if(position<100) {
            String url = photolist.get(position).toString();
            Log.d("myadapter",url);
//            Picasso.with(holder.itemView.getContext()).load(url)
//                    .placeholder(R.drawable.sachin)
//                    .error(R.drawable.demo_1)
//                    .into(holder.img);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.sachin);
            requestOptions.error(R.drawable.demo_1);
            Glide.with(holder.itemView.getContext())
                    .setDefaultRequestOptions(requestOptions)
                    .load("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg")
                    .into(imageView);
            ;
        }
    }


    @Override
    public int getItemCount() {
        return title.size();
    }



    class holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv1,tv2;
        public holder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.imageView);
            tv1 = (TextView)itemView.findViewById(R.id.main_title);
            tv2 = (TextView)itemView.findViewById(R.id.sub_title);
            itemView.setTag(this);
            itemView.setOnClickListener(onItemClickListener);
        }
    }
}

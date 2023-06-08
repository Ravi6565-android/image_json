package com.example.image_json_volley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.time.Instant;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder> {
    ArrayList<String> list;
    Context context;
    public Adapter(Context context, ArrayList<String> list) {
       this.list=  list;
        this.context= context;
    }

    @NonNull
    @Override
    public Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_image_loader,parent,false);
        viewholder viewholder= new viewholder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewholder holder, int position) {
        Glide.with(context).load(list.get(position)).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}

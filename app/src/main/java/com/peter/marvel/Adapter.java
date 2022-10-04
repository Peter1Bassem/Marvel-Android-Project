package com.peter.marvel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{



    Context context;
    List<Model> data;

    public Adapter(Context context, List<Model> data) {
        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View recyclerItems = inflater.inflate(R.layout.hero,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(recyclerItems);

        return viewHolder;
    }

    @Override
        public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.name.setText(data.get(position).getName());
        holder.realname.setText(data.get(position).getRealname());
        Glide.with(context).load(data.get(position).getImageurl()).into(holder.imageurl);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(context,DescriptionActivity.class);
                i.putExtra("real",data.get(position).getRealname());
                i.putExtra("name",data.get(position).getName());
                i.putExtra("first",data.get(position).getFirstappearance());
                i.putExtra("team",data.get(position).getTeam());
                i.putExtra("bio",data.get(position).getBio());
                i.putExtra("createdby",data.get(position).getCreatedby());
                i.putExtra("Publisher",data.get(position).getPublisher());
                i.putExtra("Imageurl",data.get(position).getImageurl());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageurl;
        public TextView name;
        public TextView realname;
        public TextView team;
        public TextView firstappearance;
        public TextView createdby;
        public TextView publisher;
        public TextView bio;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.name);
            this.realname = itemView.findViewById(R.id.realname);
            this.team = itemView.findViewById(R.id.team);
            this.firstappearance = itemView.findViewById(R.id.fistapp);
            this.createdby = itemView.findViewById(R.id.creatdby);
            this.publisher = itemView.findViewById(R.id.publisher);
            this.bio = itemView.findViewById(R.id.bio);
            this.imageurl = itemView.findViewById(R.id.img);

        }
    }
}



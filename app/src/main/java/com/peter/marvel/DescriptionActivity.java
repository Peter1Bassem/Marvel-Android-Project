package com.peter.marvel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;

public class DescriptionActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name,realname,firstapp,team,createdby,publisher,bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        bio=findViewById(R.id.bio);
        team=findViewById(R.id.team);
        publisher=findViewById(R.id.publisher);
        realname=findViewById(R.id.realname);
        name=findViewById(R.id.name);
        createdby=findViewById(R.id.creatdby);
        firstapp=findViewById(R.id.fistapp);
        imageView=findViewById(R.id.back);

        Intent i=getIntent();
        String bioo=i.getStringExtra("bio");
        String teamm=i.getStringExtra("team");
        String publisherr=i.getStringExtra("Publisher");
        String createdbyy=i.getStringExtra("createdby");
        String firstappp=i.getStringExtra("first");
        String imagee=i.getStringExtra("Imageurl");
        String reall=i.getStringExtra("real");
        String namee=i.getStringExtra("name");

        bio.setText(bioo);
        team.setText(teamm);
        publisher.setText(publisherr);
        realname.setText(reall);
        name.setText(namee);
        createdby.setText(createdbyy);
        firstapp.setText(firstappp);

        Glide.with(this)
                .asBitmap()
                .load(imagee)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(BitmapTransitionOptions.withCrossFade())
                .into(imageView);
    }
}
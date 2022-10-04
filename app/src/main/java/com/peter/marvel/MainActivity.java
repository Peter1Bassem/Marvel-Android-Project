package com.peter.marvel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    RecyclerView firstRecycler,secondRecycler,thirdRecycler;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstRecycler = findViewById(R.id.rec);
        secondRecycler = findViewById(R.id.rec2);
        thirdRecycler = findViewById(R.id.rec3);
        dialog = progressDialog();
        dialog.show();

        getData();

    }

    private void getData(){

        Call<List<Model>> call = RetrofitClient.getInstance().getMyAPI().getHeros();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Code:"+String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                    return;
                }

                List<Model> heros = response.body();
                Adapter userRecyclerAdapter = new Adapter(MainActivity.this,heros);

                firstRecycler.setAdapter(userRecyclerAdapter);
                firstRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                secondRecycler.setAdapter(userRecyclerAdapter);
                secondRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                thirdRecycler.setAdapter(userRecyclerAdapter);
                thirdRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));

                Log.d("Code",String.valueOf(response.code()));
                dialog.cancel();

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                //Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("msg",t.getMessage());
                dialog.cancel();
            }
        });

    }

    public ProgressDialog progressDialog(){
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("API Fetching");
        dialog.setMessage("Loading Data");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        return dialog;
    }


}
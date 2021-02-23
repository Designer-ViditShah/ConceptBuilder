package com.example.conceptbuilder;

import android.content.Intent;
import android.os.Bundle;
import com.example.conceptbuilder.databinding.ActivityMainBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList titlelist = new ArrayList();
    ArrayList subtitlelist = new ArrayList();
    ArrayList photolist = new ArrayList();
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
        int position = viewHolder.getAdapterPosition();
        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
        String temp1 = titlelist.get(position).toString();
        String temp2 = subtitlelist.get(position).toString();
        String temp3 = photolist.get(position).toString();
        intent.putExtra("Title", temp1);
        intent.putExtra("Sub-Title", temp2);
        intent.putExtra("Photos", temp3);
        startActivity(intent);
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // viewBinding implementation
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // get data from the intent using Bundle instance
        Bundle extras= getIntent().getExtras();
        titlelist = extras.getStringArrayList("Title");
        subtitlelist = extras.getStringArrayList("SubTitle");
        binding.recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi1 = retrofit1.create(JsonPlaceHolderApi.class);
        Call<List<Photo>> call_photo = jsonPlaceHolderApi1.getPhotos();
        call_photo.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call_photo, Response<List<Photo>> response_photo) {
                if(!response_photo.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Error code: "+response_photo.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                List<Photo> p1 = response_photo.body();
                for(Photo photo : p1)
                {
                    photolist.add(photo.getUrl());
                    Log.d("Photosss",photo.getUrl().toString());
                }
                myAdapter madapter = new myAdapter(titlelist, subtitlelist, photolist);
                binding.recyclerViewOrders.setAdapter(madapter);
                madapter.setOnItemClickListener(onItemClickListener);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
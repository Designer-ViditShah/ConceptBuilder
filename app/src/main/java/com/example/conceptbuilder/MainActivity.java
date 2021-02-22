package com.example.conceptbuilder;
import android.content.Intent;
import android.os.Bundle;
import com.example.conceptbuilder.databinding.ActivityMainBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    String demo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    String[] title = {"Sachin Tendulkar 1", "Sachin Tendulkar 2", "Sachin Tendulkar 3","Sachin Tendulkar 4","Sachin Tendulkar 5","Sachin Tendulkar 6","Sachin Tendulkar 7","Sachin Tendulkar 8","Sachin Tendulkar 9","Sachin Tendulkar 10","Sachin Tendulkar 11","Sachin Tendulkar 12","Sachin Tendulkar 13","Sachin Tendulkar 14","Sachin Tendulkar 15"};
    String[] subtitle = {demo, demo, demo, demo, demo, demo, demo, demo, demo, demo, demo, demo, demo, demo, demo};
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
        int position = viewHolder.getAdapterPosition();
        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
        intent.putExtra("Title", title[position]);
        intent.putExtra("Sub-Title", subtitle[position]);
        startActivity(intent);
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
//        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                if(!response.isSuccessful())
//                {
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//
//            }
//        });

        binding.recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));
        myAdapter madapter = new myAdapter(title, subtitle);
        binding.recyclerViewOrders.setAdapter(madapter);
        madapter.setOnItemClickListener(onItemClickListener);
    }
}
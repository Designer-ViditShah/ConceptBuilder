package com.example.conceptbuilder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.conceptbuilder.databinding.ActivitySplashScreenBinding;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashScreen extends AppCompatActivity {
//  view binding for activity_splashscreen
    private ActivitySplashScreenBinding activitySplashScreenBinding;
//    to store the value like title and subtitle obtained using API
    ArrayList arrayListTitle,arrayListSubTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  view binding for activity_splashscreen
        activitySplashScreenBinding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(activitySplashScreenBinding.getRoot());
        //  creating arrayList
        arrayListTitle = new ArrayList();
        arrayListSubTitle = new ArrayList();
        //  code used for progress bar
        //  implementation is done is build.gradle app module
        Sprite animate = new Wave();
        activitySplashScreenBinding.progressBar.setIndeterminateDrawable(animate);
        //  creating retrofit for API calling
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/") //retrofit directs the app to the baseUrl
                .addConverterFactory(GsonConverterFactory.create()) //retrofit creates a converter to handle the JSON file
                .build();
        //  implementation for the interface that we created
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        //  calling getPosts method that we created within interface
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //   Response is the object that we get from the server
                //   if it is not successfully called than
                if(!response.isSuccessful())
                {
                    Toast.makeText(SplashScreen.this, "Error code: "+response.code(), Toast.LENGTH_LONG).show();
                    return;
                }
                //   response.body() gives the json file
                List<Post> p = response.body();
                //   within p variable we have json file
                //   to traverse the entire json we use a for loop
                for(Post post : p)
                {
                    // adding the content from json file to the respective array list
                    arrayListTitle.add(post.getTitle());
                    arrayListSubTitle.add(post.getSubtitle());
                    Log.d("Value",post.getTitle());
                }
                // once the data is stored inside the arrayList
                // data is transferred to myadapter class where recyclerview helps to display data
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Log.d("Size","of Title list = "+arrayListTitle.size());
                Log.d("Size","of SubTitle list = "+arrayListSubTitle.size());
                intent.putStringArrayListExtra("Title", arrayListTitle);
                intent.putStringArrayListExtra("SubTitle", arrayListSubTitle);
                Log.d("Size","of Title list = "+arrayListTitle.size());
                Log.d("Size","of SubTitle list = "+arrayListSubTitle.size());
                startActivity(intent);
                finish();
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(SplashScreen.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
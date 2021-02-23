package com.example.conceptbuilder;

import android.os.Bundle;
import com.example.conceptbuilder.databinding.FragmentMainBinding;
import com.squareup.picasso.Picasso;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Html;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    private FragmentMainBinding binding;
    public static final int MAX_LINES = 3; //get at max 3 lines
    String short_s = ""; //string upto certain words will be stored here
    String s = ""; // entire string will be stored here
    int set_limit = 10; // value assigned for certain words we want
    int count = 0; // 0 for read more and 1 for read less
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // get the intent's data in the bundle instance
        Bundle extras= getIntent().getExtras();
        //from the instance extract the data with the key mentioned in the parameter
        String url = extras.getString("Photos");
        String t = extras.getString("Title");
        s = extras.getString("Sub-Title");
        // inside load method we will pass the String url which will contain the url's fetched from the json file
        // in this case I have taken the static path for an image so same image will be displayed in all the ImageView
        Picasso.with(this).load("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg")
                .placeholder(R.drawable.sachin) //sample image till the image is not loaded
                .error(R.drawable.demo_1) // sample image if during the process to load the image error occured
                .into(binding.activity2Image);
        // using split function -> split the entire string with whitespace as the deliminator
        String[] words = s.split("\\s+");
        if(words.length<set_limit)
        {
            // enters this if total number of words are less than the minimum limit of words
            short_s = s;
            binding.activity2SubTitle.setText(short_s);
        }
        else{
            for(int i = 0; i < set_limit; i++)
            {
                short_s += words[i] + " ";
            }
            binding.activity2SubTitle.setText(Html.fromHtml(short_s+ "   ...<font color='blue'> <small><u>See More</u></small></font>"));
        }
        binding.activity2Title.setText(t);
        binding.activity2SubTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==0)
                {
                    count++;
                    binding.activity2SubTitle.setText(Html.fromHtml(s+"<font color='blue'> <small><u>See Less</u></small></font>"));
                }
                else
                {
                    count--;
                    binding.activity2SubTitle.setText(Html.fromHtml(short_s+ "   ...<font color='blue'> <small><u>See More</u></small></font>"));
                }
            }
        });


    }
}
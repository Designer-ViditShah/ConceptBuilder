package com.example.conceptbuilder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.example.conceptbuilder.databinding.ActivityMainBinding;
import com.example.conceptbuilder.databinding.CommonLayoutBinding;
import com.example.conceptbuilder.databinding.FragmentMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private FragmentMainBinding binding;
    int count = 0; // 0 for read more and 1 for read less
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras= getIntent().getExtras();
        String t = extras.getString("Title");
        final String s = extras.getString("Sub-Title");
        final String short_s = "";
        binding.activity2Title.setText(t);
        binding.activity2SubTitle.setText(s);
        Log.d("Message",s);
        binding.readMoreLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==0)
                {
                    //give button for read more
                    binding.readMoreLess.setText("Read Less...");
                    binding.activity2SubTitle.setText(s);
                    count++;
                }
                else
                {
                    //give button for read less
                    binding.readMoreLess.setText("Read More...");
                    binding.activity2SubTitle.setText(short_s);
                    count--;
                }
            }
        });

    }
}
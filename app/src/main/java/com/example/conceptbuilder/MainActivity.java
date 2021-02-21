package com.example.conceptbuilder;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.example.conceptbuilder.databinding.ActivityMainBinding;
import com.example.conceptbuilder.databinding.CommonLayoutBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.conceptbuilder.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
//    private RoundImage roundImage;
//    private CommonLayoutBinding clb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        clb = CommonLayoutBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
        setContentView(binding.getRoot());
//        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.profile);
//        roundImage = new RoundImage(bm);
//        clb.imageView.setImageDrawable(roundImage);

//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
//        FloatingActionButton fab = findViewById(R.id.fab);
        String[] title = {"Sachin Tendulkar", "Title2", "Title3","Title4", "Title5", "Title6"};
        String[] subtitle = {getString(R.string.sachin),"SubTitle2", "SubTitle3","SubTitle4", "SubTitle5", "SubTitle6"};
        binding.recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewOrders.setAdapter(new myAdapter(title, subtitle));
//        binding.recyclerViewOrders.addOnItemTouchListener();

//        for(int i=0;i<title.length;i++)
//        {
//            Log.d("Entered:","for loop");
//            LinearLayout layout = new LinearLayout(this);
//            layout.setOrientation(LinearLayout.HORIZONTAL);
//                ImageView imageView = new ImageView(this);
//                imageView.setImageResource(R.drawable.demo_1);
//                layout.addView(imageView);
//
//                LinearLayout layout_vertical = new LinearLayout(this);
//                layout_vertical.setOrientation(LinearLayout.VERTICAL);
//                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//                    TextView textView_title = new TextView(this);
//                    textView_title.setText(title[i]);
//                    textView_title.setAllCaps(true);
//                    textView_title.setLayoutParams(params);
//
//                    TextView textView_subtitle = new TextView(this);
//                    textView_subtitle.setText(subtitle[i]);
//                    textView_subtitle.setLayoutParams(params);
//                layout_vertical.addView(textView_title);
//                layout_vertical.addView(textView_subtitle);
//                layout.addView(layout_vertical);
//            Log.d("Entered:","last staement of for loop");
//            binding.recyclerViewOrders.addView(layout);
//        }
    }
}
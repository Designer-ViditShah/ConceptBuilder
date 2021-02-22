package com.example.conceptbuilder;
import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    String[] title = {"Sachin Tendulkar 1", "Sachin Tendulkar 2", "Sachin Tendulkar 3","Sachin Tendulkar 4","Sachin Tendulkar 5","Sachin Tendulkar 6","Sachin Tendulkar 7","Sachin Tendulkar 8","Sachin Tendulkar 9","Sachin Tendulkar 10","Sachin Tendulkar 11","Sachin Tendulkar 12","Sachin Tendulkar 13","Sachin Tendulkar 14","Sachin Tendulkar 15"};
    String[] subtitle = {getString(R.string.sachin),getString(R.string.sachin), getString(R.string.sachin),getString(R.string.sachin), getString(R.string.sachin), getString(R.string.sachin), getString(R.string.sachin), getString(R.string.sachin), getString(R.string.sachin), getString(R.string.sachin), getString(R.string.sachin), getString(R.string.sachin), getString(R.string.sachin), getString(R.string.sachin), getString(R.string.sachin)};
//    private RoundImage roundImage;
//    private CommonLayoutBinding clb;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();

        int position = viewHolder.getAdapterPosition();
//        Toast.makeText(MainActivity.this, "You Clicked: " + title[position], Toast.LENGTH_SHORT).show();
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
        binding.recyclerViewOrders.setLayoutManager(new LinearLayoutManager(this));
        myAdapter madapter = new myAdapter(title, subtitle);
        binding.recyclerViewOrders.setAdapter(madapter);
        madapter.setOnItemClickListener(onItemClickListener);


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
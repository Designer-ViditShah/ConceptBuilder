package com.example.conceptbuilder;
import android.os.Bundle;
import com.example.conceptbuilder.databinding.FragmentMainBinding;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
public class MainActivity2 extends AppCompatActivity {
    private FragmentMainBinding binding;
    String short_s = "";
    String s = "";
    int count = 0; // 0 for read more and 1 for read less
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras= getIntent().getExtras();
        String t = extras.getString("Title");
        s = extras.getString("Sub-Title");
        String[] words = s.split("\\s+");
        if(words.length<50)
        {
            binding.readMoreLess.setVisibility(View.INVISIBLE);
            short_s = s;

        }
        else{
            for(int i = 0; i < 50; i++)
            {
                short_s += words[i] + " ";
            }
        }
        binding.activity2SubTitle.setText(short_s);
        binding.activity2Title.setText(t);

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
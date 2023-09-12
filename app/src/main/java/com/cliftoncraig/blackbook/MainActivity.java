package com.cliftoncraig.blackbook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cliftoncraig.blackbook.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListView listView;
    Animation animation;
    String[] title;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        title = getResources().getStringArray(R.array.title);
        animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        MainAdapter adapter = new MainAdapter(MainActivity.this, title);
        listView = binding.listView;
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), title[position] + " was clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.foodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapp.R;

public class ClickItemActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_item);

        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.tvName);

        Intent intent=getIntent();

        if (intent.getExtras()!=null){
            String seletedName=intent.getStringExtra("name");
            int selectedImage=intent.getIntExtra("image", 0);

            textView.setText(seletedName);
            imageView.setImageResource(selectedImage);
        }
    }
}

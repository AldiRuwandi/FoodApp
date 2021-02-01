package com.example.foodapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.foodapp.R;
import com.example.foodapp.adapter.YoutubeAdapter;
import com.example.foodapp.data.DataList;

import java.util.ArrayList;

public class VideoFoodActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DataList> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_food);

        Toolbar tbNotif=findViewById(R.id.toolbar);
        setSupportActionBar(tbNotif);
        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Video Masakan Nusantara");

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        arrayList=new ArrayList<DataList>();

        DataList dataList=new DataList("https://www.youtube.com/watch?v=NQCYQ_MwMmg");
        arrayList.add(dataList);
        dataList=new DataList("https://www.youtube.com/watch?v=OdN7424sz4Y");
        arrayList.add(dataList);
        dataList=new DataList("https://www.youtube.com/watch?v=Vh__EYZzPwg");
        arrayList.add(dataList);
        dataList=new DataList("https://www.youtube.com/watch?v=tpXtRcncv4I");
        arrayList.add(dataList);
        dataList=new DataList("https://www.youtube.com/watch?v=m1yhIW6M4so");
        arrayList.add(dataList);

        YoutubeAdapter youtubeAdapter=new YoutubeAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(youtubeAdapter);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

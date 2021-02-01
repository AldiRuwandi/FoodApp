package com.example.foodapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodapp.R;
import com.example.foodapp.adapter.MainAdapter;
import com.example.foodapp.data.MainData;
import com.example.foodapp.model.MainModel;
import com.example.foodapp.support.ItemClickSupport;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMain;
    private TextView titleMain, txtFooter;
    private ArrayList<MainModel> list=new ArrayList<>();
    Animation one, two;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Toolbar tbNotif=findViewById(R.id.toolbar);
        setSupportActionBar(tbNotif);
        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Makanan Nusantara");

        titleMain=findViewById(R.id.txt_main);
        txtFooter=findViewById(R.id.txt_footer);
        rvMain=findViewById(R.id.rv_main);
        rvMain.setHasFixedSize(true);

        list.addAll(MainData.getListData());
        showRecyclerList();

        //load animation
        one= AnimationUtils.loadAnimation(this, R.anim.one);
        two=AnimationUtils.loadAnimation(this, R.anim.two);

        //run anim
        titleMain.startAnimation(two);
        rvMain.startAnimation(one);
        txtFooter.startAnimation(one);

        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        if (id==R.id.komposisi){
            Intent intent=new Intent(MainActivity.this, KomposisiActivity.class);
            startActivity(intent);
            return true;

        }else if(id==R.id.video_masak){
            Intent intent=new Intent(MainActivity.this, VideoFoodActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList(){
        SnapHelper snapHelper=new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rvMain);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvMain.setLayoutManager(linearLayoutManager);
        MainAdapter listMainAdapter=new MainAdapter(this);
        listMainAdapter.setListMain(list);
        rvMain.setAdapter(listMainAdapter);

        ItemClickSupport.addTo(rvMain).setOnItemClickListener(new ItemClickSupport.OnItemClickListener(){
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v){
                //menyimpan data ke dalam model
                MainModel mainModel=new MainModel();
                mainModel.setName(list.get(position).getName());
                mainModel.setDaerah(list.get(position).getDaerah());
                mainModel.setDesc(list.get(position).getDesc());
                mainModel.setPhoto(list.get(position).getPhoto());

                //berpindah halaman dengan membawa data yang sudah disimpan di dalam model
                startActivity(new Intent(MainActivity.this, DetailActivity.class).putExtra(DetailActivity.EXTRA_KEY, mainModel));
            }
        });
    }

    public void openGithub(View view){
        //get the URL text
        String url="https://github.com/AzharRivaldi";

        //parse the URL and create the intent
        Uri webpage=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW, webpage);

        //find as activity to hand the intent and start that activity
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "Link tidak bisa diakses", Toast.LENGTH_SHORT).show();
        }
    }
}

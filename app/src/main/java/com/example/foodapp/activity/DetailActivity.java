package com.example.foodapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodapp.R;
import com.example.foodapp.model.MainModel;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_KEY="EXTRA_KEY";
    TextView tvName, tvDaerah, tvDesc;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail);

        MainModel dataMain=getIntent().getParcelableExtra(EXTRA_KEY);
        Toolbar tbNotif=findViewById(R.id.toolbar);
        setSupportActionBar(tbNotif);
        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Makanan");

        tvName=findViewById(R.id.tv_name);
        tvDaerah=findViewById(R.id.tv_daerah);
        tvDesc=findViewById(R.id.tv_desc);
        imgPhoto=findViewById(R.id.img_photo);

        tvName.setText(dataMain.getName());
        tvDaerah.setText(dataMain.getDaerah());
        tvDesc.setText(dataMain.getDesc());

        Glide.with(this).load(dataMain.getPhoto()).into(imgPhoto);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

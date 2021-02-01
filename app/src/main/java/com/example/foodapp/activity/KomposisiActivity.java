package com.example.foodapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapp.R;

public class KomposisiActivity extends AppCompatActivity {

    GridView gridView;

    String[] names={"Sate Padang", "Rendang", "Gorengan", "Pempek", "Soto"};
    int[] images={R.drawable.gambarbuatandroid, R.drawable.rendang, R.drawable.gorengan, R.drawable.pempek, R.drawable.soto};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komposisi);

        Toolbar tbNotif=findViewById(R.id.toolbar);
        setSupportActionBar(tbNotif);
        assert getSupportActionBar()!=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Komposisi Bahan Masakan");

        gridView=findViewById(R.id.gridView);
        CustomAdapter customAdapter=new CustomAdapter(names, images, this);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName=names[position];
                int selectedImage=images[position];

                startActivity(new Intent(KomposisiActivity.this, ClickItemActivity.class).putExtra("name", selectedName).putExtra("image", selectedImage));
            }
        });
    }

    public class CustomAdapter extends BaseAdapter{

        private String[] imageNames;
        private int[] imagesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] imageNames, int[] imagesPhoto, Context context) {
            this.imageNames = imageNames;
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater=(LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            if (view==null){
                view=layoutInflater.inflate(R.layout.row_item, parent, false);
            }

            TextView tvName=view.findViewById(R.id.tvName);
            ImageView imagePhoto=view.findViewById(R.id.imageView);

            tvName.setText(imageNames[position]);
            imagePhoto.setImageResource(imagesPhoto[position]);

            return view;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

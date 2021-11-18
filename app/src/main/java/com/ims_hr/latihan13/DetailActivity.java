package com.ims_hr.latihan13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView IV_Pic;
    TextView TV_Desc, TV_Rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Inisial();
        Set_Object();
    }

    private void Inisial() {
        IV_Pic = findViewById(R.id.imageView_Detail_Pic);
        TV_Desc = findViewById(R.id.textView_Detail_Desc);
        TV_Rating = findViewById(R.id.textView_Detail_Rating);
    }

    private void Set_Object() {
        Intent intent = getIntent();
        String Judul = intent.getStringExtra(MainActivity.KEY_JUDUL);
        String Rating = intent.getStringExtra(MainActivity.KEY_RATING);
        TV_Rating.setText("Rating: " + Rating);
        if(Judul.equals("THE SOCIAL NETWORK")) {
            IV_Pic.setImageResource(R.drawable.img_1);
            TV_Desc.setText(R.string.sinopsis1);
        } else {
            IV_Pic.setImageResource(R.drawable.img_2);
            TV_Desc.setText(R.string.sinopsis2);
        }
    }

}

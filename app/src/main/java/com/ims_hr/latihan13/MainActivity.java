package com.ims_hr.latihan13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner SP_Film;
    ArrayAdapter<CharSequence> arrayAdapter;
    Button B_Submit;
    RatingBar RB_Rating;
    public static final String KEY_JUDUL = "judul", KEY_RATING = "rating";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inisial();
        Set_Object();
        Listen_B_Submit();
    }

    private void Inisial() {
        SP_Film = findViewById(R.id.spinner_Main_Film);
        arrayAdapter = ArrayAdapter.createFromResource
                (MainActivity.this,R.array.list_film,android.R.layout.simple_spinner_item);
        B_Submit = findViewById(R.id.button_Main_Submit);
        RB_Rating = findViewById(R.id.ratingBar_Main_Rating);
    }

    private void Set_Object() {
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SP_Film.setAdapter(arrayAdapter);
    }

    private void Listen_B_Submit() {
        B_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Film = SP_Film.getSelectedItem().toString();
                String Rating = Rating_Film();
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra(KEY_JUDUL,Film);
                intent.putExtra(KEY_RATING,Rating);
                startActivity(intent);
            }
        });
    }

    private String Rating_Film() {
        float Rating = RB_Rating.getRating();
        String Hasil = "";
        if(Rating >= 5) {
            Hasil = "PORNO";
        } else if(Rating >= 4) {
            Hasil = "DEWASA";
        } else if(Rating >= 3) {
            Hasil = "REMAJA";
        } else if(Rating >= 2) {
            Hasil = "ANAK-ANAK";
        } else {
            Hasil = "SEMUA UMUR";
        }
        return Hasil;
    }

}

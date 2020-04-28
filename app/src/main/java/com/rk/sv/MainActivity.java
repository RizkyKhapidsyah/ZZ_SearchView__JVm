package com.rk.sv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView SV_1_IDJAVA;
    ListView LV_1_IDJAVA;
    ArrayList<String> TempatSearchList;
    ArrayAdapter<String> PencocokSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SV_1_IDJAVA = findViewById(R.id.SV_1_IDXML);
        LV_1_IDJAVA = findViewById(R.id.LV_1_IDXML);

        TempatSearchList = new ArrayList<>();
        TempatSearchList.add("Indonesia");
        TempatSearchList.add("Malaysia");
        TempatSearchList.add("Papua Nugini");
        TempatSearchList.add("Jerman");
        TempatSearchList.add("Denmark");
        TempatSearchList.add("Belanda");
        TempatSearchList.add("Turki");
        TempatSearchList.add("Arab Saudi");
        TempatSearchList.add("Palestina");
        TempatSearchList.add("Yaman");
        TempatSearchList.add("Oman");
        TempatSearchList.add("Persia");
        TempatSearchList.add("Iraq");

        PencocokSearch = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, TempatSearchList);
        LV_1_IDJAVA.setAdapter(PencocokSearch);

        SV_1_IDJAVA.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (TempatSearchList.contains(query)) {
                    PencocokSearch.getFilter().filter(query);
                } else {
                    Toast.makeText(MainActivity.this, "Tidak Ada Yang Cocok Yang Ditemukan", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                PencocokSearch.getFilter().filter(newText);
                return false;
            }
        });

    }
}

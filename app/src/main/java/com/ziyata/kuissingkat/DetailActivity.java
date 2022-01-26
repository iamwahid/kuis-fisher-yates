package com.ziyata.kuissingkat;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private String[] dataNama;
    private String[] dataDescription;
    private String[] dataNamaBing;
    private String[] dataSumberGambar;
    private TypedArray dataPhoto;
    private MakananAdapter adapter;
    private ArrayList<Makanan> makanans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.setTitle("Daftar Makanan");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //memeberikan tombol back di bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new MakananAdapter(this);
        ListView listView = findViewById(R.id.lv_listt);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(DetailActivity.this, DetailMakananActivity.class);
                intent.putExtra("key",makanans.get(i));
                startActivity(intent);

                Toast.makeText(DetailActivity.this, makanans.get(i).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addItem() {
        makanans = new ArrayList<>();
        for (int i = 0; i < dataNama.length; i++) {
            Makanan makanan = new Makanan();
            makanan.setPhoto(dataPhoto.getResourceId(i, -1));

            makanan.setNama(dataNama[i]);
            makanan.setDescription(dataDescription[i]);
            makanan.setNamaBing(dataNamaBing[i]);
            makanan.setSumberGambar(dataSumberGambar[i]);
            makanans.add(makanan);
        }
        adapter.setMakanans(makanans);
    }

    private void prepare() {
        dataNama = getResources().getStringArray(R.array.data_nama);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataNamaBing = getResources().getStringArray(R.array.data_namaBing);
        dataSumberGambar = getResources().getStringArray(R.array.data_sumber);

        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

    }

}

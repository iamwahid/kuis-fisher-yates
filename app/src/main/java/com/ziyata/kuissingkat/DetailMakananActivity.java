package com.ziyata.kuissingkat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMakananActivity extends AppCompatActivity {

    private TextView nama, namaBing, keterangan, thn_release, genre, sumberGambar;
    private ImageView imgPhoto, imgBackdrop;
    private String namamovie, jabatann , deskripsii, remarkss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        this.setTitle("Detail Makanan");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Makanan makanan = getIntent().getParcelableExtra("key");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nama = findViewById(R.id.nama_makanan);
        keterangan = findViewById(R.id.detail_makanan);
        namaBing = findViewById(R.id.nama_makanan_b_ing);
        sumberGambar = findViewById(R.id.sumber_gambar);

        imgPhoto = findViewById(R.id.img_photoo);


        imgPhoto.setImageResource(makanan.getPhoto());

        nama.setText(makanan.getNama());
        keterangan.setText(makanan.getDescription());
        namaBing.setText(makanan.getNamaMakanan_Bing());
        sumberGambar.setText(makanan.getSumberGambar());

    }
}

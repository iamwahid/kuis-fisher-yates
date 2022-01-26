package com.ziyata.kuissingkat;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ziyata.kuissingkat.Kuis.Kuis2Gambar;
import com.ziyata.kuissingkat.Kuis.KuisEssay;
import com.ziyata.kuissingkat.Kuis.KuisPilihanGanda;

public class MainActivity extends AppCompatActivity {
    LinearLayout mlinePilGan, mLineEssay, mLineDaftarMakanan, mLineKuisSambungKata;	//variabel baru bertipe LinearLayout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menyambungkan variabel pada MainActivity.java dengan id pada activity_main
        //pastikan tipe data variabel dengan view id sama
        mlinePilGan = findViewById(R.id.linePilGan);
        mLineEssay = findViewById(R.id.lineEssay);
        mLineDaftarMakanan = findViewById(R.id.lineDaftarMakanan);
        mLineKuisSambungKata = findViewById(R.id.lineKuisSambungKata);

        //memberi aksi ketika diklik
        mlinePilGan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hasil aksinya ditulis disini (dalam method onClick)
                //pada kali ini hasil yang diinginkan adalah pindah activity, maka

                //membuat objek baru dari kelas intent,
                //dari MainActivity akan pindah ke KuisPilihaGanda
                Intent i = new Intent(MainActivity.this, KuisPilihanGanda.class);
                startActivity(i); //jalankan Intent
            }
        });

        mLineEssay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hasil aksinya ditulis disini (dalam method onClick)
                //pada kali ini hasil yang diinginkan adalah pindah activity, maka

                //membuat objek baru dari kelas intent,
                //dari MainActivity akan pindah ke KuisEssay
                Intent i = new Intent(MainActivity.this, KuisEssay.class);
                startActivity(i);
            }
        });

        mLineDaftarMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(i);
            }
        });

        mLineKuisSambungKata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Kuis2Gambar.class);
                startActivity(i);
            }
        });
    }

    public void onBackPressed(){
        moveTaskToBack(true);
        //jadi yang awalnya klik tombol back maka akan kembali ke activity sebelumnya
        //kali ini ketika tombol back diklik maka
        //hanya muncul Toast
    }

}
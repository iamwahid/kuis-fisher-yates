package com.ziyata.kuissingkat.Kuis;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ziyata.kuissingkat.HasilSkoring;
import com.ziyata.kuissingkat.R;
import com.ziyata.kuissingkat.Soal.SoalPilihanGanda;

import com.ziyata.kuissingkat.FisherYates;

public class KuisPilihanGanda extends AppCompatActivity {
    //membuat variabel baru sesuai tipe
    TextView mtvSkor, mtvSoal;
    RadioGroup mrgPilihanJawaban, getMrgPilihanJawaban22;
    RadioButton mrbPilihanJawaban1, mrbPilihanJawaban2, mrbPilihanJawaban3;
    Button mbtnSubmit;
    ImageView img_soal_pilgan;

    int skor=0;
    int arr; //untuk menampung nilai panjang array
    int x;   //menunjukkan konten sekarang
    String jawaban; // menampung jawaban benar
    String detaill;

    //membuat objek dari kelas SoalPilihanGanda.java
    SoalPilihanGanda soalPG = new SoalPilihanGanda();

    private Integer indexSoal[] = {0,1,2,3,4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_pilihan_ganda);

        //menyambungkan antara variabel KuisPilihanGanda.java dengan id activity_kuis_pilihan_ganda
        mtvSoal = (TextView) findViewById(R.id.tvSoal);
        mrgPilihanJawaban = (RadioGroup) findViewById(R.id.rgPilihanJawaban);
        ///getMrgPilihanJawaban22 = (RadioGroup)findViewById(R.id.rgPilihanJawaban22);

        mrbPilihanJawaban1 = (RadioButton) findViewById(R.id.rbPilihanJawaban1);
        mrbPilihanJawaban2 = (RadioButton) findViewById(R.id.rbPilihanJawaban2);
        mrbPilihanJawaban3 = (RadioButton) findViewById(R.id.rbPilihanJawaban3);
        mbtnSubmit = (Button) findViewById(R.id.btnSubmit);
        img_soal_pilgan = (ImageView) findViewById(R.id.tv_gambar);

        // Fisher-Yates
        FisherYates.shuffle(indexSoal);

        //set konten
        ///mtvSkor.setText(""+skor);
        setKonten();

        //menentukan aksi ketika button submit diklik
        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aksinya disini
                //aksinya adalah ketika button tersebut diklik maka
                //akan mengecek jawaban benar atau salah
                //kemudian konten akan berubah (next konten)
                cekJawaban();
            }
        });
    }

    //method untuk mengambil dan update konten dari SoalPilihanGanda.java
    //kemudian disetting/ditempatkan pada tempat yang telah disediakan
    public void setKonten(){
        mrgPilihanJawaban.clearCheck();
        //MrgPilihanJawaban22.clearCheck();

        arr = soalPG.pertanyaan.length;
        int indexLength = indexSoal.length;
        if(x >= indexLength){ //jika nilai x melebihi nilai arr(panjang array) maka akan pindah activity (kuis selesai)
            String jumlahSkor = String.valueOf(skor);	//menjadikan skor menjadi string
            Intent i = new Intent(KuisPilihanGanda.this, HasilSkoring.class);
            //waktu pindah activity, sekalian membawa nilai jumlahSkor yang ditampung dengan inisial skorAkhir
            //singkatnya skorAkhir = jumlahSkor
            //jika masih belum jelas silahkan bertanya
            i.putExtra("skorAkhir",jumlahSkor);
            i.putExtra("activity","PilihanGanda");
            startActivity(i);
        }else{
            //setting text dengan mengambil text dari method getter di kelas SoalPilihanGanda

            int index = indexSoal[x];
            mtvSoal.setText(soalPG.getPertanyaan(index));
            mrbPilihanJawaban1.setText(soalPG.getPilihanJawaban1(index));
            mrbPilihanJawaban2.setText(soalPG.getPilihanJawaban2(index));
            mrbPilihanJawaban3.setText(soalPG.getPilihanJawaban3(index));
            ubahgambarpilihanganda(index);

            jawaban = soalPG.getJawabanBenar(index);
        }
        x++;
    }

    public void ubahgambarpilihanganda(int ix){
        Resources res = getResources();
        String mPhoto = soalPG.getStringGambar(ix);
        int resID = res.getIdentifier(mPhoto, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID);
        img_soal_pilgan.setImageDrawable(drawable);
    }

    public void cekJawaban(){
        if(mrbPilihanJawaban1.isChecked()){ //jika radio button 1 diklik
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if(mrbPilihanJawaban1.getText().toString().equals(jawaban)){
                skor = skor + 20;
                ///mtvSkor.setText(""+skor);	//mtvSkor diset nilainya = var skor
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"

                //Intent moveDetail = new Intent(KuisPilihanGanda.this, DetailActivity.class);
                //startActivity(moveDetail);
                //finish();

                setKonten(); //update next konten
            }else{

                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();

            }
        }else if(mrbPilihanJawaban2.isChecked()){
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if(mrbPilihanJawaban2.getText().toString().equals(jawaban)){
                skor = skor + 20;
                ///mtvSkor.setText(""+skor);	//mtvSkor diset nilainya = var skor
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten

            }else{
                ///mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();

            }
        }else if(mrbPilihanJawaban3.isChecked()){
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if(mrbPilihanJawaban3.getText().toString().equals(jawaban)){
                skor = skor + 20;
                ///mtvSkor.setText(""+skor);	//mtvSkor diset nilainya = var skor
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten

            }else{
                ///mtvSkor.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();

            }
        }else{
            Toast.makeText(this, "Silahkan pilih jawaban dulu!", Toast.LENGTH_SHORT).show();
        }
    }

    //ini adalah method bawaan dari Android Studio
    //fungsi : memberi aksi ketika tombol back pada hp diklik
    public void onBackPressed(){
        Toast.makeText(this, "Selesaikan kuis", Toast.LENGTH_SHORT).show();
        //jadi yang awalnya klik tombol back maka akan kembali ke activity sebelumnya
        //kali ini ketika tombol back diklik maka
        //hanya muncul Toast
    }
}
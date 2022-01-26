package com.ziyata.kuissingkat.Kuis;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ziyata.kuissingkat.FisherYates;
import com.ziyata.kuissingkat.HasilSkoring;
import com.ziyata.kuissingkat.R;
import com.ziyata.kuissingkat.Soal.SoalKuis2Gambar;

public class Kuis2Gambar extends AppCompatActivity {
    TextView mtvSkor2,mtvSoal2;
    ImageView mivGambar;
    EditText medtJawaban;
    Button mbtnSubmit2;
    int x=0;
    int arr;
    int skor;
    String jawaban;

    SoalKuis2Gambar soalKuis2Gambar = new SoalKuis2Gambar();

    private Integer indexSoal[] = {0,1,2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis2_gambar);

        mtvSoal2 = (TextView) findViewById(R.id.tvSoalKuis2gambar);
        mivGambar = (ImageView) findViewById(R.id.ivGambarKuis2Gambar);
        medtJawaban = (EditText) findViewById(R.id.edtJawaban_Kuis2Gambar);
        mbtnSubmit2 = (Button) findViewById(R.id.btnSubmitKuis2gambar);

        // Fisher-Yates
        FisherYates.shuffle(indexSoal);

        setKonten();

        mbtnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });
    }

    public void setKonten(){
        medtJawaban.setText(null);
        arr = soalKuis2Gambar.pertanyaan.length;
        int indexLength = indexSoal.length;
        if(x >= indexLength){ //jika nilai x melebihi nilai arr(panjang array) maka akan pindah activity (kuis selesai)
            String jumlahSkor = String.valueOf(skor);	//menjadikan skor menjadi string
            Intent i = new Intent(Kuis2Gambar.this, HasilSkoring.class);
            //waktu pindah activity, sekalian membawa nilai jumlahSkor yang ditampung dengan inisial skorAkhir2
            //singkatnya skorAkhir2 = jumlahSkor
            //jika masih belum jelas silahkan bertanya
            i.putExtra("skorAkhirKuis2Gambar",jumlahSkor);
            i.putExtra("activity","Kuis2Gambar");
            startActivity(i);
        }else{
            //setting text dengan mengambil text dari method getter di kelas SoalEssay
            int index = indexSoal[x];
            mtvSoal2.setText(soalKuis2Gambar.getPertanyaan(index));
            ubahGambar(index);
            jawaban = soalKuis2Gambar.getJawabanBenar(index);
        }
        x++;
    }

    public void ubahGambar(int ix){
        Resources res = getResources();
        String mPhoto = soalKuis2Gambar.getStringGambar(ix);
        int resID = res.getIdentifier(mPhoto, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID);
        mivGambar.setImageDrawable(drawable);
    }

    public void cekJawaban(){
        if(!medtJawaban.getText().toString().isEmpty()){ //jika edit text TIDAK kosong
            //jika text yang tertulis di edit text tsb = nilai dari var jawaban
            if(medtJawaban.getText().toString().equalsIgnoreCase(jawaban)){
                skor = skor + 30;
                ///mtvSkor2.setText(""+skor);	//mtvSkor2 diset nilainya = var skor
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                ///mtvSkor2.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                ///setKonten();
            }
        }else{
            Toast.makeText(this, "Silahkan pilih dijawab dulu!", Toast.LENGTH_SHORT).show();
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


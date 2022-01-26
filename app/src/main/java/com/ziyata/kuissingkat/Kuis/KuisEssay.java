package com.ziyata.kuissingkat.Kuis;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ziyata.kuissingkat.FisherYates;
import com.ziyata.kuissingkat.HasilSkoring;
import com.ziyata.kuissingkat.R;
import com.ziyata.kuissingkat.Soal.SoalEssay;

public class KuisEssay extends AppCompatActivity {
    TextView mtvSkor2,mtvSoal2;
    ImageView mivGambar;
    EditText medtJawaban;
    Button mbtnSubmit2;
    int x = 0 ;
    int arr;
    int skor;
    String jawaban;

    SoalEssay essay = new SoalEssay();

    private Integer indexSoal[] = {0,1,2,3,4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_essay);

        mtvSoal2 = (TextView) findViewById(R.id.tvSoal2);
        mivGambar = (ImageView) findViewById(R.id.ivGambar);
        medtJawaban = (EditText) findViewById(R.id.edtJawaban_KuisEssay);
        mbtnSubmit2 = (Button) findViewById(R.id.btnSubmit2);

        // Fisher-Yates
        FisherYates.shuffle(indexSoal);

        setKonten();
        ///setBackk();

        mbtnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });

    }

    public void setKonten(){
        medtJawaban.setText(null);
        arr = essay.pertanyaan.length;
        int indexLength = indexSoal.length;
        if(x >= indexLength){ //jika nilai x melebihi nilai arr(panjang array) maka akan pindah activity (kuis selesai)
            String jumlahSkor = String.valueOf(skor);	//menjadikan skor menjadi string
            Intent i = new Intent(KuisEssay.this, HasilSkoring.class);
            //waktu pindah activity, sekalian membawa nilai jumlahSkor yang ditampung dengan inisial skorAkhir2
            //singkatnya skorAkhir2 = jumlahSkor
            //jika masih belum jelas silahkan bertanya
            i.putExtra("skorAkhir2",jumlahSkor);
            i.putExtra("activity","Essay");
            startActivity(i);
        }else{
            //setting text dengan mengambil text dari method getter di kelas SoalEssay
            int index = indexSoal[x];
            mtvSoal2.setText(essay.getPertanyaan(index));
            ubahGambar(index);
            jawaban = essay.getJawabanBenar(index);
        }
        x++;
    }

    public void ubahGambar(int ix){
        Resources res = getResources();
        String mPhoto = essay.getStringGambar(ix);
        int resID = res.getIdentifier(mPhoto, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID);
        mivGambar.setImageDrawable(drawable);
    }

    public void cekJawaban(){
        if(!medtJawaban.getText().toString().isEmpty()){ //jika edit text TIDAK kosong
            //jika text yang tertulis di edit text tsb = nilai dari var jawaban
            if(medtJawaban.getText().toString().equalsIgnoreCase(jawaban)){
                skor = skor + 20;
                ///mtvSkor2.setText(""+skor);	//mtvSkor2 diset nilainya = var skor
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                ///mtvSkor2.setText(""+skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else{
            Toast.makeText(this, "Silahkan pilih masukkan jawaban dulu!", Toast.LENGTH_SHORT).show();
        }
    }

    public void setBackk(){
        medtJawaban.setText(null);
        arr = essay.pertanyaan.length;
        int index = indexSoal[x];
        if(x == 0){
            mtvSoal2.setText(essay.getPertanyaan(index));
            ubahGambar(index);
            jawaban = essay.getJawabanBenar(index);

        }else{

        }
        x--;

        ///arr = essay.pertanyaan.length;
        ///if(x >= arr){ //jika nilai x melebihi nilai arr(panjang array) maka akan pindah activity (kuis selesai)
            ///String jumlahSkor = String.valueOf(skor);	//menjadikan skor menjadi string
           /// Intent i = new Intent(KuisEssay.this, HasilSkoring.class);
        ///}else{
            //setting text dengan mengambil text dari method getter di kelas SoalEssay
           /// mtvSoal2.setText(essay.getPertanyaan(x));
            ///ubahGambar();
           /// jawaban = essay.getJawabanBenar(x);
        ///}
        ///x--;
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

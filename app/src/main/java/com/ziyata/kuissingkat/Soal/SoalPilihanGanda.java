package com.ziyata.kuissingkat.Soal;

import android.os.Parcel;
import android.os.Parcelable;

public class SoalPilihanGanda implements Parcelable {

    private String detail;

    //membuat array untuk pertanyaan
    public String pertanyaan[] = {
            "Apa nama makanan ini ?",
            "Apa nama makanan ini ?",
            "Apa nama makanan ini ?",
            "Apa nama makanan ini ?",
            "Apa nama makanan ini ?",
    };

    //membuat array untuk pilihan jawaban
    private String pilihanJawaban[][] = {
            {"A. Gado-gado","B. Satai","C. Bakso"},
            {"A. Soto","B. Gado - gado","C. Satai"},
            {"A. Rendang","B. Soto","C. Gado-gado"},
            {"A. Satai","B. Soto","C. Bakso"},
            {"A. Satai","B. Gado - gado", "C. Soto"},
    };

    //membuat array untuk jawaban benar
    private String jawabanBenar[] = {
            "C. Bakso",
            "B. Gado - gado",
            "A. Rendang",
            "A. Satai",
            "C. Soto"
    };

    //membuat array untuk set gambar (dari String diubah jadi ImageView)
    //pastikan yang tertulis disini sama dengan nama di drawable
    //lihat gambar penjelasan1
    private String imagee[] = {
            "bakso",
            "gadogado",
            "rendang",
            "sate",
            "soto",
    };
    
    //membuat getter untuk mengambil pertanyaan
    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    //membuat getter untuk mengambil pilihan jawaban 1
    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    //membuat getter untuk mengambil pilihan jawaban 2
    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    //membuat getter untuk mengambil pilihan jawaban 3
    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getStringGambar(int x){
        String gambar = imagee[x];
        return gambar;
    }

    //membuat getter untuk mengambil pertanyaan
    public String getDetail() {
        return detail;
    }

    public void getDetail(String detail) {
        this.detail = detail;
    }

    public SoalPilihanGanda() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.detail);
        dest.writeStringArray(this.pertanyaan);
        dest.writeStringArray(this.jawabanBenar);
        dest.writeStringArray(this.imagee);
    }

    protected SoalPilihanGanda(Parcel in) {
        this.detail = in.readString();
        this.pertanyaan = in.createStringArray();
        this.jawabanBenar = in.createStringArray();
        this.imagee = in.createStringArray();
    }

    public static final Creator<SoalPilihanGanda> CREATOR = new Creator<SoalPilihanGanda>() {
        @Override
        public SoalPilihanGanda createFromParcel(Parcel source) {
            return new SoalPilihanGanda(source);
        }

        @Override
        public SoalPilihanGanda[] newArray(int size) {
            return new SoalPilihanGanda[size];
        }
    };
}
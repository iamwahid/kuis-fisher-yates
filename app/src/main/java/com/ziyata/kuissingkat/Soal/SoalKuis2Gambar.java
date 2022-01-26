package com.ziyata.kuissingkat.Soal;

public class SoalKuis2Gambar {
    //membuat array untuk pertanyaan
    public String pertanyaan[] = {
            "Gabungkan gambar di atas menjadi kalimat",
            "Gabungkan gambar di atas menjadi kalimat",
            "Gabungkan gambar di atas menjadi kalimat",
    };

    //membuat array untuk set gambar (dari String diubah jadi ImageView)
    //pastikan yang tertulis disini sama dengan nama di drawable
    //lihat gambar penjelasan
    private String image[] = {
            "sate_ponorogo",
            "pecel_madiun",
            "rendang_sumatera",
    };

    //membuat array jawaban benar
    private String jawabanBenar[] = {
            "Satai Ponorogo",
            "Pecel Madiun",
            "Rendang Sumatera",
    };

    //membuat getter untuk mengambil pertanyaan
    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getStringGambar(int x){
        String gambar = image[x];
        return gambar;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
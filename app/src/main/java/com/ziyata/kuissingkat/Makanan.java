package com.ziyata.kuissingkat;

import android.os.Parcel;
import android.os.Parcelable;

public class Makanan implements Parcelable {
    private int photo;
    private String nama;
    private String description;
    private String namaBing;
    private String sumberGambar;

    public String getSumberGambar() {
        return sumberGambar;
    }

    public void setSumberGambar(String sumberGambar) {
        this.sumberGambar = sumberGambar;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNamaMakanan_Bing() {
        return namaBing;
    }

    public void setNamaBing(String namaBing) {
        this.namaBing= namaBing;
    }


    public Makanan() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.nama);
        dest.writeString(this.description);
        dest.writeString(this.namaBing);
        dest.writeString(this.sumberGambar);
    }

    protected Makanan(Parcel in) {
        this.photo = in.readInt();
        this.nama = in.readString();
        this.description = in.readString();
        this.namaBing = in.readString();
        this.sumberGambar = in.readString();
    }

    public static final Creator<Makanan> CREATOR = new Creator<Makanan>() {
        @Override
        public Makanan createFromParcel(Parcel source) {
            return new Makanan(source);
        }

        @Override
        public Makanan[] newArray(int size) {
            return new Makanan[size];
        }
    };
}

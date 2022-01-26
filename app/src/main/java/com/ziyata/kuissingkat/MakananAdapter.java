package com.ziyata.kuissingkat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MakananAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Makanan> makanans;

    void setMakanans(ArrayList<Makanan> makanans) {
        this.makanans = makanans;
    }

    MakananAdapter(Context context) {
        this.context = context;
        makanans = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return makanans.size();
    }

    @Override
    public Object getItem(int i) {
        return makanans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_makanan_row, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Makanan makanan= (Makanan) getItem(i);
        viewHolder.bind(makanan);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtDescription = view.findViewById(R.id.txt_description);
            txtName = view.findViewById(R.id.txt_nama);

            imgPhoto = view.findViewById(R.id.img_photoo);

        }

        void bind(Makanan makanan) {
            txtDescription.setText(makanan.getDescription());
            txtName.setText(makanan.getNama());

            imgPhoto.setImageResource(makanan.getPhoto());
        }
    }
}

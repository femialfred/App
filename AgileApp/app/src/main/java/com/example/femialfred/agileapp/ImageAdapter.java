package com.example.femialfred.agileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    TextView textView;

    // Keep all Images in array
    public Integer[] mThumbIds = {R.drawable.ic_refresh,
            R.drawable.ic_bell, R.drawable.ic_connectt,
            R.drawable.ic_threedot, R.drawable.ic_gracap,R.drawable.ic_sycn,R.drawable.ic_people,R.drawable.ic_hsetting,
            R.drawable.ic_book,R.drawable.ic_message
    };
    String[] iconName = {"TỔNG QUAN VỀ AGILE", "TỔNG QUAN VỀ SCRUM", "CÁC SỰ KIỆN TRONG SCRUM", "CÁC VAI TRÒ TRONG SCRUM",
            "CÁC TẠO TÁC TRONG SCRUM","QUY TRÌNH THỰC HIỆN","KANBAN","EXTREME PROGRAMMING","LEAN SOFTWARE DEVELOPMENT",
            "CÁC KỸ THUẬT AGILE"

    };

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;

    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
//        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater in = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder view;
        if (convertView == null) {

            view = new ViewHolder();
            convertView = in.inflate(R.layout.discovery_row, null);

            view.txtView = (TextView) convertView
                    .findViewById(R.id.iconName);

            view.txtView.setText(iconName[position]);

            convertView.setTag(view);

        } else {
            view = (ViewHolder) convertView.getTag();
        }
        view.imgView = (ImageView) convertView.findViewById(R.id.iconImage);
        view.imgView.setImageResource(mThumbIds[position]);

        return convertView;
    }

    public static class ViewHolder {
        public ImageView imgView;
        public TextView txtView;
    }
}
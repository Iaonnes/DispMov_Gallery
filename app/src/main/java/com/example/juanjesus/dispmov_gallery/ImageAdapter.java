package com.example.juanjesus.dispmov_gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by JuanJesus on 03/09/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;

    public Integer[] image = new Integer[]{

            R.drawable.mavis,  R.drawable.mustang,
            R.drawable.goku,   R.drawable.dbs,
            R.drawable.cristo, R.drawable.mavis,
            R.drawable.goku,
            R.drawable.dbs,    R.drawable.cristo
    };

    public ImageAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return image[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(image[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240 ));
        return imageView;
    }
}

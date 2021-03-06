package com.iho.asu.Database;

/**
 * Created by Barathi on 10/18/2014.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iho.asu.R;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<String>{
    private final Activity context;
    private ArrayList<String> title = new ArrayList<String>();
    private ArrayList<byte[]> imageId = new ArrayList<byte[]>();
    public CustomList(Activity context,
                      ArrayList<String> title, ArrayList<byte[]> imageId) {
        super(context, R.layout.list_single, title);
        this.context = context;
        this.title = title;
        this.imageId = imageId;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(title.get(position));
        byte[] imageTile = imageId.get(position);
        Bitmap bMap = BitmapFactory.decodeByteArray(imageTile, 0, imageTile.length);
        imageView.setImageBitmap(bMap);
        return rowView;
    }
}

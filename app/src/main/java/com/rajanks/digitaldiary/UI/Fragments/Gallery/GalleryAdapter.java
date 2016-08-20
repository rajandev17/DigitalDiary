package com.rajanks.digitaldiary.UI.Fragments.Gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rajanks.digitaldiary.R;

/**
 * Created by rajan.kali on 17/08/16.
 */
public class GalleryAdapter extends ArrayAdapter<String> {
    LayoutInflater inflater;
    String[] images;
    Context context;
    ViewHolder viewHolder;
    View view;

    public GalleryAdapter(Context context, String[] values) {
        super(context, R.layout.gallery_item,values);
        images = values;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    class ViewHolder {
        ImageView imageView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.gallery_item,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.image_gallery);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(images[position]).into(viewHolder.imageView);
        return view;
    }
}
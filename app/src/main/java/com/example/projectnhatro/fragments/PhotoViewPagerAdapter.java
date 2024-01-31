package com.example.projectnhatro.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.projectnhatro.R;

import java.util.List;

public class PhotoViewPagerAdapter extends PagerAdapter {

    private List<Photo> ListPhoto;

    public PhotoViewPagerAdapter(List<Photo> listPhoto) {
        ListPhoto = listPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo, container, false);
        ImageView imgPhoto = view.findViewById(R.id.img_photo);

        Photo photo = ListPhoto.get(position);
        imgPhoto.setImageResource(photo.getResourceId());

        //add view

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {

        if (ListPhoto != null){
            return ListPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

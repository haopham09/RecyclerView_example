package com.thohao.recyclerview_baitap;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ImageSliderApdater extends PagerAdapter {
    Context context;

    public ImageSliderApdater(Context context) {
        this.context = context;
    }
    private int [] arrSliderImage=new int[]{
            R.drawable.buzza_pizza,
            R.drawable.hanuri,
            R.drawable.morio,
            R.drawable.san_fu_lou
    };

    @Override
    public int getCount() {
        return arrSliderImage.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((ImageView)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView=new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(arrSliderImage[position]);
        ((ViewPager)container).addView(imageView,0);


        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ((ViewPager)container).removeView((ImageView)object);
    }
    void initSlider(){
        for (int i=0;i<arrSliderImage.length;i++){
            arrSliderImage[i]=arrSliderImage[i+1];
        }

    }
}

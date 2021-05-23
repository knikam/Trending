package com.xscalate.trending.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.xscalate.trending.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }
    //image array
    public int[] slide_image={
            R.drawable.ic_movie_icon,
            R.drawable.ic_tv_show,
            R.drawable.ic_people_icon
    };
    //header array
    public String[] slide_header={

            "MOVIES",
            "TV SHOW",
            "PERSON"
    };

    //content
    public String[] slide_content= {

            "See all top trending movie information and viewer ratings in one app.",
            "Get Information of trending Tv shows in all languages with ratings of show.",
            "All information about worlds famous faces trending on internet in app."
    };


    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(LinearLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.layout_slider_view, container,false);

        ImageView imageView=(ImageView)view.findViewById(R.id.slider_image_icon);
        TextView textView=(TextView)view.findViewById(R.id.slider_txv_title);
        TextView textView1=(TextView)view.findViewById(R.id.slider_txv_description);   //set contact with layout


        imageView.setImageResource(slide_image[position]);
        textView.setText(slide_header[position]);
        textView1.setText(slide_content[position]);


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
package com.xscalate.trending.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xscalate.trending.R;
import com.xscalate.trending.util.SliderAdapter;

public class SliderScreen extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private SliderAdapter sliderAdapter;

    private TextView[] mdot;
    private int item;

    private TextView finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_screen);
        getSupportActionBar().hide();

        viewPager = findViewById(R.id.slider_view_viewpage);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(ViewListener);

        linearLayout = findViewById(R.id.slider_layout_linearlayout);
        finish =findViewById(R.id.slider_txv_finish);

        dots(0);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomeScreen.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    public void dots(int position) {
        mdot = new TextView[3];
        linearLayout.removeAllViews();
        for (int i = 0; i < mdot.length; i++) {
            mdot[i] = new TextView(this);
            mdot[i].setText(Html.fromHtml("&#8226;"));
            mdot[i].setTextSize(35);
            mdot[i].setTextColor(getResources().getColor(R.color.white));

            linearLayout.addView(mdot[i]);

        }
        if (mdot.length > 0) {
            mdot[position].setTextColor(getResources().getColor(R.color.red));
        }
    }

    ViewPager.OnPageChangeListener ViewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            dots(i);

            item=i;
            if(item==mdot.length-1){
                finish.setVisibility(View.VISIBLE);
            }
            else {
               finish.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }
}
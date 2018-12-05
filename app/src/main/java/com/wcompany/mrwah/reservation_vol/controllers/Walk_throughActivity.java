package com.wcompany.mrwah.reservation_vol.controllers;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.adapters.SliderAdapter;

public class Walk_throughActivity extends AppCompatActivity {

    private ViewPager w_viewPager ;
    private LinearLayout w_dots;
    private TextView[] mDots;
    private Button demarrer;
    private SliderAdapter sliderAdapter;
    private Intent login_itnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through);  w_viewPager=findViewById(R.id.slideView_layout);
        w_dots=findViewById(R.id.dots_layout);
        demarrer=findViewById(R.id.demarrer_btn);
        sliderAdapter= new SliderAdapter(this);
        w_viewPager.setAdapter(sliderAdapter);
        addDotIndicator(0);
        login_itnt =new Intent(this,login_activity.class);
        w_viewPager.addOnPageChangeListener(viewListener);
        demarrer.setOnClickListener(demarrer_listener);
    }
    public void addDotIndicator(int position)
    {
        mDots=new TextView[2];
        w_dots.removeAllViews();
        for (int i=0;i< mDots.length;i++)
        {
            mDots[i]= new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(40);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            w_dots.addView(mDots[i]);
        }
        if (mDots.length > 0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    View.OnClickListener demarrer_listener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            startActivity(login_itnt);
        }
    };
}

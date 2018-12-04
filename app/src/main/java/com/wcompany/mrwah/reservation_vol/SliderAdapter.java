package com.wcompany.mrwah.reservation_vol;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter  extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context)
    {
        this.context= context;
    }
    public int[] slide_images={
            R.drawable.ill_1xxxhdpi,
            R.drawable.ill_2xxxhdpi

    };
    public String[] slide_descriptions={
            "Voyager plus, Payer moins! \n Trouver les offres qui vous convient",
            "Planifier votre voyage\n Plusieurs destinations chaque jour!"
    };
    @Override
    public int getCount() {
        return slide_descriptions.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view== (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView sliderDescription = (TextView) view.findViewById(R.id.slide_desc_text);

        slideImageView.setImageResource(slide_images[position]);
        sliderDescription.setText(slide_descriptions[position]);

        container.addView(view);
        return view;
    };

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}

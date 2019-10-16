package com.example.sagarunnati.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.example.sagarunnati.R;
import com.example.sagarunnati.appliaction.MyApplication;

public class ImageAdapter extends PagerAdapter {
    private static final String TAG = MyApplication.TAG + ImageAdapter.class.getSimpleName();


    Context mContext;


    private int[] sliderColorId = new int[]{R.color.colorPrimary, R.color.colorPrimaryDark};
    private int[] sliderImageId = new int[]{R.drawable.slider1_new, R.drawable.slider2_new,
            R.drawable.gallery_1, R.drawable.gallery_2, R.drawable.gallery_3};

    public ImageAdapter(Context context) {
        this.mContext = context;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
//        return view == ((ImageView) object);
        return view == ((View) object);
//        return view == (object);
    }

//    private int[] sliderImageId = new int[]{R.drawable.slider1, R.drawable.slider2};

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View layout = (ViewGroup) inflater.inflate(R.layout.content_iamge_adapter, container, false);
        container.addView(layout);
//        TextView textView = layout.findViewById(R.id.tvSplash);
        ImageView imageView = layout.findViewById(R.id.ivContentImageAdapter);
        imageView.setImageResource(sliderImageId[position]);

        return layout;
        /*ImageView imageView = new ImageView(mContext);


        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setAdjustViewBounds(true);
        imageView.setImageResource(sliderImageId[position]);*/
       /* ((ViewPager) container).addView(imageView, 0);
        return imageView;*/
//        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public int getCount() {
        return sliderImageId.length;

    }
}

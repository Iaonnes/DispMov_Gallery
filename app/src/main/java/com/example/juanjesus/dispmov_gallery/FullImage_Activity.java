package com.example.juanjesus.dispmov_gallery;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class FullImage_Activity extends AppCompatActivity {

    ImageView imageView;
    Matrix matrix = new Matrix();
    float mMinZoom = 1.f;
    float mMaxZoom = 5.f;
    float mScaleFactor = 2.f;
    private ScaleGestureDetector SGD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter(this);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(adapter.image[position]);
        SGD = new ScaleGestureDetector(this,new ScaleListener());
        //imageView.onTouchEvent(AXIS_SIZE,mMinZoom,mMaxZoom);

        
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        SGD.onTouchEvent(event);

        return true;
    }
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {


            mScaleFactor *= detector.getScaleFactor();
            mScaleFactor = Math.max(mMinZoom, Math.min(mMaxZoom, mScaleFactor));
            imageView.invalidate();
            matrix.setScale(mScaleFactor,mScaleFactor);
            imageView.requestLayout();
            return super.onScale(detector);
        }

    }
}

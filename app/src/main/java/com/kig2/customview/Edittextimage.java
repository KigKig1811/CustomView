package com.kig2.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Edittextimage extends RelativeLayout {
    private TextView mTitle;
    private ImageView mImg;
    private EditText mEdt;

    private String mTextTitle;
    private Integer mTextSize;
    private Integer mSrcImage;
    private View v;


    public Edittextimage(Context context) {
        super(context);

    }

    public Edittextimage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public Edittextimage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context,AttributeSet attributeSet){
        if(context != null && attributeSet != null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view =  layoutInflater.inflate(R.layout.layout_edittext_circle,this,true);
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.Edittextimage);
            mTextTitle = typedArray.getString(R.styleable.Edittextimage_title);
            mTextSize = typedArray.getInteger(R.styleable.Edittextimage_titleSize,0);
            mSrcImage = typedArray.getResourceId(R.styleable.Edittextimage_srcImage,R.mipmap.ic_launcher);

            typedArray.recycle();


            initView(v);
            mapView();

        }
    }

    private void initView(View v) {
        mEdt = v.findViewById(R.id.edittext);
        mImg = v.findViewById(R.id.iv);
        mTitle = v.findViewById(R.id.tvTitle);
    }
    private  void mapView(){
        mTitle.setText(mTextTitle);
        mTitle.setTextSize((float) mTextSize);
        mImg.setImageResource(mSrcImage);
    }
}

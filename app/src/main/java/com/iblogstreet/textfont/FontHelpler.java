package com.iblogstreet.textfont;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 *  @项目名：  TextFont 
 *  @包名：    com.iblogstreet.textfont
 *  @文件名:   FontHelpler
 *  @创建者:   Army
 *  @创建时间:  2016/9/17 8:16
 *  @描述：    字体帮助类
 */
public class FontHelpler {
    private static final String TAG = "FontHelpler";

    public static final String FONTS_DIR="fonts/";
    public static final String DEF_FONT=FONTS_DIR+ "fontawesome-webfont.ttf";
    public static final void injectFont(View rootView){
        injectFont(rootView,Typeface.createFromAsset(rootView.getContext().getAssets(),DEF_FONT));
    }
    public static  void injectFont(View rootView, Typeface tf){
        if(rootView instanceof ViewGroup){
            ViewGroup group=(ViewGroup)rootView;
            int count=group.getChildCount();
            for(int i=0;i<count;i++){
                injectFont(group.getChildAt(i),tf);
            }
        }else if(rootView instanceof TextView){
            ((TextView)rootView).setTypeface(tf);
        }
    }
}

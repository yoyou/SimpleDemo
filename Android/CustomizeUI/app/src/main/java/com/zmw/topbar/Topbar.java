package com.zmw.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zmw.customizeui.R;

/**
 * Created by zmw on 16-11-12.
 */

public class Topbar extends RelativeLayout {
    private Button rightbutton;
    private Button leftbutton;
    private TextView title;

    private int rightbuttontextcolor;
    private Drawable rightbuttonbackground;
    private String rightbuttonstring;

    private int leftbuttontextcolor;
    private Drawable leftbuttonbackground;
    private String leftbuttonstring;

    private float titletextsize;
    private int titiletextcolor;
    private String titletextstring;

    private  LayoutParams rightparams,leftparams,titleparams;

    private Topbarlisten topbarlisten;

    public interface Topbarlisten{
        public void left();
        public void right();
    }

    public void setTopbarlisten(Topbarlisten topbarlisten){
        this.topbarlisten = topbarlisten;
    }

    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray tp = context.obtainStyledAttributes(attrs, R.styleable.Topbar);

        rightbutton = new Button(context);
        leftbutton = new Button(context);
        title = new TextView(context);

        rightbuttontextcolor = tp.getColor(R.styleable.Topbar_rightbuttontextcolor,0);
        rightbuttonbackground = tp.getDrawable(R.styleable.Topbar_rightbuttonbackgroud);
        rightbuttonstring = tp.getString(R.styleable.Topbar_rightbuttontext);

        leftbuttontextcolor = tp.getColor(R.styleable.Topbar_leftbuttontextcolor,0);
        leftbuttonbackground = tp.getDrawable(R.styleable.Topbar_leftbuttonbackgroud);
        leftbuttonstring = tp.getString(R.styleable.Topbar_leftbuttontext);

        titiletextcolor = tp.getColor(R.styleable.Topbar_titletextcolor,0);
        titletextsize = tp.getDimension(R.styleable.Topbar_titletextsize,0);
        titletextstring = tp.getString(R.styleable.Topbar_titletext);

        tp.recycle();

        rightbutton.setTextColor(rightbuttontextcolor);
        rightbutton.setBackground(rightbuttonbackground);
        rightbutton.setText(rightbuttonstring);

        leftbutton.setTextColor(leftbuttontextcolor);
        leftbutton.setBackground(leftbuttonbackground);
        leftbutton.setText(leftbuttonstring);

        title.setText(titletextstring);
        title.setTextColor(titiletextcolor);
        title.setTextSize(titletextsize);
        title.setGravity(Gravity.CENTER);

        setBackgroundColor(0xfff59563);

        rightparams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        rightparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        leftparams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        leftparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        titleparams = new LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        titleparams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        addView(rightbutton,rightparams);
        addView(leftbutton, leftparams);
        addView(title,titleparams);

        rightbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                topbarlisten.right();
            }
        });
        leftbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                topbarlisten.left();
            }
        });
    }
}

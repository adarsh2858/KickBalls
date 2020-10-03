package com.example.kickballs.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {

    private static final int SQUARE_SIZE = 1000;

    private Rect mRectSquare;
    private Paint mPaintSquare;
    private Paint mPaintCircle1;
    private Paint mPaintCircle2;
    private Paint mPaintCircle3;
    private Paint mPaintCircle4;
    private Paint mPaintCircle5;
    private Paint mPaintCircle6;
    private Paint mPaintCircle7;
    private Paint mPaintCircle8;
    private Paint mPaintCircle9;

    public CustomView(Context context) {
        super(context);

        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

//    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//
//        init(attrs);
//    }

    private void init(@Nullable AttributeSet set){
//        mRectSquare = new Rect();
//        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mPaintSquare.setColor(Color.GREEN);
        mPaintCircle1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle5 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle6 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle7 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle8 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle9 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle1.setColor(Color.GREEN);
        mPaintCircle2.setColor(Color.GREEN);
        mPaintCircle3.setColor(Color.GREEN);
        mPaintCircle4.setColor(Color.GREEN);
        mPaintCircle5.setColor(Color.GREEN);
        mPaintCircle6.setColor(Color.GREEN);
        mPaintCircle7.setColor(Color.GREEN);
        mPaintCircle8.setColor(Color.GREEN);
        mPaintCircle9.setColor(Color.GREEN);
    }

    public void swapColor(){
//        mPaintSquare.setColor(mPaintSquare.getColor() == Color.GREEN? Color.RED : Color.GREEN);

        double randomNumber = Math.random() * 9;
        Paint mPaintCircles[] = {mPaintCircle1,mPaintCircle2,mPaintCircle3,mPaintCircle4,mPaintCircle5,mPaintCircle6,mPaintCircle7,mPaintCircle8,mPaintCircle9};
        int i=(int)(Math.random()*8);
        mPaintCircles[i].setColor(mPaintCircles[0].getColor() == Color.GREEN? Color.RED : Color.GREEN);
        mPaintCircles[i].setColor(mPaintCircles[0].getColor() == Color.GREEN? Color.RED : Color.GREEN);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        canvas.drawCircle(200, 200, 100, mPaintCircle1);
        canvas.drawCircle(500, 200, 100, mPaintCircle2);
        canvas.drawCircle(800, 200, 100, mPaintCircle3);
        canvas.drawCircle(200, 500, 100, mPaintCircle4);
        canvas.drawCircle(500, 500, 100, mPaintCircle5);
        canvas.drawCircle(800, 500, 100, mPaintCircle6);
        canvas.drawCircle(200, 800, 100, mPaintCircle7);
        canvas.drawCircle(500, 800, 100, mPaintCircle8);
        canvas.drawCircle(800, 800, 100, mPaintCircle9);
//        mRectSquare.left = 30;
//        mRectSquare.top = 30;
//        mRectSquare.right = mRectSquare.left + SQUARE_SIZE;
//        mRectSquare.bottom = mRectSquare.top + SQUARE_SIZE;

//        canvas.drawRect(mRectSquare, mPaintSquare);
    }
}

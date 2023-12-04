package com.software.RecommendPage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FixRecyclerView extends androidx.recyclerview.widget.RecyclerView {
    private int startX,startY,endX,endY,disX,disY;

    public FixRecyclerView(@NonNull Context context) {
        super(context);
    }

    public FixRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FixRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch(ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = (int) ev.getX();
                startY = (int) ev.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                endX = (int) ev.getX();
                endY = (int) ev.getY();
                disX = Math.abs(endX-startX);
                disY = Math.abs(endY-startY);
                if(disX > disY){
                    getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(startX -endX));
                }else {
                    getParent().requestDisallowInterceptTouchEvent(canScrollHorizontally(startY -endY));
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;

        }
        return super.dispatchTouchEvent(ev);
    }
}

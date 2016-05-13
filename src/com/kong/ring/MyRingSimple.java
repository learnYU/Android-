package com.kong.ring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class MyRingSimple extends View{

	/**
	 * 圆心的X坐标
	 */
	private float cx;
	/**
	 * 圆心的Y坐标
	 */
	private float cy;
	/**
	 * 圆环半径
	 */
	private float radius = 0;
	/**
	 * 默认画笔
	 */
	private Paint paint;
	protected boolean isRunning = false;
	private Paint lPaint;


	public MyRingSimple(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}
	
	private void initView() {
		radius = 50;
		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(radius/4);
		paint.setColor(Color.GREEN);
		paint.setAlpha(255);
		
		lPaint = new Paint();
		lPaint.setAntiAlias(true);
		lPaint.setStyle(Style.STROKE);
		lPaint.setColor(Color.GREEN);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(200, 200);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		if(changed){
			cx = getWidth()/2;
			cy = getHeight()/2;
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		for (int i = 10; i < getWidth(); i=i+20) {
			canvas.drawLine(0, i, getWidth(), i, lPaint);
			canvas.drawLine(i, 0, i,getHeight(), lPaint);
		}
		
		paint.setColor(Color.GREEN);
		
		canvas.translate(-20, -20);
		canvas.drawCircle(cx, cy, radius, paint);
	}
}

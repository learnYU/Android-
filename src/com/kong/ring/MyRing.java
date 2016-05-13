package com.kong.ring;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyRing extends View{

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


	public MyRing(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}
	
	private void initView() {
		radius = 0;
		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(radius/4);
		paint.setColor(Color.GREEN);
		paint.setAlpha(255);
		
	}
	
	/**
	 * 执行动画
	 */
	private void startAnim() {
		isRunning = true;
		handler.sendEmptyMessageDelayed(0, 50);
	}
	
	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
//		startAnim() ;
	}
	
	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		isRunning = false;
	}
	
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {

			// 设置透明
			int alpha = paint.getAlpha();
			if (alpha == 0) {
				isRunning = false;
			}

//			alpha -= 10;
//
//			if (alpha <= 10) {
//				alpha = 0;
//			}
			
			alpha = Math.max(0, alpha-10);

			paint.setAlpha(alpha);

			Log.i("leo", "" + alpha);

			// 设置半径
			radius += 5;
			paint.setStrokeWidth(radius / 3);

			invalidate();

			if (isRunning) {
				handler.sendEmptyMessageDelayed(0, 50);
			}

		};
	};
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//		setMeasuredDimension(200, 200);
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
		canvas.drawCircle(cx, cy, radius, paint);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		super.onTouchEvent(event);
		
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			cx = event.getX();
			cy = event.getY();
			initView();
			startAnim();
			
		}
		return true; 
		
	}
	
}

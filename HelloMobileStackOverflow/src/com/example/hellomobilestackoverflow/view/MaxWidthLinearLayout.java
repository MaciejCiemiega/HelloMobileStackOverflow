package com.example.hellomobilestackoverflow.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.hellomobilestackoverflow.R;

/**
 * Simple implementation of {@link LinearLayout} that will be not wider that value specified in {@link android.R.attr.maxWidth} XML attribute.
 * @author Maciej
 */
public class MaxWidthLinearLayout extends LinearLayout {

	private int maxWidth = -1;
	
	public MaxWidthLinearLayout(Context context) {
		super(context);
		init(null);
	}
	
	public MaxWidthLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public MaxWidthLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	private void init(AttributeSet attrs) {
		if(attrs != null) {
			final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MaxWidthLinearLayout);
			maxWidth = a.getDimensionPixelSize(R.styleable.MaxWidthLinearLayout_android_maxWidth, -1);
			a.recycle();
		}
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (maxWidth >= 0) {
			final int size = MeasureSpec.getSize(widthMeasureSpec);
			final int mode = MeasureSpec.getMode(widthMeasureSpec);
			if (mode == MeasureSpec.EXACTLY) {
				widthMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(maxWidth, size), mode);
			} else {
				super.onMeasure(widthMeasureSpec, heightMeasureSpec);
				widthMeasureSpec = MeasureSpec.makeMeasureSpec(Math.min(maxWidth, getMeasuredWidth()), MeasureSpec.EXACTLY);			
			}
		}
	    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
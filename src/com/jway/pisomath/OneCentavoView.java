package com.jway.pisomath;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class OneCentavoView extends CoinView {
	
	public OneCentavoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setAmount(0.01);
	}
	
}

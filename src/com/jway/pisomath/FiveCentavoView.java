package com.jway.pisomath;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class FiveCentavoView extends CoinView {
	
	public FiveCentavoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setAmount(0.05);
	}
	
}

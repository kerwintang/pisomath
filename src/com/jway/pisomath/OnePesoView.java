package com.jway.pisomath;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class OnePesoView extends CoinView {
	
	public OnePesoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setAmount(1.00);
	}
	
}

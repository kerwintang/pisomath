package com.jway.pisomath;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TenPesoView extends CoinView {
	
	public TenPesoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setAmount(10.00);
	}
	
}

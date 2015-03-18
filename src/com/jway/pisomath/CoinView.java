package com.jway.pisomath;

import java.math.BigDecimal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CoinView extends ImageView {
	
	private BigDecimal amount;
    
	public CoinView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public BigDecimal getAmount(){
		return this.amount;
	}
	
	public void setAmount(BigDecimal amount){
		this.amount = amount;
	}

	public void setAmount(Double amount){
		this.amount = BigDecimal.valueOf(amount);
	}
}

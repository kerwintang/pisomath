package com.jway.pisomath;

import java.math.BigDecimal;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QuizActivity extends Activity {
	
	private BigDecimal randomAmount = BigDecimal.valueOf(0.0);
	private BigDecimal totalAmount = BigDecimal.valueOf(0.0);
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        generateRandomAmount();
		((TextView)findViewById(R.id.totalAmountView)).setText("Put "+randomAmount+" pesos on the table.");
		setListeners(getBaseContext());		// sets the click listeners
    }
	
	private void generateRandomAmount(){
		randomAmount = BigDecimal.valueOf(Double.valueOf(Math.round(Math.random()*5000))/100);
	}
    

	//============================ LISTENERS ==============================================
	// Listeners acts upon certain events specified on the application.
	//=====================================================================================
	
	public void setListeners(Context cxt){
		findViewById(R.id.oneCentavoView).setOnTouchListener(new CoinTouchListener());
		findViewById(R.id.fiveCentavoView).setOnTouchListener(new CoinTouchListener());
		findViewById(R.id.tenCentavoView).setOnTouchListener(new CoinTouchListener());
		findViewById(R.id.twentyFiveCentavoView).setOnTouchListener(new CoinTouchListener());
		findViewById(R.id.pisoView).setOnTouchListener(new CoinTouchListener());
		findViewById(R.id.fivePesoView).setOnTouchListener(new CoinTouchListener());
		findViewById(R.id.tenPesoView).setOnTouchListener(new CoinTouchListener());
		findViewById(R.id.dropLayout).setOnDragListener(new CoinDropListener());
		findViewById(R.id.submitButton).setOnClickListener(new SubmitClickListener());
	}

    // This defines your touch listener
    private final class CoinTouchListener implements OnTouchListener {
      public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
          ClipData data = ClipData.newPlainText("", "");
          DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
          view.startDrag(data, shadowBuilder, view, 0);
//          view.setVisibility(View.INVISIBLE);
          return true;
        } else {
        return false;
        }
      }
    } 

    private class CoinDropListener implements OnDragListener {
    	  
    	  @Override
    	  public boolean onDrag(View v, DragEvent event) {
    	    int action = event.getAction();
    	    switch (event.getAction()) {
    	    case DragEvent.ACTION_DRAG_STARTED:
    	    // do nothing
    	      break;
    	    case DragEvent.ACTION_DRAG_ENTERED:
    	      break;
    	    case DragEvent.ACTION_DRAG_EXITED:        
    	      break;
    	    case DragEvent.ACTION_DROP:
    	      // Dropped, reassign View to ViewGroup
    	      View view = (View) event.getLocalState();
    	      LayoutInflater vi = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	      View newView = view;
    	      switch (view.getId()) {
    	      case R.id.oneCentavoView:
    	    	  newView = vi.inflate((Integer)R.layout.one_centavo, null);
    	    	  break;
    	      case R.id.fiveCentavoView:
    	    	  newView = vi.inflate((Integer)R.layout.five_centavo, null);
    	    	  break;
    	      case R.id.tenCentavoView:
    	    	  newView = vi.inflate((Integer)R.layout.ten_centavo, null);
    	    	  break;
    	      case R.id.twentyFiveCentavoView:
    	    	  newView = vi.inflate((Integer)R.layout.twenty_five_centavo, null);
    	    	  break;
    	      case R.id.pisoView:
    	    	  newView = vi.inflate((Integer)R.layout.one_peso, null);
    	    	  break;
    	      case R.id.fivePesoView:
    	    	  newView = vi.inflate((Integer)R.layout.five_peso, null);
    	    	  break;
    	      case R.id.tenPesoView:
    	    	  newView = vi.inflate((Integer)R.layout.ten_peso, null);
    	    	  break;
    	      }
    	      
    	      totalAmount = totalAmount.add(((CoinView)newView).getAmount());
//    	      TextView totalAmountView = (TextView)findViewById(R.id.totalAmountView);
//    	      totalAmountView.setText("Total Amount: "+totalAmount.toString());
    	      RelativeLayout container = (RelativeLayout) v;
    	      RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(50, 50);
    	      params.leftMargin = (int) event.getX();
    	      params.topMargin = (int) event.getY();
    	      container.addView(newView, params);
    	      break;
    	    case DragEvent.ACTION_DRAG_ENDED:
    	      default:
    	      break;
    	    }
    	    return true;
    	  }
    	} 
//    // Create and set the drag event listener for the View
//    private final class CoinDragListener implements OnDragListener {
//       @Override
//       public boolean onDrag(View v,  DragEvent event){
//       switch(event.getAction())                   
//       {
//          case DragEvent.ACTION_DRAG_STARTED:
//             layoutParams = (RelativeLayout.LayoutParams) 
//             v.getLayoutParams();
//             // Do nothing
//             break;
//          case DragEvent.ACTION_DRAG_ENTERED:
//             int x_cord = (int) event.getX();
//             int y_cord = (int) event.getY();  
//             break;
//          case DragEvent.ACTION_DRAG_EXITED :
//             x_cord = (int) event.getX();
//             y_cord = (int) event.getY();
//             layoutParams.leftMargin = x_cord;
//             layoutParams.topMargin = y_cord;
//             v.setLayoutParams(layoutParams);
//             break;
//          case DragEvent.ACTION_DRAG_LOCATION  :
//             x_cord = (int) event.getX();
//             y_cord = (int) event.getY();
//             break;
//          case DragEvent.ACTION_DRAG_ENDED   :
//             // Do nothing
//             break;
//          case DragEvent.ACTION_DROP:
//             // Do nothing
//             break;
//          default: break;
//          }
//          return true;
//       }
//    }

    // This defines your touch listener
    private final class SubmitClickListener implements OnClickListener {
		@Override
		public void onClick(View view) {
        	if(randomAmount.equals(totalAmount)){
        		((TextView)findViewById(R.id.totalAmountView)).setText("Correct!");
        	}else{
        		((TextView)findViewById(R.id.totalAmountView)).setText("Wrong! Try again. Put "+randomAmount+" pesos on the table.");
        	}
		}
    } 

}

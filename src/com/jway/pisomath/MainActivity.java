package com.jway.pisomath;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private ImageView image1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		setListeners(getBaseContext());		// sets the click listeners

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	//============================ LISTENERS ==============================================
	// Listeners acts upon certain events specified on the application.
	//=====================================================================================
	
	public void setListeners(Context cxt){
		
	//	---------------- Play Button --------------------
		ImageView play = (ImageView)findViewById(R.id.background);
		play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
            	Intent intent = new Intent(view.getContext(), PlayActivity.class);
				startActivity(intent);
			}
		});

/*		ImageView quiz = (ImageView)findViewById(R.id.ImageView01);
		quiz.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
            	Intent intent = new Intent(view.getContext(), QuizActivity.class);
				startActivity(intent);
			}
		});*/
}
}

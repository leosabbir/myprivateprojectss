package com.hogwart.grewordlist;

import com.hogwart.grewordlist.constants.WordListConstants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int homeView = R.layout.wordlistselection;
        setContentView(homeView);
        
        View view = findViewById(R.id.listBtnsContainer);
        LinearLayout listBtnsContainer = (LinearLayout) view;
        
        final int noOfLists = ClientWordListLoader.getNumberOfWordList(this, 1);
        
        for( int i = 0; i < noOfLists ; i++){
        	Button btn = new Button(this);
        	btn.setText("List " + (i+1));
        	final int list = i+1;
        	btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View view) {
					Bundle bundle = new Bundle();
					bundle.putInt(WordListConstants.LIST_INDEX, list);
					if( list == noOfLists ){
						bundle.putBoolean(WordListConstants.LAST_LIST_INDICATOR, true);
					}else{
						bundle.putBoolean(WordListConstants.LAST_LIST_INDICATOR, false);
					}
					
					Intent intent = new Intent(view.getContext(), WordListActivity.class);
					intent.putExtras(bundle);
					
					startActivity(intent);
					
				}
			});
        	
        	listBtnsContainer.addView(btn);
        }
	}

}

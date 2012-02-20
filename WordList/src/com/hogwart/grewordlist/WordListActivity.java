package com.hogwart.grewordlist;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hogwart.grewordlist.constants.WordListConstants;

public class WordListActivity extends Activity {
    
	List<String> wordList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    	
        int list = getIntent().getIntExtra(WordListConstants.LIST_INDEX	, 1);
        boolean lastListIndicator = getIntent().getBooleanExtra(WordListConstants.LAST_LIST_INDICATOR, true);
        wordList = ClientWordListLoader.getWordList(list, lastListIndicator);
    	final List<String> temporaryList = wordList;
        
        View view = findViewById(R.id.textView1);
        final TextView txt = (TextView) view;
        
        if( !wordList.isEmpty() ){
        	txt.setText(temporaryList.get(0));
        	temporaryList.remove(0);
        }
        
        view = findViewById(R.id.button1);
        Button nextBtn = (Button) view;
        nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	int size = temporaryList.size();
            	
            	if(size == 0){
            		startActivity(new Intent(view.getContext(), HomeActivity.class));
            	}else{
            		int i = (int) ( Math.random() * size);
            		txt.setText(temporaryList.get(i));
            		temporaryList.remove(i);
            	}
            }

        });
       
        
        
    }
}
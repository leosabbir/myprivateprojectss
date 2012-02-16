package com.hogwart.grewordlist;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hogwart.grewordlist.adapter.WordListAdapter;
import com.hogwart.grewordlist.adapter.impl.WordListAdapterImpl;
import com.hogwart.grewordlist.api.WordsLoader;
import com.hogwart.grewordlist.api.impl.WordsLoaderImpl;

public class WordListActivity extends Activity {
    
	private final WordListAdapter adapter = new WordListAdapterImpl();
	private WordsLoader loader;
	List<String> wordList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        loader = new WordsLoaderImpl(adapter);
    	wordList = loader.getWordList(this, 1);
    	
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
            	int i = (int) ( Math.random() * temporaryList.size());
            	txt.setText(temporaryList.get(i));
            	temporaryList.remove(i);                
            }

        });
       
        
        
    }
}
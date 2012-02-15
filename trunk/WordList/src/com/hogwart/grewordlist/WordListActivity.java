package com.hogwart.grewordlist;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        
        loader = new WordsLoaderImpl(adapter);
    	wordList = loader.getWordList(this, 1);
        
        View view = findViewById(R.id.editText1);
        EditText txt = (EditText) view;
       
        if( !wordList.isEmpty() ){
        	txt.setText(wordList.get(0));
        }
        
        setContentView(R.layout.main);
    }
}
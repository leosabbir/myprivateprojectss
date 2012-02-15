package com.hogwart.grewordlist;

import java.util.List;

import com.hogwart.grewordlist.adapter.WordListAdapter;
import com.hogwart.grewordlist.adapter.impl.WordListAdapterImpl;
import com.hogwart.grewordlist.api.WordsLoader;
import com.hogwart.grewordlist.api.impl.WordsLoaderImpl;

import android.app.Activity;
import android.os.Bundle;

public class WordListActivity extends Activity {
    
	private final WordListAdapter adapter = new WordListAdapterImpl();
	private final WordsLoader loader = new WordsLoaderImpl(adapter);
	List<String> wordList = loader.getWordList(1);
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
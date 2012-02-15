package com.hogwart.grewordlist.api.impl;

import java.util.List;

import android.content.Context;

import com.hogwart.grewordlist.adapter.WordListAdapter;
import com.hogwart.grewordlist.api.WordsLoader;

public class WordsLoaderImpl implements WordsLoader {
	
	private final WordListAdapter wordListAdapter;
	
	public WordsLoaderImpl(WordListAdapter wordListAdapter) {
		this.wordListAdapter  = wordListAdapter;
	}

	@Override
	public List<String> getWordList(Context context, int list) {
		return wordListAdapter.getWordList(context, list);
	}

}

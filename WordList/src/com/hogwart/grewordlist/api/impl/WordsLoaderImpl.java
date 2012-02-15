package com.hogwart.grewordlist.api.impl;

import java.util.List;

import com.hogwart.grewordlist.adapter.WordListAdapter;
import com.hogwart.grewordlist.api.WordsLoader;

public class WordsLoaderImpl implements WordsLoader {
	
	private final WordListAdapter wordListAdapter;
	
	public WordsLoaderImpl(WordListAdapter wordListAdapter) {
		this.wordListAdapter  = wordListAdapter;
	}

	@Override
	public List<String> getWordList(int list) {
		return wordListAdapter.getWordList(list);
	}

}

package com.hogwart.grewordlist.adapter;

import java.util.List;

import android.content.Context;

public interface WordListAdapter {
	
	List<String> getWordList(Context context, int list);
}

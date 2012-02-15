package com.hogwart.grewordlist.api;

import java.util.List;

import android.content.Context;

public interface WordsLoader {
	
	List<String> getWordList(Context context, int list);

}

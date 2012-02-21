package com.hogwart.grewordlist;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.hogwart.grewordlist.adapter.WordListAdapter;
import com.hogwart.grewordlist.adapter.impl.WordListAdapterImpl;
import com.hogwart.grewordlist.api.WordsLoader;
import com.hogwart.grewordlist.api.impl.WordsLoaderImpl;

public class ClientWordListLoader {
	private static final int LIST_SIZE = 50;
	private static final WordListAdapter adapter = new WordListAdapterImpl();
	private static WordsLoader loader = new  WordsLoaderImpl(adapter);
	private static List<String> allWordList = new ArrayList<String>();
	private static Integer noOfLists;
	
	public static int getNumberOfWordList(Context context, int list){
		if( noOfLists == null){
			allWordList = loader.getWordList(context, list);
			noOfLists = allWordList.size() % LIST_SIZE == 0 ? allWordList.size() / LIST_SIZE : allWordList.size() / LIST_SIZE + 1;
		}
		
		return noOfLists;
	}
	
	public static List<String> getWordList(int list, boolean lastListIndicator){
		int start;
		int end;
		
		if(lastListIndicator){
			if(list == 1){
				start = 0;
				end = allWordList.size() - 1;
			}else {
				start = (list - 1) * LIST_SIZE + 1;
				end = (list - 1) * LIST_SIZE + allWordList.size() % LIST_SIZE;
			}
		}else{
			if(list == 1){
				start = 0;
				end = LIST_SIZE;
			}else {
				start = (list - 1) * LIST_SIZE + 1;
				end = list * LIST_SIZE;
			}
		}
		
		return allWordList.subList(start, end);
	}
	
	public static List<String> getAllWordsList(){
		return allWordList;
	}

}

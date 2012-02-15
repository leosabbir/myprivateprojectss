package com.hogwart.grewordlist.adapter.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.hogwart.grewordlist.R;
import com.hogwart.grewordlist.adapter.WordListAdapter;

public class WordListAdapterImpl implements WordListAdapter {
	
	private final String FILE_NAME_PREFIX = "wordlist_";
	private final String FILE_NAME_POSTFIX = ".list";
	
	private File wordListFile;
	List<String> wordList;

	@Override
	public List<String> getWordList(Context context, int list) {
		this.loadWordList(context, list);
		return this.wordList;
	}
	
	private void loadWordListFile(int list){
		//this.wordListFile = new File(FILE_NAME_PREFIX + list + FILE_NAME_POSTFIX);
		this.wordListFile = new File("wordlist.list");
	}
	
	private void loadWordList(Context context, int list){
		this.wordList = new ArrayList<String>();
		this.loadWordListFile(list);
		
		InputStream wordListFileStream = context.getResources().openRawResource(R.raw.wordlist_1);
				
		BufferedReader fileReader = new BufferedReader( new InputStreamReader(wordListFileStream));
		
		try{
			String word = fileReader.readLine();
			while( word != null ){
				this.wordList.add(word);
				word = fileReader.readLine();
			}
		}catch(IOException e){
			System.out.println("File could not be read");
		}
		
		try {
			wordListFileStream.close();
			fileReader.close();
		} catch (IOException e) {
			System.out.println("could not close file stream!!!");
		}
		
	}
	
}

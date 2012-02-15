package com.hogwart.grewordlist.adapter.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.hogwart.grewordlist.adapter.WordListAdapter;

public class WordListAdapterImpl implements WordListAdapter {
	
	private final String FILE_NAME_PREFIX = "wordlist_";
	private final String FILE_NAME_POSTFIX = ".list";
	
	private File wordListFile;
	List<String> wordList;

	@Override
	public List<String> getWordList(int list) {
		this.loadWordList(list);
		return this.wordList;
	}
	
	private void loadWordListFile(int list){
		//this.wordListFile = new File(FILE_NAME_PREFIX + list + FILE_NAME_POSTFIX);
		this.wordListFile = new File("wordlist_1.list");
	}
	
	private void loadWordList(int list){
		this.wordList = new ArrayList<String>();
		this.loadWordListFile(list);
		
		FileInputStream wordListFileStream=null;
		try {
			wordListFileStream = new FileInputStream(this.wordListFile);
			
		} catch (FileNotFoundException e) {
			System.out.println("The specified word list file was not found");
			return;
		}
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
	
	public static void main(String[] args) {
		WordListAdapterImpl test = new WordListAdapterImpl();
		
		for (String string : test.getWordList(1)) {
			System.out.println(string);
		}
	}

}

package com.hogwart.crackthecode.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.zschech.gwt.comet.server.CometSession;

public class Sandbox {
	public static void main(String[] args) {
		for(int i=0; i < 100; i++){
			System.out.print((int) (Math.random() * 8)+1);
			System.out.print(" ");
		}
		
		try {
			System.out.println(compareDate("05-April-86", "05-April-87"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConcurrentMap<String, String> testMap = new ConcurrentHashMap<String, String>();
		testMap.put("1", "one");
		testMap.put("1", "two");
		testMap.put("1", "three");
		testMap.put("2", "one");
		
		for (Map.Entry<String, String> entry : testMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}
	
	
	/*
	 * return "0" when both dates are exactly equal
	 * return "1" when firstDate is greater than secondDate and
	 * return "-1" when firstDate is less than secondDate.
	 * 
	 */
	public static int compareDate(String dateStr1, String dateStr2) throws ParseException{
		
		DateFormat formatter ; 
		Date date1;
		Date date2;
		formatter = new SimpleDateFormat("dd-MMM-yy");
		
		date1 = (Date) formatter.parse(dateStr1);
		date2 = (Date) formatter.parse(dateStr2);
		
		
		return date1.compareTo(date2);		
	}
}

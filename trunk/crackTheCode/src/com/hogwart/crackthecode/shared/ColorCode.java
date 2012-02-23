package com.hogwart.crackthecode.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.hogwart.crackthecode.shared.util.ColorCodeTranslator;

public class ColorCode implements IsSerializable {

	private int color1;
	private int color2;
	private int color3;
	private int color4;
	private int color5;
	
	public ColorCode(){
		
	}
	
	public ColorCode(String color1, String color2, String color3, String color4, String color5){
		this.color1 = ColorCodeTranslator.getCode(color1);
		this.color2 = ColorCodeTranslator.getCode(color2);
		this.color3 = ColorCodeTranslator.getCode(color3);
		this.color4 = ColorCodeTranslator.getCode(color4);
		this.color5 = ColorCodeTranslator.getCode(color5);
		
		this.toString();
	}
	
	public ColorCode(int color1, int color2, int color3, int color4, int color5){
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color3;
		this.color4 = color4;
		this.color5 = color5;
		
		this.toString();
	}
	
	public int getColor1() {
		return color1;
	}
	public void setColor1(int color1) {
		this.color1 = color1;
	}
	public int getColor2() {
		return color2;
	}
	public void setColor2(int color2) {
		this.color2 = color2;
	}
	public int getColor3() {
		return color3;
	}
	public void setColor3(int color3) {
		this.color3 = color3;
	}
	public int getColor4() {
		return color4;
	}
	public void setColor4(int color4) {
		this.color4 = color4;
	}
	public int getColor5() {
		return color5;
	}
	public void setColor5(int color5) {
		this.color5 = color5;
	}
	
	@Override
	public String toString(){
		return ColorCodeTranslator.getColor(color1) + " " +
				ColorCodeTranslator.getColor(color2) + " " +
				ColorCodeTranslator.getColor(color3) + " " +
				ColorCodeTranslator.getColor(color4) + " " +
				ColorCodeTranslator.getColor(color5);
	}
	
	public List<Integer> getAllCodes(){
		List<Integer> codes = new ArrayList<Integer>();
		
		codes.add(this.color1);
		codes.add(this.color2);
		codes.add(this.color3);
		codes.add(this.color4);
		codes.add(this.color5);
		
		return codes;
	}
	
	
	public boolean compare(ColorCode colorCode){
		if( this.color1 == colorCode.getColor1() && this.color2 == colorCode.getColor2() && 
				this.color3 == colorCode.getColor3() && this.color4 == colorCode.getColor4() &&
				this.color5 == colorCode.getColor5()){
			return true;
		}
		
		return false;
	}
	
	public boolean matchColor(int code){
		if( this.color1 == code || this.color2 == code || this.color3 == code || this.color4 == code || this.color5 == code){
			return true;
		}
		return false;
	}
	
	public List<Integer> getMatches(ColorCode colorCode){
		List<Integer> results = new ArrayList<Integer>();
		int matchingPositions = 0;
		int matchingColors = 0;
		
		if(this.matchColor(colorCode.getColor1())){
			matchingColors++;
		}
		if(this.matchColor(colorCode.getColor2())){
			matchingColors++;
		}
		if(this.matchColor(colorCode.getColor3())){
			matchingColors++;
		}
		if(this.matchColor(colorCode.getColor4())){
			matchingColors++;
		}
		if(this.matchColor(colorCode.getColor5())){
			matchingColors++;
		}
		
		if( this.color1 == colorCode.getColor1()){
			matchingPositions++;
			matchingColors--;
		}
		if( this.color2 == colorCode.getColor2()){
			matchingPositions++;
			matchingColors--;
		}
		if( this.color3 == colorCode.getColor3()){
			matchingPositions++;
			matchingColors--;
		}
		if( this.color4 == colorCode.getColor4()){
			matchingPositions++;
			matchingColors--;
		}
		if( this.color5 == colorCode.getColor5()){
			matchingPositions++;
			matchingColors--;
		}
		
		results.add(matchingPositions);
		results.add(matchingColors);
		return results;
	}
	
	
}

package com.hogwart.crackthecode.shared.util;

import com.hogwart.crackthecode.shared.ColorConstants;


public class ColorCodeTranslator {
	
	public static String getColor(int code){
		
		switch (code) {
			case 1:
				return ColorConstants.RED;
			case 2:
				return ColorConstants.BLUE;
			case 3:
				return ColorConstants.YELLOW;
			case 4:
				return ColorConstants.GREEN;
			case 5:
				return ColorConstants.PINK;
			case 6:
				return ColorConstants.ORANGE;
			case 7:
				return ColorConstants.BLUE_GREEN;
			case 8:
				return ColorConstants.PURPLE;
			default:
				return ColorConstants.WHITE;
		}
		
	}
	
	
	public static int getCode(String color){
						
		if( color.equals(ColorConstants.RED)){
			return 1;
		}
		
		if( color.equals(ColorConstants.BLUE)){
			return 2;
		}
		
		if( color.equals(ColorConstants.YELLOW)){
			return 3;
		}
		
		if( color.equals(ColorConstants.GREEN)){
			return 4;
		}
		
		if( color.equals(ColorConstants.PINK)){
			return 5;
		}
		
		if( color.equals(ColorConstants.ORANGE)){
			return 6;
		}
		
		if( color.equals(ColorConstants.BLUE_GREEN)){
			return 7;
		}
		
		if( color.equals(ColorConstants.PURPLE)){
			return 8;
		}
		
		return 9;
	}

}

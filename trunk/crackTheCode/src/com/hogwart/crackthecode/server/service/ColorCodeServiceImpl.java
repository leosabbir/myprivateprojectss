package com.hogwart.crackthecode.server.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hogwart.crackthecode.shared.ColorCode;
import com.hogwart.crackthecode.shared.api.ColorCodeService;

public class ColorCodeServiceImpl extends RemoteServiceServlet implements ColorCodeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ColorCode colorCode;

	@Override
	public void createColorCode() {
		List<Integer> codes = new ArrayList<Integer>();
		
		while( codes.size() < 5 ){
			Integer code = (int) (Math.random() * 8);
			
			if( !codes.contains(code)){
				codes.add(code);
			}
		}
		
		colorCode = new ColorCode(codes.get(0), codes.get(1), codes.get(2), codes.get(3), codes.get(4));
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.hogwart.crackthecode.shared.api.ColorCodeService#matchColorCode(com.hogwart.crackthecode.shared.ColorCode)
	 * 
	 * return List of two integers
	 * first integer being number of correct place
	 * and second integer being number of correct color only
	 */
			
	@Override
	public List<Integer> matchColorCode(ColorCode code) {
		System.out.println(this.colorCode.toString());
		return this.colorCode.getMatches(code);
	}

}

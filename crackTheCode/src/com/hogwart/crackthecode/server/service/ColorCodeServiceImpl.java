package com.hogwart.crackthecode.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpSession;

import net.zschech.gwt.comet.server.CometServletResponse;
import net.zschech.gwt.comet.server.CometSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hogwart.crackthecode.server.cometServlet.InstantMessagingServlet;
import com.hogwart.crackthecode.shared.ColorCode;
import com.hogwart.crackthecode.shared.api.ColorCodeService;

public class ColorCodeServiceImpl extends RemoteServiceServlet implements ColorCodeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ColorCode colorCode;
	
	private ConcurrentMap<String, CometSession> users = new ConcurrentHashMap<String, CometSession>();

	@Override
	public void createColorCode() {
		
		List<Integer> codes = new ArrayList<Integer>();
		
		while( codes.size() < 5 ){
			Integer code = (int) (Math.random() * 8) + 1;
			
			if( !codes.contains(code)){
				codes.add(code);
			}
		}
		
		colorCode = new ColorCode(codes.get(0), codes.get(1), codes.get(2), codes.get(3), codes.get(4));
		getSession().setAttribute(getSession().getId(), colorCode);
		
		CometSession cometSession = InstantMessagingServlet.getCometSession(getSession(), true);
		
		if( !users.containsKey(getSession().getId()) ){
			users.put(getSession().getId(), cometSession);
		}
		
		System.out.println(getSession().getId());
		
		for (Map.Entry<String, CometSession> entry : users.entrySet()) {
			if( entry.getValue().isValid() && !entry.getValue().equals(cometSession) ){
				entry.getValue().enqueue(colorCode.toString());
			}
		}
		
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
		ColorCode orginalColorCode = (ColorCode) getSession().getAttribute(getSession().getId());
		System.out.println(orginalColorCode.toString());
		return orginalColorCode.getMatches(code);
	}
	
	private HttpSession getSession(){
		return this.getThreadLocalRequest().getSession();
	}

}

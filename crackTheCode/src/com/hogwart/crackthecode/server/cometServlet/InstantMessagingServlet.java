package com.hogwart.crackthecode.server.cometServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zschech.gwt.comet.server.CometServlet;
import net.zschech.gwt.comet.server.CometServletResponse;
import net.zschech.gwt.comet.server.CometSession;

public class InstantMessagingServlet extends CometServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private ApplicationInstantMessagingSystem messagingSystem = ...;
	
    
    @Override
    protected void doComet(CometServletResponse cometResponse) throws ServletException, IOException {
            CometSession cometSession = cometResponse.getSession(false);
            if (cometSession == null) {
                    // The comet session has not been created yet so create it.
                    cometSession = cometResponse.getSession();
                    //messagingSystem.registerMessageSink(cometSession);
            }
    }
    
    /**
     * Override this method to be notified of the Comet connection being terminated.
     * 
     * @param cometResponse
     * @param serverInitiated
     */
    @Override
    public void cometTerminated(CometServletResponse cometResponse, boolean serverInitiated) {  	
    	
    }
    
    

}
package com.hogwart.crackthecode.client.listener;

import java.io.Serializable;
import java.util.List;

import com.google.gwt.user.client.Window;

import net.zschech.gwt.comet.client.CometListener;

public class CrackCodeCometListener implements CometListener{

	@Override
	public void onConnected(int heartbeat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable exception, boolean connected) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHeartbeat() {
		//Window.alert("Heart Beat received");
		
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(List<? extends Serializable> messages) {
		for (Serializable serializable : messages) {
			Window.alert(serializable.toString());
		}
		
		
	}

}

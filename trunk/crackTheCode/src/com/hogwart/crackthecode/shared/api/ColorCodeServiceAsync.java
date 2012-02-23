package com.hogwart.crackthecode.shared.api;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hogwart.crackthecode.shared.ColorCode;

public interface ColorCodeServiceAsync {

	void createColorCode(AsyncCallback<Void> callback);
	
	void matchColorCode(ColorCode colorCode, AsyncCallback<List<Integer>> callback);
}

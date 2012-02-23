package com.hogwart.crackthecode.shared.api;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hogwart.crackthecode.shared.ColorCode;


@RemoteServiceRelativePath("match")
public interface ColorCodeService extends RemoteService {

	void createColorCode();
	
	List<Integer> matchColorCode(ColorCode code);
	
}

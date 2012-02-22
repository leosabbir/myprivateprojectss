package com.hogwart.crackthecode.client.handler;

import com.google.gwt.event.shared.EventHandler;
import com.hogwart.crackthecode.client.events.SubmitEvent;

public interface SubmitHandler extends EventHandler {
	void onSubmit(SubmitEvent event);
}

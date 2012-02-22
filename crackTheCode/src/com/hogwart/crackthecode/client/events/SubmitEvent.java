package com.hogwart.crackthecode.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.hogwart.crackthecode.client.handler.SubmitHandler;

public class SubmitEvent extends GwtEvent<SubmitHandler> {
	
	public static Type<SubmitHandler> TYPE = new Type<SubmitHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SubmitHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SubmitHandler handler) {
		handler.onSubmit(this);
		
	}

}

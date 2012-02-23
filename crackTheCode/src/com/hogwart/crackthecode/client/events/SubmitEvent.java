package com.hogwart.crackthecode.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.hogwart.crackthecode.client.handler.SubmitHandler;
import com.hogwart.crackthecode.shared.ColorCode;

public class SubmitEvent extends GwtEvent<SubmitHandler> {
	
	private final  ColorCode colorCode;
	
	public SubmitEvent(ColorCode colorCode) {
		this.colorCode = colorCode;
	}
	
	public static Type<SubmitHandler> TYPE = new Type<SubmitHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SubmitHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SubmitHandler handler) {
		handler.onSubmit(this);
		
	}
	
	public ColorCode getColorCode(){
		return this.colorCode;
	}

}

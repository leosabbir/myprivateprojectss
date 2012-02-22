package com.hogwart.crackthecode.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.hogwart.crackthecode.client.handler.ColorSelectionHandler;

public class ColorSelectionEvent extends GwtEvent<ColorSelectionHandler> {
	
	private String selectedColor;
	public static final Type<ColorSelectionHandler> TYPE = new Type<ColorSelectionHandler>();
	
	public ColorSelectionEvent(String selectedColor) {
		this.selectedColor = selectedColor;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ColorSelectionHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ColorSelectionHandler handler) {
		handler.onColorSelection(selectedColor);
		
	}
	
	public String getSelectedColor(){
		return this.selectedColor;
	}

}

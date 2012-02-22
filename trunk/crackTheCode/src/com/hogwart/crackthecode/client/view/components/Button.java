package com.hogwart.crackthecode.client.view.components;

import org.vaadin.gwtgraphics.client.Group;
import org.vaadin.gwtgraphics.client.shape.Rectangle;
import org.vaadin.gwtgraphics.client.shape.Text;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.hogwart.crackthecode.shared.ColorConstants;

public class Button extends Group {
	
	int x0;
	int y0;
	
	Rectangle btnBg;
	Text btnText;
	
	public Button(int x, int y) {
		super();
		
		this.x0 = x;
		this.y0 = y;
		
		btnBg = new Rectangle(x0 + 15, y0 - 10 , 80, 25);
		btnText = new Text(x0 + 15 + 10, y0 + 10, "Submit");
		
		btnBg.setFillColor(ColorConstants.RED);
		btnText.setFillColor(ColorConstants.BLACK);
		
		addMouseDownHandler(new MouseDownHandler() {
			
			@Override
			public void onMouseDown(MouseDownEvent event) {
				btnBg.setFillColor(ColorConstants.BUTTON_MOUSEDOWN);
				
			}
		});
		
		addMouseUpHandler(new MouseUpHandler() {
			
			@Override
			public void onMouseUp(MouseUpEvent event) {
				btnBg.setFillColor(ColorConstants.BUTTON_NORMAL);
				
			}
		});
		
		addMouseOverHandler(new MouseOverHandler() {
			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				btnBg.setFillColor(ColorConstants.BUTTON_MOUSEOVER);
				
			}
		});
		
		addMouseOutHandler(new MouseOutHandler() {
			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				btnBg.setFillColor(ColorConstants.BUTTON_NORMAL);				
			}
		});
		
		add(btnBg);
		add(btnText);
	}
}

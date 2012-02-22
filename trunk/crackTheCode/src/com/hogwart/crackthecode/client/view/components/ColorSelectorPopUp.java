package com.hogwart.crackthecode.client.view.components;

import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.shape.Circle;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.hogwart.crackthecode.client.events.ColorSelectionEvent;
import com.hogwart.crackthecode.client.handler.ColorSelectionHandler;
import com.hogwart.crackthecode.shared.ColorConstants;

public class ColorSelectorPopUp extends DialogBox {
	
	private int x0 = 15;
	private int y0 = 15;
	
	private int radius = 10;
	private int gap = 10;

	public ColorSelectorPopUp(){
		DrawingArea canvas = new DrawingArea(150, 75);
		
		ColorSelectionClickHandler handler = new ColorSelectionClickHandler();
		
		//first option
		Circle selectYellow = new Circle(getX(0), getY(0), radius);
		selectYellow.setFillColor(ColorConstants.YELLOW);
		selectYellow.addClickHandler(handler);
		
		Circle selectBlue = new Circle(getX(1), getY(0), radius);
		selectBlue.setFillColor(ColorConstants.BLUE);
		selectBlue.addClickHandler(handler);
		
		Circle selectRed = new Circle(getX(2), getY(0), radius);
		selectRed.setFillColor(ColorConstants.RED);
		selectRed.addClickHandler(handler);
		
		Circle selectBlueGreen = new Circle( getX(3), getY(0), radius);
		selectBlueGreen.setFillColor(ColorConstants.BLUE_GREEN);
		selectBlueGreen.addClickHandler(handler);
		
		Circle selectGreen = new Circle(getX(0), getY(1), radius);
		selectGreen.setFillColor(ColorConstants.GREEN);
		selectGreen.addClickHandler(handler);
		
		Circle selectPurple = new Circle( getX(1), getY(1), radius);
		selectPurple.setFillColor(ColorConstants.PURPLE);
		selectPurple.addClickHandler(handler);
		
		Circle selectOrange = new Circle( getX(2), getY(1), radius);
		selectOrange.setFillColor(ColorConstants.ORANGE);
		selectOrange.addClickHandler(handler);
		
		Circle selectPink = new Circle( getX(3), getY(1), radius);
		selectPink.setFillColor(ColorConstants.PINK);
		selectPink.addClickHandler(handler);
		
		Circle empty = new Circle(getX(4), getY(0), radius);
		empty.addClickHandler(handler);
		
		
		canvas.add(selectYellow);
		canvas.add(selectBlue);
		canvas.add(selectRed);
		canvas.add(selectBlueGreen);
		canvas.add(empty);
		
		canvas.add(selectGreen);
		canvas.add(selectPurple);
		canvas.add(selectOrange);
		canvas.add(selectPink);
		
		setWidget(canvas);
	}
	
	private int getX(int column){
		return x0 + column * radius * 2 + (column) * gap;
	}
	
	private int getY(int row){
		return y0 + row * radius * 2 + (row) * gap;
	}
	
	private class ColorSelectionClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			fireEvent(new ColorSelectionEvent( ((Circle) event.getSource()).getFillColor()) );
			hide();
		}
		
	}
	
	public void setEventHandler(ColorSelectionHandler handler){
		addHandler(handler, ColorSelectionEvent.TYPE);
	}
	
}

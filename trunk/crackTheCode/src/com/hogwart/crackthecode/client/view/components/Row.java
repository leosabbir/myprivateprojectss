package com.hogwart.crackthecode.client.view.components;

import org.vaadin.gwtgraphics.client.Group;
import org.vaadin.gwtgraphics.client.shape.Circle;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.hogwart.crackthecode.client.events.SubmitEvent;
import com.hogwart.crackthecode.client.handler.ColorSelectionHandler;
import com.hogwart.crackthecode.client.handler.SubmitHandler;

public class Row extends Group implements ColorSelectionHandler {
	
	private int x0 = 15;
	private int y0 = 15;
	
	private int radius = 10;
	private int gap = 10;
	
	Circle select1, select2, select3, select4, select5;
	Button submitBtn;
	SelectClickHandler selectClickHandler; 
	
	private ColorSelectorPopUp colorSelectionPanel;
	private Circle source;

	public Row(int x0, int y0) {
		super();
		
		this.x0 = x0;
		this.y0 = y0;
		
		colorSelectionPanel = new ColorSelectorPopUp();
		colorSelectionPanel.setEventHandler(this);
		init();
	}
	
	public void init(){
		selectClickHandler = new SelectClickHandler();
		
		select1 = new Circle(getX(0), y0, radius);
		select1.addClickHandler(selectClickHandler);
		
		select2 = new Circle(getX(1), y0, radius);
		select2.addClickHandler(selectClickHandler);
		
		select3 = new Circle(getX(2), y0, radius);
		select3.addClickHandler(selectClickHandler);
		
		select4 = new Circle(getX(3), y0, radius);
		select4.addClickHandler(selectClickHandler);
		
		select5 = new Circle(getX(4), y0, radius);
		select5.addClickHandler(selectClickHandler);
		
		submitBtn = new Button(getX(5), y0);
		
		submitBtn.addClickHandler( new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				remove(submitBtn);
				fireEvent(new SubmitEvent());
				
			}
		});
		
		add(select1);
		add(select2);
		add(select3);
		add(select4);
		add(select5);
		add(submitBtn);		
	}
	
	private class SelectClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			source = (Circle) event.getSource();
			colorSelectionPanel.center();			
		}
	}
	
	private int getX(int ball){
		return x0 + ball * radius * 2 + ball * gap;
	}
	
	@Override
	public void onColorSelection(String selectedColor) {
		source.setFillColor(selectedColor);	
	}
	
	public void setSubmitHandler(SubmitHandler handler){
		addHandler(handler, SubmitEvent.TYPE);
	}
 
}

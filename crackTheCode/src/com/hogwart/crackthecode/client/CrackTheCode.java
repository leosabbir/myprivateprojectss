package com.hogwart.crackthecode.client;

import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.shape.Circle;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.hogwart.crackthecode.client.events.SubmitEvent;
import com.hogwart.crackthecode.client.handler.SubmitHandler;
import com.hogwart.crackthecode.client.view.components.Row;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CrackTheCode implements EntryPoint, SubmitHandler {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	private DrawingArea canvas;
	private Row row;
	
	private int x0 = 15;
	private int y0 = 15;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		row = new Row(x0, y0);
		row.setSubmitHandler(this);
		
		canvas = new DrawingArea(400, 800);
		
		canvas.add(row);
		
		RootPanel.get().add(canvas);
		
	}

	@Override
	public void onSubmit(SubmitEvent event) {

		y0 += 30;
		row = new Row(x0, y0);
		row.setSubmitHandler(this);
		
		canvas.add(row);
		
	}
}

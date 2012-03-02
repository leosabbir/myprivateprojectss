package com.hogwart.crackthecode.client;

import java.util.List;

import net.zschech.gwt.comet.client.CometClient;

import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.Image;
import org.vaadin.gwtgraphics.client.shape.Circle;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.hogwart.crackthecode.client.events.SubmitEvent;
import com.hogwart.crackthecode.client.handler.SubmitHandler;
import com.hogwart.crackthecode.client.listener.CrackCodeCometListener;
import com.hogwart.crackthecode.client.view.components.Row;
import com.hogwart.crackthecode.shared.api.ColorCodeService;
import com.hogwart.crackthecode.shared.api.ColorCodeServiceAsync;

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
	private final ColorCodeServiceAsync colorCodeService = GWT.create(ColorCodeService.class);
	
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
		
		Image image = new Image(0, 0, 400, 450, "canvasbackground.JPG");
		
		canvas = new DrawingArea(400, 450);
		canvas.setStyleName("maincanvas");
		canvas.add(image);
		
		CometClient cometClient = new CometClient(GWT.getModuleBaseURL() + "comet", new CrackCodeCometListener());
		cometClient.start();
		
		colorCodeService.createColorCode(new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				canvas.add(row);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});		
		
		RootPanel.get().add(canvas);
		
	}

	@Override
	public void onSubmit(SubmitEvent event) {

		y0 += 30;
		
		final SubmitHandler handler = this;
		
		colorCodeService.matchColorCode(event.getColorCode(), new AsyncCallback<List<Integer>>() {
			
			@Override
			public void onSuccess(List<Integer> result) {
				row.showResultText(result.get(0) + " " + result.get(1));
				row = new Row(x0, y0);
				row.setSubmitHandler(handler);
				canvas.add(row);
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}

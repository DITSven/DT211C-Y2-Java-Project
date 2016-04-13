/*
 * Author: C14752305 
 * Class: DrawText
 * Date: 13/04/2016
 * Handles how text is drawn.
 */
package com.project.OOP2;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;


public class DrawText implements Serializable {
	private String userInput;
	private float textx;
	private float texty;
	private Rectangle2D boundsRectangle;
	
	public DrawText(float textx, float texty, String userInput){
		setTextx(textx);
		setTexty(texty);
		setUserInput(userInput);
		setBoundsRectangle(DrawingCanvas.fontUsed.getStringBounds(getUserInput(), DrawingCanvas.graphicsSettings.getFontRenderContext()));
	}//end DrawText
	
	public float getTextx(){
		return this.textx;
	}
	
	public float getTexty(){
		return this.texty;
	}

	public void setTextx(float textx) {
		this.textx = textx;
	}

	public void setTexty(float texty) {
		this.texty = texty;
	}

	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	public Rectangle2D getBoundsRectangle() {
		return boundsRectangle;
	}

	public void setBoundsRectangle(Rectangle2D boundsRectangle) {
		this.boundsRectangle = boundsRectangle;
	}
}

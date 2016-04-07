/*
 * Author: C14752305 
 * Class: DrawTerminal
 * Date: 7/04/2016
 * Handles how terminal boxes (rounded rectangles)
 *  are drawn.
 */
package com.project.OOP2;

import java.awt.geom.RoundRectangle2D;

public class DrawTerminal {
	float x1, x2, y1, y2;
	RoundRectangle2D.Float drawTerminal;
	
	public DrawTerminal(float x1, float x2,	float y1, float y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		//Get x and y coordinates for generating RoundRectangle2D
		float xPosition = Math.min(x1, x2);
		float yPosition = Math.min(y1, y2);
		//Get width and height for generating RoundRectangle2D
		float width = Math.abs(x1 + x2);
		float height = Math.abs(y1 + y2);
		//Create RoundRectangle2D
		this.drawTerminal = new RoundRectangle2D.Float(xPosition, yPosition, width, height, 45, 45);
		
	}
	
}

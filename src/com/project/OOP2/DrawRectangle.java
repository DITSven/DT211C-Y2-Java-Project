/*
 * Author: C14752305 
 * Class: DrawRectangle
 * Date: 7/04/2016
 * Handles how rectangles are drawn.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class DrawRectangle {
	float x1, x2, y1, y2;
	Shape drawRectangle;
	
	public DrawRectangle(float x1, float x2, float y1, float y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		//Get x and y coordinates for generating Rectangle2D
		float xPosition = Math.min(x1, x2);
		float yPosition = Math.min(y1, y2);
		//Get width and height for generating Rectangle2D
		float width = Math.abs(x2 - x1);
		float height = Math.abs(y2 - y1);
		this.drawRectangle = new Rectangle2D.Float(xPosition, yPosition, width, height);
		
	}
	
	public Shape returnShape(){
		return this.drawRectangle;
	}
	
}

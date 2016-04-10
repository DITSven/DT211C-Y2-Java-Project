/*
 * Author: C14752305 
 * Class: DrawLine
 * Date: 7/04/2016
 * Redundant class to be deleted.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Line2D;

public class DrawLine {
	float x1, x2, y1, y2;
	Shape drawLine;
	
	public DrawLine(float x1, float x2,	float y1, float y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.drawLine = new Line2D.Float(x1, x2, y1, y2);
		
	}
	
	public Shape returnShape(){
		return this.drawLine;
	}
	
}

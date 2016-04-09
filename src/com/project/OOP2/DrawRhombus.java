/*
 * Author: C14752305 
 * Class: DrawRhombus
 * Date: 7/04/2016
 * Handles how diamonds are drawn.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Path2D;

public class DrawRhombus {
	float x1, x2, y1, y2;
	Path2D.Float drawRhombus;
	Shape finishedRhombus;
	
	public DrawRhombus(float x1, float x2, float y1, float y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y2;
		this.y2 = y2;
		//Get middle position
		float x3 = (x1 + x2)/2;
		float y3 = (y1 + y2)/2;
		//Draw rhombus shape
		this.drawRhombus = new Path2D.Float();
		drawRhombus.moveTo(x1, y3);
		drawRhombus.lineTo(x3, y1);
		drawRhombus.lineTo(x2, y3);
		drawRhombus.lineTo(x3, y2);
		drawRhombus.lineTo(x1, y3);
		drawRhombus.closePath();
		this.finishedRhombus = drawRhombus;
	}
	
	public Shape returnShape(){
		return this.finishedRhombus;
	}
}

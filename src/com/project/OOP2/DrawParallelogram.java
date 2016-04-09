/*
 * Author: C14752305 
 * Class: DrawParallelogram
 * Date: 7/04/2016
 * Handles how parallelograms are drawn.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Path2D;

public class DrawParallelogram {
	float x1, x2, y1, y2;
	Path2D.Float drawParallelogram;
	Shape finishedParallelogram;
	
	public DrawParallelogram(float x1, float x2, float y1, float y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y2;
		this.y2 = y2;
		//Sort positions
		float xa = Math.min(x1, x2);
		float xb = Math.max(x1, x2);
		//Set adjusted positions
		float xc = xa - 30;
		float xd = xb - 30;
				
		//Draw parallelogram
		this.drawParallelogram = new Path2D.Float();
		drawParallelogram.moveTo(xa, y1);
		drawParallelogram.lineTo(xb, y1);
		drawParallelogram.lineTo(xd, y2);
		drawParallelogram.lineTo(xc, y2);
		drawParallelogram.lineTo(xa, y1);
		drawParallelogram.closePath();
		this.finishedParallelogram = drawParallelogram;
	}
	
	public Shape returnShape(){
		return this.finishedParallelogram;
	}
}
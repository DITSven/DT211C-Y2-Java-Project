/*
 * Author: C14752305 
 * Class: DrawParallelogram
 * Date: 8/04/2016
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
		float ya = Math.min(y1, y2);
		float yb = Math.max(y1, y2);
		//Set adjusted positions
		float xc = xa - 20;
		float xd = xb - 20;
				
		//Draw parallelogram
		this.drawParallelogram = new Path2D.Float();
		drawParallelogram.moveTo(xa, ya);
		drawParallelogram.lineTo(xb, ya);
		drawParallelogram.lineTo(xd, yb);
		drawParallelogram.lineTo(xc, yb);
		drawParallelogram.lineTo(xa, ya);
		drawParallelogram.closePath();
		this.finishedParallelogram = drawParallelogram;
	}
	
	public Shape returnShape(){
		return this.finishedParallelogram;
	}
}
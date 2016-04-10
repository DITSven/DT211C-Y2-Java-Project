/*
 * Author: C14752305 
 * Class: DrawParallelogram
 * Date: 10/04/2016
 * Handles how parallelograms are drawn.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Path2D;

public class DrawParallelogram {
	float x1, x2, y1, y2;
	Path2D.Float drawParallelogram;
	Shape finishedParallelogram;
	private double anchor1x;
	private double anchor2x;
	private double anchor1y;
	private double anchor2y;
	private double anchorh;
	private double anchorw;
	
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
		
		this.setAnchor1x(x1);
		this.setAnchor2x(x2);
		this.setAnchor1y(y1);
		this.setAnchor2y(y2);
		this.setAnchorh((y1 + y2)/2);
		this.setAnchorw((x1 + x2)/2);
	}
	
	public Shape returnShape(){
		return this.finishedParallelogram;
	}

	public double getAnchor1x() {
		return anchor1x;
	}

	public void setAnchor1x(double anchor1x) {
		this.anchor1x = anchor1x;
	}

	public double getAnchor2x() {
		return anchor2x;
	}

	public void setAnchor2x(double anchor2x) {
		this.anchor2x = anchor2x;
	}

	public double getAnchor1y() {
		return anchor1y;
	}

	public void setAnchor1y(double anchor1y) {
		this.anchor1y = anchor1y;
	}

	public double getAnchor2y() {
		return anchor2y;
	}

	public void setAnchor2y(double anchor2y) {
		this.anchor2y = anchor2y;
	}

	public double getAnchorh() {
		return anchorh;
	}

	public void setAnchorh(double anchorh) {
		this.anchorh = anchorh;
	}

	public double getAnchorw() {
		return anchorw;
	}

	public void setAnchorw(double anchorw) {
		this.anchorw = anchorw;
	}
}
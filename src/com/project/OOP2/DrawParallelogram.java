/*
 * Author: C14752305 
 * Class: DrawParallelogram
 * Date: 10/04/2016
 * Handles how parallelograms are drawn.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Path2D;

public class DrawParallelogram extends ShapeControl {
	float x1, x2, y1, y2;
	Path2D.Float drawParallelogram;
	Shape finishedParallelogram;
	
	//Create anchors for snapping
	private double anchorNx;
	private double anchorNy;
	private double anchorSx;
	private double anchorSy;
	private double anchorEx;
	private double anchorEy;
	private double anchorWx;
	private double anchorWy;
	
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
		//Set x difference
		final float xDiff = 20;
		//Set adjusted positions
		float xc = xa - xDiff;
		float xd = xb - xDiff;
				
		//Draw parallelogram
		this.drawParallelogram = new Path2D.Float();
		drawParallelogram.moveTo(xa, ya);
		drawParallelogram.lineTo(xb, ya);
		drawParallelogram.lineTo(xd, yb);
		drawParallelogram.lineTo(xc, yb);
		drawParallelogram.lineTo(xa, ya);
		drawParallelogram.closePath();
		this.finishedParallelogram = drawParallelogram;
		
				
		//Get anchor positions
		this.setAnchorNx((x1 + x2)/2);
		this.setAnchorSx((x1 + x2)/2);
		this.setAnchorEy((y1 + y2)/2);
		this.setAnchorWy((y1 + y2)/2);
		if(y1 > y2){
			this.setAnchorNy(y1);
			this.setAnchorSy(y2);
		}//end if
		else{
			this.setAnchorNy(y2);
			this.setAnchorSy(y1);
		}//end else
		if(x1 > x2){
			this.setAnchorEx(x1 - (xDiff/2));
			this.setAnchorWx(x2 - (xDiff/2));
		}//end if
		else{
			this.setAnchorEx(x2 - (xDiff/2));
			this.setAnchorWx(x1 - (xDiff/2));
		}//end else
	}
	
	public Shape returnShape(){
		return this.finishedParallelogram;
	}
	
	public void setShape(Shape finishedParallelogram){
		this.finishedParallelogram = finishedParallelogram;
	}

	public double getAnchorNx() {
		return anchorNx;
	}

	public void setAnchorNx(double anchorNx) {
		this.anchorNx = anchorNx;
	}

	public double getAnchorNy() {
		return anchorNy;
	}

	public void setAnchorNy(double anchorNy) {
		this.anchorNy = anchorNy;
	}

	public double getAnchorSx() {
		return anchorSx;
	}

	public void setAnchorSx(double anchorSx) {
		this.anchorSx = anchorSx;
	}

	public double getAnchorSy() {
		return anchorSy;
	}

	public void setAnchorSy(double anchorSy) {
		this.anchorSy = anchorSy;
	}

	public double getAnchorEx() {
		return anchorEx;
	}

	public void setAnchorEx(double anchorEx) {
		this.anchorEx = anchorEx;
	}

	public double getAnchorEy() {
		return anchorEy;
	}

	public void setAnchorEy(double anchorEy) {
		this.anchorEy = anchorEy;
	}

	public double getAnchorWx() {
		return anchorWx;
	}

	public void setAnchorWx(double anchorWx) {
		this.anchorWx = anchorWx;
	}

	public double getAnchorWy() {
		return anchorWy;
	}

	public void setAnchorWy(double anchorWy) {
		this.anchorWy = anchorWy;
	}
}
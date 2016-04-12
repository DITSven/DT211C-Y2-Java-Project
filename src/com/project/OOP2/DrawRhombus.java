/*
 * Author: C14752305 
 * Class: DrawRhombus
 * Date: 10/04/2016
 * Handles how diamonds are drawn.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.io.Serializable;

public class DrawRhombus extends ShapeControl implements Serializable{
	float x1, x2, y1, y2;
	Path2D.Float drawRhombus;
	Shape finishedRhombus;
	
	//anchors for snapping
	private double anchorNx;
	private double anchorNy;
	private double anchorSx;
	private double anchorSy;
	private double anchorEx;
	private double anchorEy;
	private double anchorWx;
	private double anchorWy;
	
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
		
		//get anchor positions
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
			this.setAnchorEx(x1);
			this.setAnchorWx(x2);
		}//end if
		else{
			this.setAnchorEx(x2);
			this.setAnchorWx(x1);
		}//end else
		
	}
	
	public Shape returnShape(){
		return this.finishedRhombus;
	}
	
	public void setShape(Shape finishedRhombus){
		this.finishedRhombus = finishedRhombus;
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

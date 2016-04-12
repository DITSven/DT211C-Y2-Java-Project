/*
 * Author: C14752305 
 * Class: DrawRectangle
 * Date: 10/04/2016
 * Handles how rectangles are drawn.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class DrawRectangle extends ShapeControl implements Serializable{
	float x1, x2, y1, y2;
	Shape drawRectangle;
	//Create anchors for snapping
	private double anchorNx;
	private double anchorNy;
	private double anchorSx;
	private double anchorSy;
	private double anchorEx;
	private double anchorEy;
	private double anchorWx;
	private double anchorWy;
	
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
			this.setAnchorEx(x1);
			this.setAnchorWx(x2);
		}//end if
		else{
			this.setAnchorEx(x2);
			this.setAnchorWx(x1);
		}//end else
	}
	
	public Shape returnShape(){
		return this.drawRectangle;
	}
	
	public void setShape(Shape drawRectangle){
		this.drawRectangle = drawRectangle;
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

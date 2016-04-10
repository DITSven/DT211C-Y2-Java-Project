/*
 * Author: C14752305 
 * Class: DrawRhombus
 * Date: 10/04/2016
 * Handles how diamonds are drawn.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Path2D;

public class DrawRhombus {
	float x1, x2, y1, y2;
	Path2D.Float drawRhombus;
	Shape finishedRhombus;
	private double anchor1x;
	private double anchor2x;
	private double anchor1y;
	private double anchor2y;
	private double anchorh;
	private double anchorw;
	
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
		
		this.setAnchor1x(x1);
		this.setAnchor2x(x2);
		this.setAnchor1y(y1);
		this.setAnchor2y(y2);
		this.setAnchorh(y3);
		this.setAnchorw(x3);
		
	}
	
	public Shape returnShape(){
		return this.finishedRhombus;
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

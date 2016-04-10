/*
 * Author: C14752305 
 * Class: MoveShape
 * Date: 09/03/2016
 * Redundant class to be deleted.
 */
package com.project.OOP2;

import java.awt.Shape;

public class MoveShape {
	private double xClick;
	private double yClick;
	private double xRelease;
	private double yRelease;
	private double xDiff;
	private double yDiff;
	private Shape shape;
	
	public MoveShape(Shape shape){
		this.setShape(shape);
	}
	
	public MoveShape(Shape shape, double xClick, double yClick, double xRelease,
			double yRelease){
		this.setxClick(xClick);
		this.setyClick(yClick);
		this.setxRelease(xRelease);
		this.setyRelease(yRelease);
		this.setShape(shape);
		//Get difference between positions
		this.setxDiff(xRelease - xClick);
		this.setyDiff(yRelease - yClick);
	}

	public double getxClick() {
		return xClick;
	}

	public void setxClick(double xClick) {
		this.xClick = xClick;
	}

	public double getyClick() {
		return yClick;
	}

	public void setyClick(double yClick) {
		this.yClick = yClick;
	}

	public double getxRelease() {
		return xRelease;
	}

	public void setxRelease(double xRelease) {
		this.xRelease = xRelease;
	}

	public double getyRelease() {
		return yRelease;
	}

	public void setyRelease(double yRelease) {
		this.yRelease = yRelease;
	}

	public double getxDiff() {
		return xDiff;
	}

	public void setxDiff(double xDiff) {
		this.xDiff = xDiff;
	}

	public double getyDiff() {
		return yDiff;
	}

	public void setyDiff(double yDiff) {
		this.yDiff = yDiff;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}


}

/*
 * Author: C14752305 
 * Interface: ShapeControl
 * Date: 10/04/2016
 * Handles returning shapes and anchor points
 */
package com.project.OOP2;

import java.awt.Shape;

public abstract class ShapeControl {
	public abstract Shape returnShape();
	public abstract void setShape(Shape shape);
	public abstract double getAnchorNx();
	public abstract void setAnchorNx(double anchorNx);
	public abstract double getAnchorNy();
	public abstract void setAnchorNy(double anchorNy);
	public abstract double getAnchorSx();
	public abstract void setAnchorSx(double anchorSx);
	public abstract double getAnchorSy();
	public abstract void setAnchorSy(double anchorSy);
	public abstract double getAnchorEx();
	public abstract void setAnchorEx(double anchorEx);
	public abstract double getAnchorEy();
	public abstract void setAnchorEy(double anchorEy);
	public abstract double getAnchorWx();
	public abstract void setAnchorWx(double anchorWx);
	public abstract double getAnchorWy();
	public abstract void setAnchorWy(double anchorWy);
	
}

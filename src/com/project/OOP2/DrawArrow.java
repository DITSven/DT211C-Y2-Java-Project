/*
 * Author: C14752305 
 * Class: DrawArrow
 * Date: 8/04/2016
 * Handles how arrows are drawn.
 */
package com.project.OOP2;

import java.awt.geom.Path2D;

public class DrawArrow {
	double x1, x2, y1, y2;
	Path2D.Float drawArrow;
	int arrowLength = 5;
	
	public DrawArrow(float x1, float x2, float y1, float y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y2;
		this.y2 = y2;
		double x3 = 0;
		double x4 = 0;
		double y3 = 0;
		double y4 = 0;
		
		//Find angle of line to x axis
		double xa = Math.abs(x2 - x1);
		double ya = Math.abs(y2 - y1);
		double angleOfLine = Math.toDegrees(Math.atan2(ya, xa));
		
		//Trigonometry
		double angleToMeasure = 45 - angleOfLine;
		if (angleToMeasure < 0){
			angleToMeasure += 360;
		}
		angleToMeasure = Math.toRadians(angleToMeasure);
		double adjLength = Math.cos(angleToMeasure)/arrowLength;
		double oppLength = Math.sin(angleToMeasure)/arrowLength;
		
		//Get arrow draw positions
		//accounting for rotation
		if(angleOfLine <= 45){
			x3 = x2 - adjLength;
			y3 = y2 + oppLength;
			x4 = x2 - oppLength;
			y4 = y2 - adjLength;
		}
		else if(angleOfLine > 45 && angleOfLine <= 135){
			x3 = x2 - adjLength;
			y3 = y2 - oppLength;
			x4 = x2 + oppLength;
			y4 = y2 - adjLength;
		}
		else if (angleOfLine > 135 && angleOfLine <= 225){
			x3 = x2 + adjLength;
			y3 = y2 - oppLength;
			x4 = x2 + oppLength;
			y4 = y2 + adjLength;
		}
		else if (angleOfLine > 225 && angleOfLine <= 315){
			x3 = x2 + adjLength;
			y3 = y2 - oppLength;
			x4 = x2 + oppLength;
			y4 = y2 + adjLength;
		}
		else if ((angleOfLine > 315 && angleOfLine < 360) || angleOfLine == 0){
			x3 = x2 - adjLength;
			y3 = y2 + oppLength;
			x4 = x2 - oppLength;
			y4 = y2 - adjLength;
		}
		
		//Draw arrow shape
		this.drawArrow = new Path2D.Float();
		drawArrow.moveTo(x1, y1);
		drawArrow.lineTo(x2, y2);
		drawArrow.lineTo(x3, y3);
		drawArrow.moveTo(x2, y2);
		drawArrow.lineTo(x4, y4);
		drawArrow.closePath();
	}
}

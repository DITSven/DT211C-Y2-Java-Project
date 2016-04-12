/*
 * Author: C14752305 
 * Class: DrawArrow
 * Date: 10/04/2016
 * Handles how arrows are drawn.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class DrawArrow extends ShapeControl implements Serializable {
	double x1, x2, y1, y2;
	Path2D.Float drawArrow;
	Shape finishedArrow;
	
	//Create anchor points
	private double anchorNx;
	private double anchorNy;
	private double anchorSx;
	private double anchorSy;
	private double anchorEx;
	private double anchorEy;
	private double anchorWx;
	private double anchorWy;
	
	
	public DrawArrow(float x1, float x2, float y1, float y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y2;
		this.y2 = y2;
		
		//Find angle of line to x axis
		double xa = Math.abs(x2 - x1);
		double ya = Math.abs(y2 - y1);
		double angleOfLine = Math.atan2(ya, xa);
		
		//Trigonometry
		/*
		 * Code copied from:
		 * http://www.dreamincode.net/forums/topic/275998-drawing-arrows-by-mouse-click-and-drag/
		 * 
		 */
		 int arrowHeight = 5;                 
         int halfArrowWidth = 5; 
         Point2D aroBase = null;
         //Find base of arrow (as triangle)
         /*
 		 * End of copied code.
 		 */
         if(x2 >= x1){
        	 if(y2 >= y1){
        		 aroBase = new Point2D.Double(
                         x2 - arrowHeight*Math.cos(angleOfLine),
                         y2 - arrowHeight*Math.sin(angleOfLine)
                         );         		 
        	 }//end if 
        	 else if(y2 < y1){
        		 aroBase = new Point2D.Double(
                         x2 - arrowHeight*Math.cos(angleOfLine),
                         y2 + arrowHeight*Math.sin(angleOfLine)
                         ); 
        	 }//end else if
         }//end if
         else if(x2 < x1){
    		 if(y2 >= y1){
        		 aroBase = new Point2D.Double(
                         x2 + arrowHeight*Math.cos(angleOfLine),
                         y2 - arrowHeight*Math.sin(angleOfLine)
                         );         		 
        	 }//end if
        	 else if(y2 < y1){
        		 aroBase = new Point2D.Double(
                         x2 + arrowHeight*Math.cos(angleOfLine),
                         y2 + arrowHeight*Math.sin(angleOfLine)
                         );
        	 }//end else if
         }//end else if
         
         /*
 		 * Code copied from:
 		 * http://www.dreamincode.net/forums/topic/275998-drawing-arrows-by-mouse-click-and-drag/
 		 * 
 		 */         
         //Find first end point of arrow
         Point2D end1 = new Point2D.Double(
                 aroBase.getX()-halfArrowWidth*Math.cos(angleOfLine-Math.PI/2),
                 aroBase.getY()-halfArrowWidth*Math.sin(angleOfLine-Math.PI/2));
		
         //Find second end point of arrow
         Point2D end2 = new Point2D.Double(
                 aroBase.getX()+halfArrowWidth*Math.cos(angleOfLine-Math.PI/2),
                 aroBase.getY()+halfArrowWidth*Math.sin(angleOfLine-Math.PI/2));
         
		/*
		 * End of copied code.
		 */
       
		//Draw arrow shape
		this.drawArrow = new Path2D.Float();
		drawArrow.moveTo(x1, y1);
		drawArrow.lineTo(x2, y2);
		drawArrow.lineTo(end1.getX(), end1.getY());
		drawArrow.moveTo(x2, y2);
		drawArrow.lineTo(end2.getX(), end2.getY());
		drawArrow.closePath();
		this.finishedArrow = drawArrow;
		
        //Get anchor positions
		if(y1 > y2){
			this.setAnchorNy(y1);
			this.setAnchorSy(y2);
			this.setAnchorNx(x1);
			this.setAnchorSx(x2);
			if(x1 > x2){
				this.setAnchorEx(x1);
				this.setAnchorWx(x2);
				this.setAnchorEy(y1);
				this.setAnchorWy(y2);
			}//end if
			else{
				this.setAnchorEx(x2);
				this.setAnchorWx(x1);
				this.setAnchorEy(y2);
				this.setAnchorWy(y1);
			}//end else
		}//end if
		else{
			this.setAnchorNy(y2);
			this.setAnchorSy(y1);
			this.setAnchorNx(x2);
			this.setAnchorSx(x1);
			if(x1 > x2){
				this.setAnchorEx(x1);
				this.setAnchorWx(x2);
				this.setAnchorEy(y1);
				this.setAnchorWy(y2);
			}//end if
			else{
				this.setAnchorEx(x2);
				this.setAnchorWx(x1);
				this.setAnchorEy(y2);
				this.setAnchorWy(y1);
			}//end else	
		}//end else
	}//end DrawArrow()
	
	public Shape returnShape(){
		return this.finishedArrow;
	}
	
	public void setShape(Shape finishedArrow){
		this.finishedArrow = finishedArrow;
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

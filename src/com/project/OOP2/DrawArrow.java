/*
 * Author: C14752305 
 * Class: DrawArrow
 * Date: 9/04/2016
 * Handles how arrows are drawn.
 */
package com.project.OOP2;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class DrawArrow {
	double x1, x2, y1, y2;
	Path2D.Float drawArrow;
	Shape finishedArrow;
		
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
        
	}
	
	public Shape returnShape(){
		return this.finishedArrow;
	}
}

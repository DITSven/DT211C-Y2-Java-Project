/*
 * Author: C14752305 
 * Class: DrawingCanvas
 * Date: 
 * Generates an area with listeners for drawing on.
 */
package com.project.OOP2;

import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;
import java.util.*;
import javax.swing.JComponent;

public class DrawingCanvas extends JComponent{

	//Create ArrayList objects to store shapes
	/*Code taken from: 
	 * http://www.newthinktank.com/2012/07/java-video-tutorial-49/
	 */
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	/*End of copied code*/
	
	//Create ArrayList objects to store text
	//TO BE IMPLEMENTED LATER
	//ArrayList<String> textfield = new ArrayList<String>();
	
	int xDrawStart, yDrawStart, xDrawEnd, yDrawEnd;
	Graphics2D graphicsSettings;
	
	//Constructor for monitoring events.
	public DrawingCanvas(){
		
		
		
		//add mouse listeners to canvas
		addMouseListener(new MouseAdapter(){
			//for when mouse pressed get x and y
			public void mousePressed(MouseEvent e){
				xDrawStart = e.getX();
				yDrawStart = e.getY();
			}
			public void mouseReleased(MouseEvent e){
				xDrawEnd = e.getX();
				yDrawEnd = e.getY();
				
				/*Code taken from: 
				 * http://www.newthinktank.com/2012/07/java-video-tutorial-49/
				 */
				
				Shape aShape = null;
				/*End of copied code*/
				
				//call relevant drawing class.
				if (NewPage.drawOption == 1){
					DrawTerminal drawTerminal = new DrawTerminal(xDrawStart, xDrawEnd, yDrawStart, yDrawEnd);
					aShape = drawTerminal.returnShape();
				}
				else if (NewPage.drawOption == 2){
					DrawArrow drawArrow = new DrawArrow(xDrawStart, xDrawEnd, yDrawStart, yDrawEnd);
					aShape = drawArrow.returnShape();
				}
				else if (NewPage.drawOption == 3){
					DrawRectangle drawRectangle = new DrawRectangle(xDrawStart, xDrawEnd, yDrawStart, yDrawEnd);
					aShape = drawRectangle.returnShape();
				}
				else if (NewPage.drawOption == 4){
					DrawParallelogram drawParallelogram = new DrawParallelogram(xDrawStart, xDrawEnd, yDrawStart, yDrawEnd);
					aShape = drawParallelogram.returnShape();
				}
				else if (NewPage.drawOption == 5){
					DrawRhombus drawRhombus = new DrawRhombus(xDrawStart, xDrawEnd, yDrawStart, yDrawEnd);
					aShape = drawRhombus.returnShape();
				}
				else{
					
				}
				//add shapes to arrayList
				/*Code taken from: 
				 * http://www.newthinktank.com/2012/07/java-video-tutorial-49/
				 */
				shapes.add(aShape);
				/*End of copied code*/
				
				repaint();
				
			}
		});
		
	}
	
	public void paint(Graphics g){
	
		
		graphicsSettings = (Graphics2D)g;
		/*Code taken from: 
		 * http://www.newthinktank.com/2012/07/java-video-tutorial-49/
		 */
		// Antialiasing cleans up the jagged lines and defines rendering rules
            
		graphicsSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
            
        // Defines the line width of the stroke
            
		graphicsSettings.setStroke(new BasicStroke(3));

		
		
        for (Shape s : shapes){
        	graphicsSettings.draw(s);
        	}
    }
	/*End of code copied*/
}

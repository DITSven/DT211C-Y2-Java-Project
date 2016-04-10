/*
 * Author: C14752305 
 * Class: DrawingCanvas
 * Date: 10/04/2016
 * Generates an area with listeners for drawing on.
 */
package com.project.OOP2;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.Component.*;
import java.util.*;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class DrawingCanvas extends JComponent{

	//Create ArrayList<Shape> to store shapes
	/*Code taken from: 
	 * http://www.newthinktank.com/2012/07/java-video-tutorial-49/
	 */
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	/*End of copied code*/
	
	//Create ArrayList of shapes with anchor points
	ArrayList<Object> anchoredShapes = new ArrayList<Object>();
	//Create ArrayList objects to store text
	//TO BE IMPLEMENTED LATER
	//ArrayList<String> textfield = new ArrayList<String>();
	
	private int xDrawStart;
	private int yDrawStart;
	private int xDrawEnd;
	private int yDrawEnd;
	Graphics2D graphicsSettings;

	//Constructor for monitoring events.
	public DrawingCanvas(){
		
		//add mouse listeners to canvas
		addMouseListener(new MouseAdapter(){
			//for when mouse pressed get x and y
			public void mousePressed(MouseEvent e){
				setxDrawStart(e.getX());
				setyDrawStart(e.getY());
				
				//Handle right mouse click for delete
				if (SwingUtilities.isRightMouseButton(e)){
					if(shapes.size() > 0){
						for(int index = 0; index<shapes.size(); index++){
							if(shapes.get(index) == null){
								continue;
							}
							if(shapes.get(index).getBounds2D().contains(getxDrawStart(), getyDrawStart())){
								shapes.remove(index);
								anchoredShapes.remove(index);
								break;
							}//end if
						
						}//end for
					}//end if
				}
			}//end mousePressed
			
			public void mouseReleased(MouseEvent e){
				setxDrawEnd(e.getX());
				setyDrawEnd(e.getY());
				
				/*Code taken from: 
				 * http://www.newthinktank.com/2012/07/java-video-tutorial-49/
				 */
				
				Shape aShape = null;
				/*End of copied code*/
				
				Object shapeWithAnchor = null;
				
				//call relevant drawing class.
				if (NewPage.drawOption == 1){
					DrawTerminal drawTerminal = new DrawTerminal(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
					aShape = drawTerminal.returnShape();
					shapeWithAnchor = drawTerminal;
				}//end if
				else if (NewPage.drawOption == 2){
					DrawArrow drawArrow = new DrawArrow(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
					aShape = drawArrow.returnShape();
					shapeWithAnchor = drawArrow;
				}//end else if
				else if (NewPage.drawOption == 3){
					DrawRectangle drawRectangle = new DrawRectangle(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
					aShape = drawRectangle.returnShape();
					shapeWithAnchor = drawRectangle;
				}//end else if
				else if (NewPage.drawOption == 4){
					DrawParallelogram drawParallelogram = new DrawParallelogram(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
					aShape = drawParallelogram.returnShape();
					shapeWithAnchor = drawParallelogram;
				}//end else if
				else if (NewPage.drawOption == 5){
					DrawRhombus drawRhombus = new DrawRhombus(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
					aShape = drawRhombus.returnShape();
					shapeWithAnchor = drawRhombus;
				}//end else if
				else if (NewPage.drawOption == 0){
					if(shapes.size() > 0){
						for(int count = 0; count<shapes.size(); count++){
							if(shapes.get(count) == null){
								continue;
							}
							if(shapes.get(count).getBounds2D().contains(getxDrawStart(), getyDrawStart())){
								AffineTransform translateTo = new AffineTransform();
								translateTo.translate((getxDrawEnd() - getxDrawStart()),(getyDrawEnd() - getyDrawStart()) );
								shapes.set(count, translateTo.createTransformedShape(shapes.get(count)));
								break;
							}//end if
						
						}//end for
					}//end if

					
				}//end else if
				
				//add shapes to arrayList
				/*Code taken from: 
				 * http://www.newthinktank.com/2012/07/java-video-tutorial-49/
				 */
				shapes.add(aShape);
				/*End of copied code*/
				
				anchoredShapes.add(shapeWithAnchor);
				
				NewPage.drawOption = 0;
				repaint();
				
			}//end mouseReleased
	
		});//end mouse listeners
	}//end DrawingCanvas
	
	//Control graphical output
	public void paint(Graphics g){
	
		graphicsSettings = (Graphics2D)g;
		Shape aShape = null;
		/*Code taken from: 
		 * http://www.newthinktank.com/2012/07/java-video-tutorial-49/
		 */
		// Antialiasing cleans up the jagged lines and defines rendering rules
            
		graphicsSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
		/*End of code copied*/    
		
		//Set the width of the lines drawn
		graphicsSettings.setStroke(new BasicStroke(1));

		//Set the line color
		graphicsSettings.setColor(Color.BLACK);
		graphicsSettings.setBackground(Color.WHITE);
		
		
		/*Code taken from: 
		 * http://www.newthinktank.com/2012/07/java-video-tutorial-49/
		 */
		//Draws images onto page
		for(Shape i: shapes){
			if(i != null){
				graphicsSettings.draw(i);
			}//end if
		}//end for
		/*End of code copied*/
		
		
		/*Not working for now	 
		//Create guide image while drawing.
		Point drawStart, drawEnd;
		drawStart = new Point(getxDrawStart(), getyDrawStart());
		drawEnd = new Point(getxDrawEnd(), getyDrawEnd());
		if(drawStart != null && drawEnd != null){
			if (NewPage.drawOption == 1){
				DrawTerminal drawTerminal = new DrawTerminal(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
				aShape = drawTerminal.returnShape();
			}
			else if (NewPage.drawOption == 2){
				DrawArrow drawArrow = new DrawArrow(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
				aShape = drawArrow.returnShape();
			}
			else if (NewPage.drawOption == 3){
				DrawRectangle drawRectangle = new DrawRectangle(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
				aShape = drawRectangle.returnShape();
			}
			else if (NewPage.drawOption == 4){
				DrawParallelogram drawParallelogram = new DrawParallelogram(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
				aShape = drawParallelogram.returnShape();
			}
			else if (NewPage.drawOption == 5){
				DrawRhombus drawRhombus = new DrawRhombus(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
				aShape = drawRhombus.returnShape();
			}
			else{
				aShape = null;
			}
			graphicsSettings.draw(aShape);
		}
       	*/       	
    }//end paint

	//Getters & Setters
	public int getxDrawStart() {
		return xDrawStart;
	}

	public void setxDrawStart(int xDrawStart) {
		this.xDrawStart = xDrawStart;
	}

	public int getyDrawStart() {
		return yDrawStart;
	}

	public void setyDrawStart(int yDrawStart) {
		this.yDrawStart = yDrawStart;
	}

	public int getxDrawEnd() {
		return xDrawEnd;
	}

	public void setxDrawEnd(int xDrawEnd) {
		this.xDrawEnd = xDrawEnd;
	}

	public int getyDrawEnd() {
		return yDrawEnd;
	}

	public void setyDrawEnd(int yDrawEnd) {
		this.yDrawEnd = yDrawEnd;
	}
	
}

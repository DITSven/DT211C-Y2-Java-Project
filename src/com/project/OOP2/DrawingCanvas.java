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
	final int snapvalue = 11;
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
							}//end if
							if(shapes.get(count).getBounds2D().contains(getxDrawStart(), getyDrawStart())){
								//Get anchor positions for shape selected
								double a1Nx = ((ShapeControl) anchoredShapes.get(count)).getAnchorNx();
								double a1Ny = ((ShapeControl) anchoredShapes.get(count)).getAnchorNy();
								double a1Sx = ((ShapeControl) anchoredShapes.get(count)).getAnchorSx();
								double a1Sy = ((ShapeControl) anchoredShapes.get(count)).getAnchorSy();
								double a1Ex = ((ShapeControl) anchoredShapes.get(count)).getAnchorEx();
								double a1Ey = ((ShapeControl) anchoredShapes.get(count)).getAnchorEy();
								double a1Wx = ((ShapeControl) anchoredShapes.get(count)).getAnchorWx();
								double a1Wy = ((ShapeControl) anchoredShapes.get(count)).getAnchorWy();
								
								//Variables to hold snap difference, set to 0
								double snapx = 0;
								double snapy = 0;
								//Move object to new location
								AffineTransform translateTo = new AffineTransform();
								translateTo.translate((getxDrawEnd() - getxDrawStart()),(getyDrawEnd() - getyDrawStart()) );
								shapes.set(count, translateTo.createTransformedShape(shapes.get(count)));
								
								/*Not working
								//adjust anchoredShapes shape
								anchoredShapes.set(count, translateTo.createTransformedShape(
										((ShapeControl) anchoredShapes.get(count)).returnShape()));
								//adjust anchoredShapes anchors
								((ShapeControl) anchoredShapes.get(count)).setAnchorNx(
										((ShapeControl) anchoredShapes.get(count)).getAnchorNx() + snapx);
								((ShapeControl) anchoredShapes.get(count)).setAnchorSx(
										((ShapeControl) anchoredShapes.get(count)).getAnchorSx() + snapx);
								((ShapeControl) anchoredShapes.get(count)).setAnchorEx(
										((ShapeControl) anchoredShapes.get(count)).getAnchorEx() + snapx);
								((ShapeControl) anchoredShapes.get(count)).setAnchorWx(
										((ShapeControl) anchoredShapes.get(count)).getAnchorWx() + snapx);
								((ShapeControl) anchoredShapes.get(count)).setAnchorNy(
										((ShapeControl) anchoredShapes.get(count)).getAnchorNy() + snapy);
								((ShapeControl) anchoredShapes.get(count)).setAnchorSy(
										((ShapeControl) anchoredShapes.get(count)).getAnchorSy() + snapy);
								((ShapeControl) anchoredShapes.get(count)).setAnchorEy(
										((ShapeControl) anchoredShapes.get(count)).getAnchorEy() + snapy);
								((ShapeControl) anchoredShapes.get(count)).setAnchorWy(
										((ShapeControl) anchoredShapes.get(count)).getAnchorWy() + snapy);
								*/
								
								//Check for nearby shapes
								for(Object o : anchoredShapes){
									if(o == null){
										continue;
									}//end if
									//Get anchor points for shape
									double a2Nx = ((ShapeControl) o).getAnchorNx();
									double a2Ny = ((ShapeControl) o).getAnchorNy();
									double a2Sx = ((ShapeControl) o).getAnchorSx();
									double a2Sy = ((ShapeControl) o).getAnchorSy();
									double a2Ex = ((ShapeControl) o).getAnchorEx();
									double a2Ey = ((ShapeControl) o).getAnchorEy();
									double a2Wx = ((ShapeControl) o).getAnchorWx();
									double a2Wy = ((ShapeControl) o).getAnchorWy();
									
									//test if south is near north
									if((Math.abs(a1Sx - a2Nx) < snapvalue) && (Math.abs(a1Sy - a2Ny) < snapvalue)){
										snapy = a1Sy - a2Ny;
										if(a1Sx > a2Nx)
											snapx = a1Sx - a2Nx;
										else
											snapx = a2Nx - a1Sx;
										break;
									}//end if
									//test if north is near south
									else if((Math.abs(a1Nx - a2Sx) < snapvalue) && (Math.abs(a1Ny - a2Sy) < snapvalue)){
										snapy = a2Sy - a1Ny;
										if(a1Sx > a2Nx)
											snapx = a1Sx - a2Nx;
										else
											snapx = a2Nx - a1Sx;
										break;
									}//end else if
									//test if east is near west
									else if((Math.abs(a1Ex - a2Wx) < snapvalue) && (Math.abs(a1Ey - a2Wy) < snapvalue)){
										snapx = a2Wx - a1Ex;
										if(a1Ey > a2Wy)
											snapy = a1Ey - a2Wy;
										else
											snapy = a2Wy - a1Ey;
										break;
									}//end else if
									//test if west is near east
									else if((Math.abs(a1Wx - a2Ex) < snapvalue) && (Math.abs(a1Wy - a2Ey) < snapvalue)){
										snapx = a1Wx - a2Ex;
										if(a1Wy > a2Ey)
											snapy = a1Wy - a2Ey;
										else
											snapy = a2Ey - a1Wy;
										break;
									}//end else if
									else{
										continue;
									}
								}//end for
								
								//Move again
								if(snapx > 0 || snapy > 0){
									translateTo.translate(snapx, snapy);
									shapes.set(count, translateTo.createTransformedShape(shapes.get(count)));
									
									/*Not working
									//adjust anchoredShapes shape
									anchoredShapes.set(count, translateTo.createTransformedShape(
											((ShapeControl) anchoredShapes.get(count)).returnShape()));
									//adjust anchoredShapes anchors
									((ShapeControl) anchoredShapes.get(count)).setAnchorNx(
											((ShapeControl) anchoredShapes.get(count)).getAnchorNx() + snapx);
									((ShapeControl) anchoredShapes.get(count)).setAnchorSx(
											((ShapeControl) anchoredShapes.get(count)).getAnchorSx() + snapx);
									((ShapeControl) anchoredShapes.get(count)).setAnchorEx(
											((ShapeControl) anchoredShapes.get(count)).getAnchorEx() + snapx);
									((ShapeControl) anchoredShapes.get(count)).setAnchorWx(
											((ShapeControl) anchoredShapes.get(count)).getAnchorWx() + snapx);
									((ShapeControl) anchoredShapes.get(count)).setAnchorNy(
											((ShapeControl) anchoredShapes.get(count)).getAnchorNy() + snapy);
									((ShapeControl) anchoredShapes.get(count)).setAnchorSy(
											((ShapeControl) anchoredShapes.get(count)).getAnchorSy() + snapy);
									((ShapeControl) anchoredShapes.get(count)).setAnchorEy(
											((ShapeControl) anchoredShapes.get(count)).getAnchorEy() + snapy);
									((ShapeControl) anchoredShapes.get(count)).setAnchorWy(
											((ShapeControl) anchoredShapes.get(count)).getAnchorWy() + snapy);
									*/
									
								}//end if
								
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

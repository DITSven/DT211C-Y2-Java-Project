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
					if(anchoredShapes.size() > 0){
						for(int index = 0; index<anchoredShapes.size(); index++){
							if(anchoredShapes.get(index) == null){
								continue;
							}
							if(((ShapeControl) anchoredShapes.get(index)).returnShape().getBounds2D().contains(getxDrawStart(), getyDrawStart())){
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
				
				Object aShape = null;
								
				//call relevant drawing class.
				if (NewPage.drawOption == 1){
					DrawTerminal drawTerminal = new DrawTerminal(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
					aShape = drawTerminal;
					}//end if
				else if (NewPage.drawOption == 2){
					DrawArrow drawArrow = new DrawArrow(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
					aShape = drawArrow;
				}//end else if
				else if (NewPage.drawOption == 3){
					DrawRectangle drawRectangle = new DrawRectangle(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
					aShape = drawRectangle;
				}//end else if
				else if (NewPage.drawOption == 4){
					DrawParallelogram drawParallelogram = new DrawParallelogram(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
					aShape = drawParallelogram;
				}//end else if
				else if (NewPage.drawOption == 5){
					DrawRhombus drawRhombus = new DrawRhombus(getxDrawStart(), getxDrawEnd(), getyDrawStart(), getyDrawEnd());
					aShape = drawRhombus;
				}//end else if
				else if (NewPage.drawOption == 0){
					if(anchoredShapes.size() > 0){
						for(Object o: anchoredShapes){
							if(o == null){
								continue;
							}//end if
							if(((ShapeControl) o).returnShape().getBounds2D().contains(getxDrawStart(), getyDrawStart())){
								//Get anchor positions for shape selected
								double a1Nx = ((ShapeControl) o).getAnchorNx();
								double a1Ny = ((ShapeControl) o).getAnchorNy();
								double a1Sx = ((ShapeControl) o).getAnchorSx();
								double a1Sy = ((ShapeControl) o).getAnchorSy();
								double a1Ex = ((ShapeControl) o).getAnchorEx();
								double a1Ey = ((ShapeControl) o).getAnchorEy();
								double a1Wx = ((ShapeControl) o).getAnchorWx();
								double a1Wy = ((ShapeControl) o).getAnchorWy();
								
								//Variables to hold snap difference, set to 0
								double snapx = 0;
								double snapy = 0;
								
								//Variables to hold location difference
								double xLocDiff = getxDrawEnd() - getxDrawStart();
								double yLocDiff = getyDrawEnd() - getyDrawStart();
								//Move object to new location
								AffineTransform translateTo = new AffineTransform();
								translateTo.translate(xLocDiff, yLocDiff );
								((ShapeControl) o).setShape(translateTo.createTransformedShape(((ShapeControl) o).returnShape()));
								
								//Adjust anchors
								((ShapeControl) o).setAnchorNx(((ShapeControl) o).getAnchorNx() + xLocDiff);
								((ShapeControl) o).setAnchorNy(((ShapeControl) o).getAnchorNy() + yLocDiff);
								((ShapeControl) o).setAnchorSx(((ShapeControl) o).getAnchorSx() + xLocDiff);
								((ShapeControl) o).setAnchorSy(((ShapeControl) o).getAnchorSy() + yLocDiff);
								((ShapeControl) o).setAnchorEx(((ShapeControl) o).getAnchorEx() + xLocDiff);
								((ShapeControl) o).setAnchorEy(((ShapeControl) o).getAnchorEy() + yLocDiff);
								((ShapeControl) o).setAnchorWx(((ShapeControl) o).getAnchorWx() + xLocDiff);
								((ShapeControl) o).setAnchorWy(((ShapeControl) o).getAnchorWy() + yLocDiff);
								
								//Check for nearby shapes
								for(Object o2 : anchoredShapes){
									if(o2 == null){
										continue;
									}//end if
									//Get anchor points for shape
									double a2Nx = ((ShapeControl) o2).getAnchorNx();
									double a2Ny = ((ShapeControl) o2).getAnchorNy();
									double a2Sx = ((ShapeControl) o2).getAnchorSx();
									double a2Sy = ((ShapeControl) o2).getAnchorSy();
									double a2Ex = ((ShapeControl) o2).getAnchorEx();
									double a2Ey = ((ShapeControl) o2).getAnchorEy();
									double a2Wx = ((ShapeControl) o2).getAnchorWx();
									double a2Wy = ((ShapeControl) o2).getAnchorWy();
									
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
									((ShapeControl) o).setShape(translateTo.createTransformedShape(((ShapeControl) o).returnShape()));
									
									//Adjust anchors
									((ShapeControl) o).setAnchorNx(((ShapeControl) o).getAnchorNx() + snapx);
									((ShapeControl) o).setAnchorNy(((ShapeControl) o).getAnchorNy() + snapy);
									((ShapeControl) o).setAnchorSx(((ShapeControl) o).getAnchorSx() + snapx);
									((ShapeControl) o).setAnchorSy(((ShapeControl) o).getAnchorSy() + snapy);
									((ShapeControl) o).setAnchorEx(((ShapeControl) o).getAnchorEx() + snapx);
									((ShapeControl) o).setAnchorEy(((ShapeControl) o).getAnchorEy() + snapy);
									((ShapeControl) o).setAnchorWx(((ShapeControl) o).getAnchorWx() + snapx);
									((ShapeControl) o).setAnchorWy(((ShapeControl) o).getAnchorWy() + snapy);
									
								}//end if
								
								break;
							}//end if
						
						}//end for
					}//end if

					
				}//end else if
				
				//add shapes to arrayList
				anchoredShapes.add(aShape);
				
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
		for(Object i: anchoredShapes){
			if(i != null){
				graphicsSettings.draw(((ShapeControl) i).returnShape());
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

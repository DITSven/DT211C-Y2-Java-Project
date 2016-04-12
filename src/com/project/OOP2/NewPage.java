/*
 * Author: C14752305 
 * Class: NewPage
 * Date: 09/04/2016
 * Handles how the page is generated.
 */
package com.project.OOP2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class NewPage extends JFrame implements ActionListener {	
	//Create GUI elements
	JPanel sidePanel, editorPanel;
	JScrollPane scrollPane;
	JLabel newPageLabel;
	MenuBar newPageMenuBar;
	ImageIcon arrowIcon, terminalIcon, rectangleIcon, rhombusIcon, parallelogramIcon, textIcon;
	JButton arrowButton, terminalButton, rectangleButton, rhombusButton, parallelogramButton, textButton;
	Menu newPageFile, newPageEdit, newPageHelp;
	MenuItem newPageNew, newPageOpen, newPageSave, newPageUndo, newPageRedo, newPageAbout;
	JFileChooser fileChoice;
	
	//Color variable to store white (255,255,255)
	Color white;
	
	//Create object for drawing
	DrawingCanvas newPageCanvas;
	
	//Create ArrayLists to store undo/redo state
	private ArrayList<Object> undoArray = new ArrayList<Object>();
	private ArrayList<Object> redoArray = new ArrayList<Object>();
	
	//Variables to store canvas size
	private int xMax;
	private int yMax;
	//Set variable to control which option is selected for
	//different drawing tasks.
	static int drawOption = 0;
		
	//NewPage constructor
	public NewPage(String pageTitle){
		super(pageTitle);
		fileChoice = new JFileChooser();		
		
		setSize(800,640);
		white = new Color(255,255,255);
		//Set layout as a Border Layout
		setLayout(new BorderLayout());
		
		//Set label
		newPageLabel = new JLabel("New Page");
		add(newPageLabel);
		
		//Create menubar
		newPageMenuBar = new MenuBar();
		//Add objects to menu bar
		newPageFile = new Menu("File");
		newPageEdit = new Menu("Edit");
		newPageHelp = new Menu("Help");
		//Create buttons
		newPageNew = new MenuItem("New");
		newPageOpen = new MenuItem("Open");
		newPageSave = new MenuItem("Save");
		newPageUndo = new MenuItem("Undo");
		newPageRedo = new MenuItem("Redo");
		newPageAbout = new MenuItem("About");
		//Add Menus
		newPageMenuBar.add(newPageFile);
		newPageMenuBar.add(newPageEdit);
		newPageMenuBar.add(newPageHelp);
		//Add Menu Items
		newPageFile.add(newPageNew);
		newPageFile.add(newPageOpen);
		newPageFile.add(newPageSave);
		newPageEdit.add(newPageUndo);
		newPageEdit.add(newPageRedo);
		newPageHelp.add(newPageAbout);
		//Add to page
		setMenuBar(newPageMenuBar);

		//Create panels
		sidePanel = new JPanel();
		editorPanel = new JPanel();
		
		//Add objects to sidePanel
		sidePanel.setLayout(new GridLayout(6,1));
		sidePanel.setBackground(white);
		//Create icons
		arrowIcon = new ImageIcon("src/images/arrowicon.png");
		terminalIcon = new ImageIcon("src/images/terminalicon.png");
		rectangleIcon = new ImageIcon("src/images/rectangleicon.png"); 
		rhombusIcon = new ImageIcon("src/images/rhombusicon.png");
		parallelogramIcon = new ImageIcon("src/images/parallelogramicon.png");
		textIcon = new ImageIcon("src/images/texticon.png");
		//Create buttons
		arrowButton = new JButton(arrowIcon);
		arrowButton.setBackground(white);
		terminalButton = new JButton(terminalIcon);
		terminalButton.setBackground(white);
		rectangleButton = new JButton(rectangleIcon);
		rectangleButton.setBackground(white);
		rhombusButton = new JButton(rhombusIcon);
		rhombusButton.setBackground(white);
		parallelogramButton = new JButton(parallelogramIcon);
		parallelogramButton.setBackground(white);
		textButton = new JButton(textIcon);
		textButton.setBackground(white);
		
		//Add Buttons
		sidePanel.add(terminalButton);
		sidePanel.add(arrowButton);
		sidePanel.add(rectangleButton);
		sidePanel.add(parallelogramButton);
		sidePanel.add(rhombusButton);
		sidePanel.add(textButton);
		
		//Add canvas to editorPanel
		editorPanel.setLayout(new GridLayout(1,1));
		editorPanel.setBackground(white);
		newPageCanvas = new DrawingCanvas();
		editorPanel.add(newPageCanvas);
		
		//Set editoPanel size
		
				
		scrollPane = new JScrollPane(editorPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		
		scrollPane.setViewportView(editorPanel);
		scrollPane.setPreferredSize(new Dimension(getxMax(), getyMax()));		
		add(sidePanel, BorderLayout.WEST);
		//add(editorPanel, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.CENTER);
		
		//Set Action Listeners
		newPageNew.addActionListener(this);
		newPageOpen.addActionListener(this);
		newPageSave.addActionListener(this);
		newPageUndo.addActionListener(this);
		newPageAbout.addActionListener(this);
		terminalButton.addActionListener(this);
		arrowButton.addActionListener(this);
		rectangleButton.addActionListener(this);
		parallelogramButton.addActionListener(this);
		rhombusButton.addActionListener(this);
		textButton.addActionListener(this);
		
		//Set window to close properly
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set visible
		setVisible(true);
	}//end NewPage()
	
	//Action performed - currently test
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		
		if(source == newPageNew){
			int newPageOption = JOptionPane.showConfirmDialog(this,
					"Open new page and lose all progress?" ,"New Page?"
					, JOptionPane.OK_CANCEL_OPTION);
			if(newPageOption == JOptionPane.OK_OPTION){
				newPageCanvas.setAnchoredShapes(new ArrayList<Object>());
				newPageCanvas.repaint();
			}//end if
		}
		//Open and Save based on tutorial at:
		//https://www.youtube.com/watch?v=Sm9yoju1me0
		if(source == newPageOpen){
			int fileChoiceOption = fileChoice.showOpenDialog(NewPage.this);
			if(fileChoiceOption == JFileChooser.APPROVE_OPTION){
				File file = fileChoice.getSelectedFile();
				try(FileInputStream fileInput = new FileInputStream(file)){
					ObjectInputStream objectFileInput = new ObjectInputStream(fileInput);
					newPageCanvas.setAnchoredShapes((ArrayList<Object>)objectFileInput.readObject());
					
					newPageCanvas.repaint();
					
					objectFileInput.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//end if
			else{
				
			}//end else
		}
		if(source == newPageSave){
			int fileChoiceOption = fileChoice.showSaveDialog(NewPage.this);
			if(fileChoiceOption == JFileChooser.APPROVE_OPTION){
				File file = fileChoice.getSelectedFile();
				try(FileOutputStream fileOutput = new FileOutputStream(file)){
					ObjectOutputStream objectFileOutput = new ObjectOutputStream(fileOutput);
					
					objectFileOutput.writeObject(newPageCanvas.getAnchoredShapes());
					
					objectFileOutput.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//end if
			else{
				
			}//end else
		}
		if(source == newPageUndo){
			//Set undoArray
			setUndoArray(new ArrayList<Object>());
			getUndoArray().trimToSize();
			for(Object u: newPageCanvas.getUndoState()){
				if(u == null)
					continue;
				else
					getUndoArray().add(u);				
			}//end for
			
			//Set redo state
			newPageCanvas.setRedoState(new ArrayList<Object>());
			newPageCanvas.getRedoState().trimToSize();
			for(Object r: newPageCanvas.getAnchoredShapes()){
				if(r == null)
					continue;
				else
					newPageCanvas.getRedoState().add(r);
			}//end for
			
			//Set canvas array to previous state
			newPageCanvas.setAnchoredShapes(new ArrayList<Object>());
			newPageCanvas.getAnchoredShapes().trimToSize();
			for(Object o: getUndoArray()){
				if (o == null)
					continue;
				else
					newPageCanvas.getAnchoredShapes().add(o);
			}//end for
			
			newPageCanvas.repaint();
		}
		if(source == newPageRedo){
			if(newPageCanvas.getRedoState().isEmpty()){
				
			}//end if
			else{
				//Set redoArray
				setRedoArray(new ArrayList<Object>());
				getRedoArray().trimToSize();
				for(Object r: newPageCanvas.getRedoState()){
					if(r == null)
						continue;
					else
						getRedoArray().add(r);
				}//end for
			}//end else	
				//Set undoArray
				newPageCanvas.setUndoState(new ArrayList<Object>());
				for(Object u: newPageCanvas.getAnchoredShapes()){
					if(u == null)
						continue;
					else
						newPageCanvas.getUndoState().add(u);
				}//end for
				
				//Set canvas ArrayList
				newPageCanvas.setAnchoredShapes(new ArrayList<Object>());
				for(Object o: getRedoArray()){
					if(o == null)
						continue;
					else
						newPageCanvas.getAnchoredShapes().add(o);
				}//end for
				
				//Clear Redo
				newPageCanvas.setRedoState(new ArrayList<Object>());
				
				newPageCanvas.repaint();
			
		}
		if(source == newPageAbout){
			JOptionPane.showMessageDialog(this, "Created by Eoin Mulvey(C14752305)\nDT211C/2\n2016", "About", JOptionPane.PLAIN_MESSAGE);
		}
		if(source == terminalButton){
			drawOption = 1;
		}
		if(source == arrowButton){
			drawOption = 2;
		}
		if(source == rectangleButton){
			drawOption = 3;
		}
		if(source == parallelogramButton){
			drawOption = 4;
		}
		if(source == rhombusButton){
			drawOption = 5;
		}
		if(source == textButton){
			drawOption = 6;
		}
	}//end actionPerformed()

	//Getters & setters
	public ArrayList<Object> getUndoArray() {
		return undoArray;
	}

	public void setUndoArray(ArrayList<Object> undoArray) {
		this.undoArray = undoArray;
	}
	
	public ArrayList<Object> getRedoArray() {
		return redoArray;
	}

	public void setRedoArray(ArrayList<Object> redoArray) {
		this.redoArray = redoArray;
	}
	
	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getyMax() {
		return yMax;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

}

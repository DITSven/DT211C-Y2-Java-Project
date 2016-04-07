/*
 * Author: C14752305 
 * Class: NewPage
 * Date: 
 * Handles how the page is generated.
 */
package com.project.OOP2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NewPage extends JFrame implements ActionListener {

	JPanel sidePanel, editorPanel;
	Canvas newPageCanvas;
	JLabel newPageLabel;
	MenuBar newPageMenuBar;
	ImageIcon arrowIcon, terminalIcon, rectangleIcon, rhombusIcon, parallelogramIcon;
	JButton arrowButton, terminalButton, rectangleButton, rhombusButton, parallelogramButton;
	Menu newPageFile, newPageEdit, newPageHelp;
	MenuItem newPageNew, newPageOpen, newPageSave, newPageUndo, newPageAbout;
	Color white;
	//NewPage constructor
	public NewPage(String pageTitle){
		super(pageTitle);
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
		newPageHelp.add(newPageAbout);
		//Add to page
		setMenuBar(newPageMenuBar);

		//Create panels
		sidePanel = new JPanel();
		editorPanel = new JPanel();
		
		//Add objects to sidePanel
		sidePanel.setLayout(new GridLayout(5,1));
		sidePanel.setBackground(white);
		//Create icons
		arrowIcon = new ImageIcon("src/images/arrowicon.png");
		terminalIcon = new ImageIcon("src/images/terminalicon.png");
		rectangleIcon = new ImageIcon("src/images/rectangleicon.png"); 
		rhombusIcon = new ImageIcon("src/images/rhombusicon.png");
		parallelogramIcon = new ImageIcon("src/images/parallelogramicon.png");
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
		//Add Buttons
		sidePanel.add(terminalButton);
		sidePanel.add(arrowButton);
		sidePanel.add(rectangleButton);
		sidePanel.add(parallelogramButton);
		sidePanel.add(rhombusButton);
		
		//Add canvas to editorPanel
		editorPanel.setLayout(new GridLayout(1,1));
		newPageCanvas = new Canvas();
		newPageCanvas.setBackground(white);
		editorPanel.add(newPageCanvas);
		 
		//Add panels
		add(sidePanel, BorderLayout.WEST);
		add(editorPanel, BorderLayout.CENTER);
		
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
		
		//Set window to close properly
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set visible
		setVisible(true);
	}
	
	//Action performed - currently test
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		
		if(source == newPageNew){
			JOptionPane.showMessageDialog(this, "Placeholder");
		}
		if(source == newPageOpen){
			JOptionPane.showMessageDialog(this, "Placeholder");
		}
		if(source == newPageSave){
			JOptionPane.showMessageDialog(this, "Placeholder");
		}
		if(source == newPageUndo){
			JOptionPane.showMessageDialog(this, "Placeholder");
		}
		if(source == newPageAbout){
			JOptionPane.showMessageDialog(this, "Created by Eoin Mulvey(C14752305)\nDT211C/2\n2016", "About", JOptionPane.PLAIN_MESSAGE);
		}
		if(source == terminalButton){
			JOptionPane.showMessageDialog(this, "Placeholder");
		}
		if(source == arrowButton){
			JOptionPane.showMessageDialog(this, "Placeholder");
		}
		if(source == rectangleButton){
			JOptionPane.showMessageDialog(this, "Placeholder");
		}
		if(source == parallelogramButton){
			JOptionPane.showMessageDialog(this, "Placeholder");
		}
		if(source == rhombusButton){
			JOptionPane.showMessageDialog(this, "Placeholder");
		}
	}
	
}

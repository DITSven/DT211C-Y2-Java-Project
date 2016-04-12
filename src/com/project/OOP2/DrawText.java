package com.project.OOP2;

import java.io.Serializable;

import javax.swing.JTextField;

public class DrawText implements Serializable {
	String userInput;
	private float textx;
	private float texty;
	JTextField userTextField;
	
	public DrawText(float textx, float texty){
		this.setTextx(textx);
		this.setTexty(texty);
		this.userTextField = new JTextField("");
		this.userTextField.setAlignmentX((float)textx);
		this.userTextField.setAlignmentY((float)texty);
		this.userInput = this.userTextField.getText();
	}//end DrawText
	
	public String returnText(){
		return this.userInput;
	}//end returnText
	
	public float getTextx(){
		return this.textx;
	}
	
	public float getTexty(){
		return this.texty;
	}

	public void setTextx(float textx) {
		this.textx = textx;
	}

	public void setTexty(float texty) {
		this.texty = texty;
	}
}

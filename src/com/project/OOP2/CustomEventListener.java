package com.project.OOP2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomEventListener implements ActionListener{
	ActionEvent event;
	
	public CustomEventListener(ActionEvent event){
		this.event = event;	
	}
	
	public CustomEventListener(ActionEvent event, float x, float y){
		this.event = event;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		//NewPage.source = event;
	}
	
}

/**
 * 
 */
package edu.bth.spla.calculator.model;


public enum Type{
	ADULT("Adult Version"), CHILD("Child Version");
	
	private String label;
	
	
	private Type(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}	
}
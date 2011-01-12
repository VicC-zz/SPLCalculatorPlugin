package edu.bth.spla.calculator.model;

public enum Input {
	MOUSE("Mouse Input", true), KEYBOARD ("Keyboard Input", false);
	private boolean compulsory;
	private String label;
	
	private Input(String label, boolean compulsory) {
		this.label = label;
		this.compulsory = compulsory;
	}
	
	public boolean isCompulsory() {
		return compulsory;
	}
	public void setCompulsory(boolean compulsory) {
		this.compulsory = compulsory;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}

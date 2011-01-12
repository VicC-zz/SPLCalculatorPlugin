package edu.bth.spla.calculator.model;

public enum Operation {
	ARITHMETIC("Arithmetic operations",true),
	ABS("Absolute Value", false),
	POW("Power", false),
	EXP("Exponential", false),
	SQRT("Square Root", false);
	private String label;
	private boolean compulsory;
	private Operation(String label, boolean compulsory) {
		this.label = label;
		this.compulsory = compulsory;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isCompulsory() {
		return compulsory;
	}

	public void setCompulsory(boolean compulsory) {
		this.compulsory = compulsory;
	}
	
}

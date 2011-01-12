package edu.bth.spla.calculator.model;

public enum Output{
	ONE_ROW ("One row display"), TWO_ROW("Two row display");
	private String label;
	private Output(String label) {
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}

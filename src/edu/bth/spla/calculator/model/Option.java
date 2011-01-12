package edu.bth.spla.calculator.model;

public class Option {
	private boolean selected;
	private String label;
	private Object data;
	private String description;
	private boolean compulsory;
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String name) {
		this.label = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompulsory() {
		return compulsory;
	}

	public void setCompulsory(boolean compulsory) {
		this.selected = compulsory;
		this.compulsory = compulsory;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}

package edu.bth.spla.calculator.model;

public enum Theme {
	APPLE(Type.CHILD, "Apple Theme", true, "apple.png", "7A7A7A", "1A0099",
			"CCFF33", "FF0000"), 
	STRAWBERRY(Type.CHILD, "Strawberry Theme",	false, "strawberry.png", "7A7A7A",
			"1A0099", "CCFF33", "FF0000"), 
	CLASSIC(Type.ADULT, "Classic Theme", true, "", "7A7A7A", "1A0099",
			"CCFF33", "FF0000");

	private Type type;
	private String label;
	private boolean defaultSelection;
	private String bgImage;
	private String bgColor;
	private String fgButton;
	private String bgDisplay;
	private String fgDisplay;

	private Theme(Type type, String label, boolean defaultSelection,
			String bgImage, String bgColor, String fgButton, String bgDisplay,
			String fgDisplay) {
		this.type = type;
		this.label = label;
		this.defaultSelection = defaultSelection;
		this.bgImage = bgImage;
		this.bgColor = bgColor;
		this.fgButton = fgButton;
		this.bgDisplay = bgDisplay;
		this.fgDisplay = fgDisplay;

	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isDefaultSelection() {
		return defaultSelection;
	}

	public void setDefaultSelection(boolean defaultSelection) {
		this.defaultSelection = defaultSelection;
	}

	public String getBgImage() {
		return bgImage;
	}

	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getFgButton() {
		return fgButton;
	}

	public void setFgButton(String fgButton) {
		this.fgButton = fgButton;
	}

	public String getBgDisplay() {
		return bgDisplay;
	}

	public void setBgDisplay(String bgDisplay) {
		this.bgDisplay = bgDisplay;
	}

	public String getFgDisplay() {
		return fgDisplay;
	}

	public void setFgDisplay(String fgDisplay) {
		this.fgDisplay = fgDisplay;
	}
}

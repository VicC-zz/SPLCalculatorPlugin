package edu.bth.spla.calculator.model;

public enum CalculatorClassInfo {
	BUILD("build","",FileType.xml),
	CALCULATOR ("Calculator", "com.spl.gui", FileType.java),
	IMAGE_PANEL ("ImagePanel", "com.spl.gui", FileType.java),
	THEME ("Theme", "com.spl.gui", FileType.java),
	IINPUT_VIEW ("IInputView","com.spl.input", FileType.java),
	INPUT_VIEW ("InputView","com.spl.input", FileType.java),
	INPUT_MANAGER ("InputManager","com.spl.input", FileType.java),
	ILOGICAL_MANAGER ("ILogicalManager","com.spl.math", FileType.java),
	LOGICAL_MANAGER ("LogicalManager","com.spl.math", FileType.java),
	PARSER("Parser","com.spl.math", FileType.java),
	IMODEL("IModel","com.spl.model", FileType.java),
	MODEL("Model","com.spl.model", FileType.java),
	MODEL_OBSERVER("ModelObserver","com.spl.model", FileType.java),
	CONFIG_READER("ConfigReader","com.spl.properties", FileType.java),
	OPERATIONS("operations", "com.spl.properties", FileType.properties),
	SYMBOLS("symbols", "com.spl.properties", FileType.properties),
	THEME_PROPERTIES("theme", "com.spl.properties", FileType.properties),
	DATA_TYPE("data_type", "com.spl.properties", FileType.properties)
	;
	private String className;
	private String packageName;
	private FileType fileType;
	
	CalculatorClassInfo(String className, String packageName, FileType fileType) {
		this.className = className;
		this.packageName = packageName;
		this.fileType = fileType;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
}

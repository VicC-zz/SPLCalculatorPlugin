package edu.bth.spla.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {
	private Type type;
	private Theme theme;
	private List<Operation> operations;
	private Output output;
	private List<Input> input = new ArrayList<Input>();
	private String outputDirectory;
	private CodeLanguage codeLanguage;
	
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public Output getOutput() {
		return output;
	}
	public void setOutput(Output output) {
		this.output = output;
	}
	public List<Input> getInput() {
		return input;
	}
	public void setInput(List<Input> input) {
		this.input = input;
	}
	public String getOutputDirectory() {
		return outputDirectory;
	}
	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}
	public CodeLanguage getCodeLanguage() {
		return codeLanguage;
	}
	public void setCodeLanguage(CodeLanguage codeLanguage) {
		this.codeLanguage = codeLanguage;
	}
}

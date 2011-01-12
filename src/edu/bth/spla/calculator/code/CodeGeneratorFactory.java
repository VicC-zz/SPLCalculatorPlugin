package edu.bth.spla.calculator.code;

import edu.bth.spla.calculator.code.java.JavaCodeGenerator;
import edu.bth.spla.calculator.model.CodeLanguage;

public class CodeGeneratorFactory {
	public CodeGenerator create(CodeLanguage type){
		switch (type) {
		case JAVA:
			return new JavaCodeGenerator();
		default:
			break;
		}
		return null;
	}
}

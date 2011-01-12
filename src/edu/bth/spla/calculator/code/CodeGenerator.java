package edu.bth.spla.calculator.code;

import java.io.IOException;

import edu.bth.spla.calculator.model.CalculatorModel;

public interface CodeGenerator {
	void generate(CalculatorModel calculatorModel) throws IOException;
	void build(CalculatorModel calculatorModel);
}

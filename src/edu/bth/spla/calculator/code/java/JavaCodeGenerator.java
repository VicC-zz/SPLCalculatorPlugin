package edu.bth.spla.calculator.code.java;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

import edu.bth.spla.calculator.code.CodeGenerator;
import edu.bth.spla.calculator.model.CalculatorClassInfo;
import edu.bth.spla.calculator.model.CalculatorModel;
import edu.bth.spla.calculator.model.Type;
import edu.bth.spla.calculator.util.FileUtil;

public class JavaCodeGenerator implements CodeGenerator {
	public void generate(CalculatorModel calculatorModel) throws IOException {
		String dir = calculatorModel.getOutputDirectory();
		generateFile(dir, CalculatorClassInfo.BUILD, new TBuild()
				.generate(calculatorModel));
		dir = dir + "/src";
		generateFile(dir, CalculatorClassInfo.CALCULATOR, new TCalculator()
				.generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.IMAGE_PANEL, new TImagePanel()
		.generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.THEME, new TTheme()
				.generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.IINPUT_VIEW, new TIInputView()
				.generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.INPUT_MANAGER,
				new TInputManager().generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.ILOGICAL_MANAGER,
				new TILogicalManager().generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.LOGICAL_MANAGER,
				new TLogicalManager().generate(calculatorModel));
		if(calculatorModel.getType().equals(Type.ADULT)){
		generateFile(dir, CalculatorClassInfo.PARSER, new TParser()
				.generate(calculatorModel));
		}
		generateFile(dir, CalculatorClassInfo.IMODEL, new TIModel()
				.generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.MODEL, new TModel()
				.generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.MODEL_OBSERVER,
				new TModelObserver().generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.CONFIG_READER,
				new TConfigReader().generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.OPERATIONS, new TOperations()
				.generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.SYMBOLS, new TSymbols()
				.generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.THEME_PROPERTIES, new TThemeProperties()
				.generate(calculatorModel));
		generateFile(dir, CalculatorClassInfo.DATA_TYPE, new TdataType()
				.generate(calculatorModel));
	}

	private void generateFile(String dir, CalculatorClassInfo calc, String code)
			throws IOException {
		File outputFile;
		outputFile = FileUtil.createFile(dir, calc.getPackageName(), calc
				.getClassName(), calc.getFileType().toString());
		FileUtil.writeFile(outputFile, code);
	}

	@Override
	public void build(CalculatorModel calculatorModel) {
		StringBuilder stringBuilder = new StringBuilder(calculatorModel
				.getOutputDirectory());
		stringBuilder.append("/").append(
				CalculatorClassInfo.BUILD.getClassName()).append(".").append(
				CalculatorClassInfo.BUILD.getFileType());
		File buildFile = new File(stringBuilder.toString());
		Project p = new Project();
		p.setUserProperty("ant.file", buildFile.getAbsolutePath());
		DefaultLogger consoleLogger = new DefaultLogger();
		consoleLogger.setErrorPrintStream(System.err);
		consoleLogger.setOutputPrintStream(System.out);
		consoleLogger.setMessageOutputLevel(Project.MSG_INFO);
		p.addBuildListener(consoleLogger);
		p.fireBuildStarted();
		p.init();
		ProjectHelper helper = ProjectHelper.getProjectHelper();
		p.addReference("ant.projectHelper", helper);
		helper.parse(p, buildFile);
		p.executeTarget(p.getDefaultTarget());
		p.fireBuildFinished(null);
	}
}

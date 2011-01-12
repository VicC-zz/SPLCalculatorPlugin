package edu.bth.spla.calculator.wizards;

import java.io.File;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;

import edu.bth.spla.calculator.code.CodeGenerator;
import edu.bth.spla.calculator.code.CodeGeneratorFactory;
import edu.bth.spla.calculator.model.CalculatorModel;
import edu.bth.spla.calculator.model.Type;
import edu.bth.spla.calculator.pages.GenerateProductPage;
import edu.bth.spla.calculator.pages.SelectCalculatorTypePage;
import edu.bth.spla.calculator.pages.SelectInputDevicePage;
import edu.bth.spla.calculator.pages.SelectOperationsPage;
import edu.bth.spla.calculator.pages.SelectOutputStylePage;
import edu.bth.spla.calculator.pages.SelectThemePage;
import edu.bth.spla.calculator.util.FileUtil;

/**
 * Defines the wizard used by the user to generate the Search Engine Page
 * Application
 * 
 * @author German
 */
public class CalculatorGenerationWizard extends Wizard {
	public static final String GENERATE_PRODUCT = "GenerateProduct";
	public static final String CALCULATOR_THEME_SELECTION = "CalculatorThemeSelection";
	public static final String SELECT_OUTPUT_STYLE = "SelectOutputStyle";
	public static final String CALCULATOR_DATA_TYPES_SELECTION = "CalculatorDataTypesSelection";
	public static final String CALCULATOR_OPERATIONS_SELECTION = "CalculatorOperationsSelection";
	public static final String CALCULATOR_TYPE_SELECTION = "CalculatorTypeSelection";

	private CalculatorModel calculator;

	private SelectCalculatorTypePage selectCalculatorTypePage;
	private SelectOperationsPage selectOperationsPage;
	private SelectInputDevicePage selectInputDevicePage;
	private SelectOutputStylePage selectOutputStylePage;
	private SelectThemePage selectThemePage;
	private GenerateProductPage generateProductPage;

	public CalculatorGenerationWizard() {
		calculator = new CalculatorModel();
	}

	@Override
	public boolean performFinish() {
		CodeGenerator codeGenerator = new CodeGeneratorFactory()
				.create(calculator.getCodeLanguage());
		try {
			FileUtil.copyResource("bsh-2.0b4.jar", calculator.getOutputDirectory());
			FileUtil.copyResource("runme.bat", calculator.getOutputDirectory());
			if(calculator.getType().equals(Type.CHILD)){
				FileUtil.copyResource(calculator.getTheme().getBgImage(), calculator.getOutputDirectory());				
			}
			codeGenerator.generate(calculator);
			codeGenerator.build(calculator);
			MessageDialog.openInformation(this.getContainer().getShell(),
					"Code Generation",
					"The code was succesfully generated at: "
							+ calculator.getOutputDirectory());
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog
					.openError(this.getContainer().getShell(),
							"Code Generation",
							"An error have taken place in code geneation, " +
							"the code was not generated: ");
		}
		return true;
	}

	@Override
	public void addPages() {
		selectCalculatorTypePage = new SelectCalculatorTypePage(
				CALCULATOR_TYPE_SELECTION);
		addPage(selectCalculatorTypePage);
		selectOperationsPage = new SelectOperationsPage(
				CALCULATOR_OPERATIONS_SELECTION);
		addPage(selectOperationsPage);
		selectInputDevicePage = new SelectInputDevicePage(
				CALCULATOR_DATA_TYPES_SELECTION);
		addPage(selectInputDevicePage);
		selectOutputStylePage = new SelectOutputStylePage(SELECT_OUTPUT_STYLE);
		addPage(selectOutputStylePage);
		selectThemePage = new SelectThemePage(CALCULATOR_THEME_SELECTION);
		addPage(selectThemePage);
		generateProductPage = new GenerateProductPage(GENERATE_PRODUCT);
		addPage(generateProductPage);
	}

	public CalculatorModel getCalculator() {
		return calculator;
	}

	public void setCalculator(CalculatorModel calculator) {
		this.calculator = calculator;
	}
}

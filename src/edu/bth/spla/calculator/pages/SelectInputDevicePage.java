package edu.bth.spla.calculator.pages;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import edu.bth.spla.calculator.components.OptionTable;
import edu.bth.spla.calculator.model.Input;
import edu.bth.spla.calculator.model.Operation;
import edu.bth.spla.calculator.model.Option;
import edu.bth.spla.calculator.model.Theme;
import edu.bth.spla.calculator.wizards.CalculatorGenerationWizard;


/**
 * @author German
 *
 */
public class SelectInputDevicePage extends WizardPage {
	private CalculatorGenerationWizard wizard;
	private OptionTable inputDeviceTable;
	
	/**
	 * @param pageName
	 * @param searchEngineInputModel
	 */
	public SelectInputDevicePage(String pageName) {
		super(pageName);
		setTitle("Input Device Selection");
		setDescription("In this step you can select input device...");
	}
	
	@Override
	public IWizardPage getNextPage() {
		List<Input> operations = new ArrayList<Input>();
		for (Option option : inputDeviceTable.getItems()) {
			if (option.isSelected()) {
				operations.add((Input) option.getData());
			}
		}
		wizard.getCalculator().setInput(operations);
		return super.getNextPage();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite container) {
		wizard = (CalculatorGenerationWizard) this.getWizard();
		Group localContainer = new Group(container, SWT.None);
		GridLayout localLayout = new GridLayout();
		localLayout.numColumns = 1;
		localContainer.setLayout(localLayout);
		
		inputDeviceTable = new OptionTable(localContainer, SWT.NONE);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		inputDeviceTable.setLayoutData(gridData);
		loadItems();
		setControl(localContainer);
	}
	
	private  void loadItems(){
		Option option;
		for (Input input : Input.values()) {
			option = new Option();
			option.setLabel(input.getLabel());
			option.setData(input);
			option.setCompulsory(input.isCompulsory());
			inputDeviceTable.addItem(option);
		}
	}
	

}

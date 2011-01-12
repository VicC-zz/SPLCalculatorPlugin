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
import edu.bth.spla.calculator.model.Operation;
import edu.bth.spla.calculator.model.Option;
import edu.bth.spla.calculator.wizards.CalculatorGenerationWizard;


/**
 * @author German
 *
 */
public class SelectOperationsPage extends WizardPage {
	
	private OptionTable operationTable;
	private CalculatorGenerationWizard wizard;
	
	/**
	 * @param pageName
	 */
	public SelectOperationsPage(String pageName) {
		super(pageName);
		setTitle("Operations Selection");
		setDescription("In this step you can select the operations...");
	}
	
	@Override
	public IWizardPage getNextPage() {
		List<Operation> operations = new ArrayList<Operation>();
		for (Option option : operationTable.getItems()) {
			if (option.isSelected()) {
				operations.add((Operation) option.getData());
			}
		}
		wizard.getCalculator().setOperations(operations);
		return super.getNextPage();
	}
	
	@Override
	public void createControl(Composite container) {
		wizard = (CalculatorGenerationWizard) this.getWizard();
		Group localContainer = new Group(container, SWT.None);
		GridLayout localLayout = new GridLayout();
		localLayout.numColumns = 1;
		localContainer.setLayout(localLayout);
		
		operationTable = new OptionTable(localContainer, SWT.NONE);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		operationTable.setLayoutData(gridData);
		loadItems();
		setControl(localContainer);
	}
	
	private  void loadItems(){
		Option option;
		for (Operation operation : Operation.values()) {
			option = new Option();
			option.setLabel(operation.getLabel());
			option.setData(operation);
			option.setCompulsory(operation.isCompulsory());
			operationTable.addItem(option);
		}
	}

}

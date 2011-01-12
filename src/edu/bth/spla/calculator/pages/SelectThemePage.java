package edu.bth.spla.calculator.pages;
import java.util.List;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import edu.bth.spla.calculator.components.OptionTable;
import edu.bth.spla.calculator.model.Option;
import edu.bth.spla.calculator.model.Theme;
import edu.bth.spla.calculator.wizards.CalculatorGenerationWizard;


/**
 * @author German
 *
 */
public class SelectThemePage extends WizardPage {
	
	private OptionTable themeTable;
	private CalculatorGenerationWizard wizard;
	/**
	 * @param pageName
	 * @param searchEngineInputModel
	 */
	public SelectThemePage(String pageName) {
		super(pageName);
		setTitle("Theme Selection");
		setDescription("In this step you can select the theme...");
	}
	
	
	
	@Override
	public IWizardPage getNextPage() {
		for (Option option : themeTable.getItems()) {
			if(option.isSelected()){
				wizard.getCalculator().setTheme((Theme) option.getData());
				break;
			}
		}
		return super.getNextPage();
	}
	
	@Override
	public IWizardPage getPreviousPage() {
		
		return super.getPreviousPage();
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
		
		themeTable = new OptionTable(localContainer, SWT.NONE);
		GridData methodsCompositeGridData = new GridData();
		methodsCompositeGridData.horizontalAlignment = GridData.FILL;
		methodsCompositeGridData.grabExcessHorizontalSpace = true;
		methodsCompositeGridData.verticalAlignment = GridData.CENTER;
		themeTable.setLayoutData(methodsCompositeGridData);
		themeTable.setSingleSelection(true);
		setControl(localContainer);
	}
	
	public void updateThemesList(List<Theme> themes){
		Option option;
		themeTable.clear();
		for (Theme theme : themes) {
			option = new Option();
			option.setLabel(theme.getLabel());
			option.setData(theme);
			option.setSelected(theme.isDefaultSelection());
			themeTable.addItem(option);
		}
	}
	
	
	
}

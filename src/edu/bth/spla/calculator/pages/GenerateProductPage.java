package edu.bth.spla.calculator.pages;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;

import edu.bth.spla.calculator.components.DirectorySelectorComposite;
import edu.bth.spla.calculator.model.CodeLanguage;
import edu.bth.spla.calculator.wizards.CalculatorGenerationWizard;


/**
 * @author German
 *
 */
public class GenerateProductPage extends WizardPage implements Listener{
	
	private CalculatorGenerationWizard wizard;
	private DirectorySelectorComposite directorySelectorComposite;
	
	/**
	 * @param pageName
	 * @param searchEngineInputModel
	 */
	public GenerateProductPage(String pageName) {
		super(pageName);
		setTitle("Product Generation");
		setDescription("In this step you can select the output directory for the code and proceed with the generation...");
	}
	
	@Override
	public IWizardPage getNextPage() {
		wizard.getCalculator().setOutputDirectory(directorySelectorComposite.getDirectory());
		return super.getNextPage();
	}
	
	@Override
	public IWizardPage getPreviousPage() {
		// TODO Auto-generated method stub
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
		directorySelectorComposite = new DirectorySelectorComposite(localContainer, SWT.NONE);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		directorySelectorComposite.setLayoutData(gridData);
		directorySelectorComposite.setContainer(wizard.getContainer());
		setControl(localContainer);
		
	}
	
	@Override
	public boolean isPageComplete() {
		if(!directorySelectorComposite.getDirectory().trim().equals("")){
			wizard.getCalculator().setCodeLanguage(CodeLanguage.JAVA);
			return true;
		}
		return false;
	}

	@Override
	public void handleEvent(Event arg0) {
		
		
	}

	
}

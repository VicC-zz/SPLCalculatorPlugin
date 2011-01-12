package edu.bth.spla.calculator.pages;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;

import edu.bth.spla.calculator.model.Input;
import edu.bth.spla.calculator.model.Operation;
import edu.bth.spla.calculator.model.Output;
import edu.bth.spla.calculator.model.Theme;
import edu.bth.spla.calculator.model.Type;
import edu.bth.spla.calculator.wizards.CalculatorGenerationWizard;


/**
 * @author German
 *
 */
public class SelectCalculatorTypePage extends WizardPage implements Listener {
	
	private CalculatorGenerationWizard wizard;

	/**
	 * @param pageName
	 * @param searchEngineInputModel
	 */
	public SelectCalculatorTypePage(String pageName) {
		super(pageName);
		setTitle("Calculator Type Selection");
		setDescription("In this step you can select the type of calculator...");
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite container) {
		wizard = (CalculatorGenerationWizard) this.getWizard();
		Group localContainer = new Group(container, SWT.NONE);
		FillLayout localFillLayout = new FillLayout();
		localFillLayout.type = SWT.VERTICAL;
		localContainer.setLayout(localFillLayout);		
		Button button;
		for (Type type : Type.values()) {
			button = new Button(localContainer, SWT.RADIO);
			button.setText(type.getLabel());
			button.setData(type);
			button.addListener(SWT.Selection, this);
		}
		setControl(localContainer);
	}
	
	@Override
	public IWizardPage getNextPage() {
		SelectThemePage themePage = (SelectThemePage) wizard.getPage(CalculatorGenerationWizard.CALCULATOR_THEME_SELECTION);
		themePage.updateThemesList(getThemes());
		if(wizard.getCalculator().getType()!=null &&
				wizard.getCalculator().getType().equals(Type.CHILD)){
			List<Operation> operations = new ArrayList<Operation>();
			operations.add(Operation.ARITHMETIC);
			wizard.getCalculator().setOperations(operations);
			List<Input> input = new ArrayList<Input>();
			input.add(Input.MOUSE);
			wizard.getCalculator().setInput(input);
			wizard.getCalculator().setOutput(Output.ONE_ROW);
			return themePage;
		}
		return super.getNextPage();
	}
	
	@Override
	public IWizardPage getPreviousPage() {
		// TODO Auto-generated method stub
		return super.getPreviousPage();
	}
	
	
	
	@Override
	public boolean isPageComplete() {
		return true;
	}

	@Override
	public void handleEvent(Event arg0) {
		Button button = (Button) arg0.widget;
		wizard.getCalculator().setType((Type)button.getData());
	}
	
	private List<Theme> getThemes(){
		List<Theme> themes = new ArrayList<Theme>();
		for (Theme theme : Theme.values()) {
			if(theme.getType().equals(wizard.getCalculator().getType())){
				themes.add(theme);				
			}
		}
		return themes;
	}

}

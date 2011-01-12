package edu.bth.spla.calculator.pages;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;

import edu.bth.spla.calculator.model.Output;
import edu.bth.spla.calculator.model.Type;
import edu.bth.spla.calculator.wizards.CalculatorGenerationWizard;

/**
 * @author German
 * 
 */
public class SelectOutputStylePage extends WizardPage implements Listener {

	private CalculatorGenerationWizard wizard;

	/**
	 * @param pageName
	 * @param searchEngineInputModel
	 */
	public SelectOutputStylePage(String pageName) {
		super(pageName);
		setTitle("Output Selection");
		setDescription("In this step you can select the output style...");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite container) {
		wizard = (CalculatorGenerationWizard) this.getWizard();
		Group localContainer = new Group(container, SWT.NONE);
		FillLayout localFillLayout = new FillLayout();
		localFillLayout.type = SWT.VERTICAL;
		localContainer.setLayout(localFillLayout);
		Button button;
		for (Output output : Output.values()) {
			button = new Button(localContainer, SWT.RADIO);
			button.setText(output.getLabel());
			button.setData(output);
			button.addListener(SWT.Selection, this);
		}
		setControl(localContainer);
	}

	@Override
	public boolean isPageComplete() {
		if (wizard.getCalculator().getOutput() != null) {
			return true;
		}
		return false;
	}

	@Override
	public void handleEvent(Event arg0) {
		Button button = (Button) arg0.widget;
		wizard.getCalculator().setOutput((Output) button.getData());
		wizard.getContainer().updateButtons();
	}
}

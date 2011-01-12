package edu.bth.spla.calculator.components;

import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;

import edu.bth.spla.calculator.model.CalculatorModel;
import edu.bth.spla.calculator.wizards.CalculatorGenerationWizard;

public class DirectorySelectorComposite extends Composite {
	private Group directoryGroup = null;
	private Label directorylabel = null;
	private Text directoryText = null;
	private Button browseDirectoryButton = null;
	private IWizardContainer container;
	
	public DirectorySelectorComposite(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		createDirectoryGroup();
		setSize(new Point(300, 200));
		setLayout(new GridLayout());
	}

	/**
	 * This method initializes directoryGroup	
	 *
	 */
	private void createDirectoryGroup() {
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.grabExcessHorizontalSpace = true;
		gridData4.verticalAlignment = GridData.CENTER;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		directoryGroup = new Group(this, SWT.NONE);
		directoryGroup.setText("Output Folder");
		directoryGroup.setLayoutData(gridData);
		directoryGroup.setLayout(gridLayout);
		directorylabel = new Label(directoryGroup, SWT.NONE);
		directorylabel.setText("Folder");
		directoryText = new Text(directoryGroup, SWT.BORDER);
		directoryText.setLayoutData(gridData4);
		browseDirectoryButton = new Button(directoryGroup, SWT.NONE);
		browseDirectoryButton.setText("Search");
		browseDirectoryButton
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
						openDirectorySearch();
						container.updateButtons();
					}
				});
	}

	
	private void openDirectorySearch(){
		DirectoryDialog directoryDialog = new DirectoryDialog(this.getShell());
		directoryText.setText(directoryDialog.open());
	}
	
	public String getDirectory(){
		return directoryText.getText();
	}

	public IWizardContainer getContainer() {
		return container;
	}

	public void setContainer(IWizardContainer container) {
		this.container = container;
	}
	
}

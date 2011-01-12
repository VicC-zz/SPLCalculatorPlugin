package edu.bth.spla.calculator.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import edu.bth.spla.calculator.Activator;
import edu.bth.spla.calculator.ImagesMgr;
import edu.bth.spla.calculator.model.Option;


public class OptionTable extends Composite {

	private List<Option> optionTableElements = new ArrayList<Option>();  //  @jve:decl-index=0:
	
	private int selectedItem = 0;
	private boolean singleSelection;
	
	private static final String SELECTION = "Select";
	private static final String NAME = "Name";
	
	
	private String[] columnNames = {SELECTION,NAME};
	private Table optionTable = null;
	private TableViewer tableViewer = null;

	public OptionTable(Composite parent, int style) {
		super(parent, style);
		initialize();
		tableViewer.setInput(optionTableElements);
	}

	private void initialize() {
		GridData optionTableGridData = new GridData();
		optionTableGridData.horizontalAlignment = GridData.FILL;
		optionTableGridData.grabExcessHorizontalSpace = true;
		optionTableGridData.verticalAlignment = GridData.CENTER;
		optionTableGridData.heightHint = 100;
		optionTable = new Table(this, SWT.BORDER);
		optionTable.setHeaderVisible(true);
		optionTable.setLayoutData(optionTableGridData);
		optionTable.setLinesVisible(true);
		TableColumn tableColumn = new TableColumn(optionTable, SWT.NONE);
		tableColumn.setWidth(60);
		tableColumn.setText(SELECTION);
		TableColumn tableColumn1 = new TableColumn(optionTable, SWT.NONE);
		tableColumn1.setWidth(180);
		tableColumn1.setText(NAME);
		
		
		//Conjunto de celdas que tendrn propiedades de edicion de contenido
		CellEditor[] cellEditors = new CellEditor[columnNames.length];
		//Celda con comportamiento de edicion de checkbox
		cellEditors[0] = new CheckboxCellEditor(optionTable);
		tableViewer = new TableViewer(optionTable);
		tableViewer.setColumnProperties(columnNames);
		tableViewer.setCellEditors(cellEditors);
		tableViewer.setContentProvider(new OptionContentProvider());
		tableViewer.setCellModifier(new OptionTableCellModifier());
		tableViewer.setLabelProvider(new OptionTableLabelProvider());
		setSize(new Point(300, 200));
		setLayout(new GridLayout());
	}
	/*
	 * Clase que provee los contenidos que son mostrados y editados por el table viewer
	 */
	private class OptionContentProvider implements IStructuredContentProvider{
		public Object[] getElements(Object inputElement) {
			return optionTableElements.toArray();
		}

		public void dispose() {
			
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			
		}
	}
	/*
	 * Clase que provee el contenido visual para cada una de las celdas de la tabla
	 */
	class OptionTableLabelProvider extends LabelProvider implements ITableLabelProvider{
		/**
		 * Retorna la imagen asociada al elemento/columna o null si
		 * no hay ninguna imagen para mostrar, de acuerdo con la informacion
		 * del modelo 
		 * @return {@link Image}
		 */
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				Option methodModel = (Option) element;
				if (methodModel.isSelected()) {
					return Activator.getDefault().getImageRegistry().get(ImagesMgr.CHECKED_IMAGE);
				}
				return  Activator.getDefault().getImageRegistry().get(ImagesMgr.UNCHECKED_IMAGE);
			}
			return null;
		}
		/**
		 * Retorna el texto asociada al elemento/columna o null si
		 * no hay ninguna imagen para mostrar, de acuerdo con la informacion
		 * del modelo  
		 * @return texto de columna
		 */
		public String getColumnText(Object element, int columnIndex) {
			Option methodModel = (Option) element;
			switch (columnIndex) {
			case 1:
				return methodModel.getLabel();
			}
			return null;
		}
		
	}
	/*
	 * Realiza operaciones de actualizacion y consulta del modelo, de acuerdo con los
	 * eventos y cambios presentados en la tabla
	 */
	class OptionTableCellModifier implements ICellModifier{
		/**
		 * Indica cuando una celda puede ser modificado
		 */
		public boolean canModify(Object element, String property) {
			return true;
		}
		/**
		 * Obtiene el valor de un asociado a un campo especifico en el modelo
		 * @param element - modelo asociado
		 * @param property - campo
		 */
		public Object getValue(Object element, String property) {
			int columnIndex = Arrays.asList(tableViewer.getColumnProperties()).indexOf(property);
			Option methodModel = (Option) element;
			switch (columnIndex) {
			case 0:
				return new Boolean(methodModel.isSelected());
			case 1:
				return methodModel.getLabel();
			}
			return "";
		}
		/**
		 * Modifica el valor de un campo especifico en el modelo, de acuerdo al valor
		 * que se definio desde la tabla
		 * @param element - modelo asociado
		 * @param property - campo
		 * @param value - valor para asignar
		 */
		public void modify(Object element, String property, Object value) {
			int columnIndex = Arrays.asList(tableViewer.getColumnProperties()).indexOf(property);
			TableItem tableItem = (TableItem) element;
			Option optionModel = (Option) tableItem.getData();
			if(optionModel.isCompulsory()){
				return;
			}
			switch (columnIndex) {
			case 0:
				if(value == null){
					value = new Boolean(false);
				}
				if (singleSelection && !(Boolean) value) {
					return;
				}	
				if (singleSelection && selectedItem != -1) {
					optionTableElements.get(selectedItem).setSelected(
							false);
				}
				optionModel.setSelected((Boolean) value);
				selectedItem = optionTableElements.indexOf(optionModel);
				notifyItemSelection(SWT.Selection, new Event(){	
				});			
				break;
			case 1:
				optionModel.setLabel((String) value);
				break;
			}
			tableViewer.setInput(optionTableElements);
		}
		
	}
	/**
	 * Adiciona un nuevo modelo a la tabla y la refresca
	 * @param model
	 */
	public void addItem(Option model){
		optionTableElements.add(model);
		tableViewer.setInput(optionTableElements);
	}
	/**
	 * Remueve un nuevo modelo a la tabla y la refresca
	 * @param model
	 */
	public void removeItem(int index){
		optionTableElements.remove(index);
		tableViewer.setInput(optionTableElements);
	}
	/**
	 * Redefine los elementos de la tabla y la refresca
	 * @param items - nuevo conjunto de elementos
	 */
	public void setItems(List<Option> items){
		optionTableElements = items;
		tableViewer.setInput(optionTableElements);
	}
	
	/**
	 * Remueve el campo seleccionado en la tabla
	 */
	public void removeSelected(){
		if(selectedItem != -1){
			removeItem(selectedItem);
			selectedItem = -1;
		}
	}
	
	private void notifyItemSelection(int eventType, Event event){
		notifyListeners(eventType, event);
	}

	public List<Option> getItems() {
		return optionTableElements;
	}
	
	public void clear(){
		optionTableElements.clear();
		tableViewer.setInput(optionTableElements);
	}

	public boolean isSingleSelection() {
		return singleSelection;
	}

	public void setSingleSelection(boolean singleSelection) {
		this.singleSelection = singleSelection;
	}
	
}
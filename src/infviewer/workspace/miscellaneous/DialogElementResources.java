/***********************************************************************
 * Module:  DialogElementResources.java
 * Author:  DUCA
 * Purpose: Defines the Class DialogElementResources
 ***********************************************************************/

package infviewer.workspace.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import infviewer.workspace.model.Column;
import infviewer.workspace.view.BooleanElement;
import infviewer.workspace.view.CharElement;
import infviewer.workspace.view.DateElement;
import infviewer.workspace.view.DateRangeElement;
import infviewer.workspace.view.DialogElement;
import infviewer.workspace.view.DialogElementInterface;
import infviewer.workspace.view.FloatElement;
import infviewer.workspace.view.FloatRangeElement;
import infviewer.workspace.view.IntegerElement;
import infviewer.workspace.view.IntegerRangeElement;
import infviewer.workspace.view.RangeElement.StartEndPoints;
import infviewer.workspace.view.VarcharElement;

/** @pdOid 387d941b-f564-407c-a48c-3d51368f03e8 */
public class DialogElementResources {
   /** @pdOid 34cd2bdc-9809-4d86-9618-6b6980f3cf27 */
   private Map<String, DialogElement> createDialogMap = new HashMap<String, DialogElement>();
   /** @pdOid d83ba23d-8ebe-4a49-9261-004e8092c793 */
   private Map<String, List<DialogElementInterface>> searchDialogMap = new HashMap<String, List<DialogElementInterface>>();
   
   public DialogElementResources(Column column) {
	   	createDialogMap.put("varchar", new VarcharElement(column.getLength(), column.isMandatory(), column.getLabel()));
	   	createDialogMap.put("char", new CharElement(column.getLength(), column.isMandatory(), column.getLabel()));
		createDialogMap.put("int", new IntegerElement(column.isMandatory(), column.getLength(), column.getLabel()));
		createDialogMap.put("smallint", new IntegerElement(column.isMandatory(), column.getLength(), column.getLabel()));
	   	createDialogMap.put("decimal", new FloatElement(column.isMandatory(), column.getLength(), column.getPrecision(), column.getLabel()));
	   	createDialogMap.put("bit", new BooleanElement(column.isMandatory(), column.getLabel()));
	   	createDialogMap.put("datetime", new DateElement(column.isMandatory(), column.getLabel()));
	   	
	   	List<DialogElementInterface> varcharElements = new ArrayList<>();
	   	List<DialogElementInterface> charElements = new ArrayList<>();
	   	List<DialogElementInterface> integerElements = new ArrayList<>();
	   	List<DialogElementInterface> floatElements = new ArrayList<>();
	   	List<DialogElementInterface> booleanElements = new ArrayList<>();
	   	List<DialogElementInterface> dateElements = new ArrayList<>();
	   	
	   	varcharElements.add(new VarcharElement(column.getLength(), false, column.getLabel()));
	   	charElements.add(new CharElement(column.getLength(), false, column.getLabel()));
	   	integerElements.add(new IntegerRangeElement(StartEndPoints.MIN, column.getLength()));
	   	integerElements.add(new IntegerRangeElement(StartEndPoints.MAX, column.getLength()));
	   	floatElements.add(new FloatRangeElement(StartEndPoints.MIN, column.getLength(), column.getPrecision()));
	   	floatElements.add(new FloatRangeElement(StartEndPoints.MAX, column.getLength(), column.getPrecision()));
	   	booleanElements.add(new BooleanElement(false, column.getLabel()));
	   	dateElements.add(new DateRangeElement(StartEndPoints.START));
	   	dateElements.add(new DateRangeElement(StartEndPoints.END));

	   	searchDialogMap.put("varchar", varcharElements);
	   	searchDialogMap.put("char", charElements);
	   	searchDialogMap.put("int", integerElements);
	   	searchDialogMap.put("smallint", integerElements);
	   	searchDialogMap.put("decimal", floatElements);
	   	searchDialogMap.put("bit", booleanElements);
	   	searchDialogMap.put("datetime", dateElements);

	   }
   
	public Map<String, DialogElement> getCreateDialogMap() {
		
		return createDialogMap;
	}
		
	public Map<String, List<DialogElementInterface>> getSearchDialogMap() {
		return searchDialogMap;
	}
	
}
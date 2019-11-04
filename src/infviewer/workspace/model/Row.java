/***********************************************************************
 * Module:  Row.java
 * Author:  Jovic
 * Purpose: Defines the Class Row
 ***********************************************************************/

package infviewer.workspace.model;

import java.util.ArrayList;
import java.util.List;

import infviewer.tree.model.Table;

/** @pdOid 1acaacb6-5fad-4c19-be85-0e295cfc85e7 */
public class Row {
   /** @pdOid d68e6f51-221c-4994-a631-715a7fa95a86 */
   private List<Object> fields = new ArrayList<>();
   
   /** @pdRoleInfo migr=no name=Table assc=tabelaAgregiraRedove mult=1..1 side=A */
   public Table owner;
   
   
   /** @pdGenerated default parent getter */
   public Table getOwner() {
      return owner;
   }
   
   /** @pdGenerated default parent setter
     * @param newTable */
   public void setOwner(Table newTable) {
      if (this.owner == null || !this.owner.equals(newTable))
      {
         if (this.owner != null)
         {
            Table oldTable = this.owner;
            this.owner = null;
            oldTable.removeRows(this);
         }
         if (newTable != null)
         {
            this.owner = newTable;
            this.owner.addRows(this);
         }
      }
   }

	public boolean addField(Object arg0) {
		if (fields == null)
		{
			fields = new ArrayList<>();
		}
		return fields.add(arg0);
	}
	
	public List<Object> getFields(){
		return this.fields;
	}

}
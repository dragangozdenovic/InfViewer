/***********************************************************************
 * Module:  Table.java
 * Author:  Jovic
 * Purpose: Defines the Class Table
 ***********************************************************************/

package infviewer.tree.model;

import infviewer.model.Element;
import infviewer.workspace.model.Column;
import infviewer.workspace.model.Row;

/** @pdOid 4f7b41f7-2a45-49af-8608-9d6d31b033a8 */
public class Table extends Element {   
   /** @pdRoleInfo migr=no name=ForeignKey assc=tabelaAgregiraStraneKljuceve coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition */
   private java.util.List<ForeignKey> foreignkeys;
   /** @pdRoleInfo migr=no name=Column assc=tabelaAgregiraKolone coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition */
   private java.util.List<Column> columns;
   /** @pdRoleInfo migr=no name=Row assc=tabelaAgregiraRedove coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition */
   private java.util.List<Row> rows;
   
   private String packageOwner;
   
   public Table() { }
   
   public Table(String name, String label, String packageOwner) {
	   super(name, label);
	   this.packageOwner = packageOwner;
   }

/** @pdGenerated default getter */
   public java.util.List<ForeignKey> getForeignkeys() {
      if (foreignkeys == null)
         foreignkeys = new java.util.ArrayList<ForeignKey>();
      return foreignkeys;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorForeignkeys() {
      if (foreignkeys == null)
         foreignkeys = new java.util.ArrayList<ForeignKey>();
      return foreignkeys.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newForeignkeys */
   public void setForeignkeys(java.util.List<ForeignKey> newForeignkeys) {
      removeAllForeignkeys();
      for (java.util.Iterator iter = newForeignkeys.iterator(); iter.hasNext();)
         addForeignkeys((ForeignKey)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newForeignKey */
   public void addForeignkeys(ForeignKey newForeignKey) {
      if (newForeignKey == null)
         return;
      if (this.foreignkeys == null)
         this.foreignkeys = new java.util.ArrayList<ForeignKey>();
      if (!this.foreignkeys.contains(newForeignKey))
         this.foreignkeys.add(newForeignKey);
   }
   
   /** @pdGenerated default remove
     * @param oldForeignKey */
   public void removeForeignkeys(ForeignKey oldForeignKey) {
      if (oldForeignKey == null)
         return;
      if (this.foreignkeys != null)
         if (this.foreignkeys.contains(oldForeignKey))
            this.foreignkeys.remove(oldForeignKey);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllForeignkeys() {
      if (foreignkeys != null)
         foreignkeys.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Column> getColumns() {
      if (columns == null)
         columns = new java.util.ArrayList<Column>();
      return columns;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorColumns() {
      if (columns == null)
         columns = new java.util.ArrayList<Column>();
      return columns.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newColumns */
   public void setColumns(java.util.List<Column> newColumns) {
      removeAllColumns();
      for (java.util.Iterator iter = newColumns.iterator(); iter.hasNext();)
         addColumns((Column)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newColumn */
   public void addColumns(Column newColumn) {
      if (newColumn == null)
         return;
      if (this.columns == null)
         this.columns = new java.util.ArrayList<Column>();
      if (!this.columns.contains(newColumn))
      {
         this.columns.add(newColumn);   
      }
   }
   
   /** @pdGenerated default remove
     * @param oldColumn */
   public void removeColumns(Column oldColumn) {
      if (oldColumn == null)
         return;
      if (this.columns != null)
         if (this.columns.contains(oldColumn))
         {
            this.columns.remove(oldColumn);
         }
   }
   
   public void setRow(int index, Row elem) {
	   rows.set(index, elem);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllColumns() {
      if (columns != null)
      {
         Column oldColumn;
         for (java.util.Iterator iter = getIteratorColumns(); iter.hasNext();)
         {
            oldColumn = (Column)iter.next();
            iter.remove();
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<Row> getRows() {
      if (rows == null)
         rows = new java.util.ArrayList<Row>();
      return rows;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRows() {
      if (rows == null)
         rows = new java.util.ArrayList<Row>();
      return rows.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newRows */
   public void setRows(java.util.List<Row> newRows) {
      removeAllRows();
      for (java.util.Iterator iter = newRows.iterator(); iter.hasNext();)
         addRows((Row)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRow */
   public void addRows(Row newRow) {
      if (newRow == null)
         return;
      if (this.rows == null)
         this.rows = new java.util.ArrayList<Row>();
      if (!this.rows.contains(newRow))
      {
         this.rows.add(newRow);
         newRow.setOwner(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldRow */
   public void removeRows(Row oldRow) {
      if (oldRow == null)
         return;
      if (this.rows != null)
         if (this.rows.contains(oldRow))
         {
            this.rows.remove(oldRow);
            oldRow.setOwner((Table)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllRows() {
      if (rows != null)
      {
         Row oldRow;
         for (java.util.Iterator iter = getIteratorRows(); iter.hasNext();)
         {
            oldRow = (Row)iter.next();
            iter.remove();
            oldRow.setOwner((Table)null);
         }
      }
   }


	public Column getColumnByName(String name)
	{
		for (Column column : columns)
		{
			if (column.getName().equals(name))
			{
				return column;
			}
		}
		
		return null;
	}

	public String getPackageOwner() {
		return packageOwner;
	}

	public void setPackageOwner(String packageOwner) {
		this.packageOwner = packageOwner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((columns == null) ? 0 : columns.hashCode());
		result = prime * result + ((foreignkeys == null) ? 0 : foreignkeys.hashCode());
		result = prime * result + ((packageOwner == null) ? 0 : packageOwner.hashCode());
		result = prime * result + ((rows == null) ? 0 : rows.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (columns == null) {
			if (other.columns != null)
				return false;
		} else if (!columns.equals(other.columns))
			return false;
		if (foreignkeys == null) {
			if (other.foreignkeys != null)
				return false;
		} else if (!foreignkeys.equals(other.foreignkeys))
			return false;
		if (packageOwner == null) {
			if (other.packageOwner != null)
				return false;
		} else if (!packageOwner.equals(other.packageOwner))
			return false;
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else if (!rows.equals(other.rows))
			return false;
		return true;
	}
}
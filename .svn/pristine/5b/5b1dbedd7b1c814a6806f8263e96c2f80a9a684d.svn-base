/***********************************************************************
 * Module:  ForeignKey.java
 * Author:  Duka
 * Purpose: Defines the Class ForeignKey
 ***********************************************************************/

package infviewer.tree.model;

import infviewer.model.Element;

/** @pdOid cbb653c5-1a13-480a-961d-5c4588f59c2e */
public class ForeignKey extends Element {
   /** @pdOid e4e6c3cb-e424-48d4-b3b4-61f31bdd5071 */
   private String referencedTable;
   private String referencingTable;
   private String referencedPackage;
   private String referencingPackage;
   
   /** @pdRoleInfo migr=no name=FKPairs assc=straniKljucAgregiraParoveKolona coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition */
   private java.util.List<FKPairs> fkpairs;
   
   public ForeignKey() { }
   
   public ForeignKey(String name, String label, String referencedTable, String referencingTable, String referencedPackage,
		   String referencingPackage) {
	   	super(name, label);
		this.referencedTable = referencedTable;
		this.referencingTable = referencingTable;
		this.referencedPackage = referencedPackage;
		this.referencingPackage = referencingPackage;
   }

/** @pdGenerated default getter */
   public java.util.List<FKPairs> getFkpairs() {
      if (fkpairs == null)
         fkpairs = new java.util.ArrayList<FKPairs>();
      return fkpairs;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorFkpairs() {
      if (fkpairs == null)
         fkpairs = new java.util.ArrayList<FKPairs>();
      return fkpairs.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newFkpairs */
   public void setFkpairs(java.util.List<FKPairs> newFkpairs) {
      removeAllFkpairs();
      for (java.util.Iterator iter = newFkpairs.iterator(); iter.hasNext();)
         addFkpairs((FKPairs)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newFKPairs */
   public void addFkpairs(FKPairs newFKPairs) {
      if (newFKPairs == null)
         return;
      if (this.fkpairs == null)
         this.fkpairs = new java.util.ArrayList<FKPairs>();
      if (!this.fkpairs.contains(newFKPairs))
         this.fkpairs.add(newFKPairs);
   }
   
   /** @pdGenerated default remove
     * @param oldFKPairs */
   public void removeFkpairs(FKPairs oldFKPairs) {
      if (oldFKPairs == null)
         return;
      if (this.fkpairs != null)
         if (this.fkpairs.contains(oldFKPairs))
            this.fkpairs.remove(oldFKPairs);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllFkpairs() {
      if (fkpairs != null)
         fkpairs.clear();
   }

	public String getReferencedTable() {
		return referencedTable;
	}
	
	public void setReferencedTable(String referencedTable) {
		this.referencedTable = referencedTable;
	}

	public String getReferencingTable() {
		return referencingTable;
	}

	public void setReferencingTable(String referencingTable) {
		this.referencingTable = referencingTable;
	}

	public String getReferencedPackage() {
		return referencedPackage;
	}

	public void setReferencedPackage(String referencedPackage) {
		this.referencedPackage = referencedPackage;
	}

	public String getReferencingPackage() {
		return referencingPackage;
	}

	public void setReferencingPackage(String referencingPackage) {
		this.referencingPackage = referencingPackage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fkpairs == null) ? 0 : fkpairs.hashCode());
		result = prime * result + ((referencedPackage == null) ? 0 : referencedPackage.hashCode());
		result = prime * result + ((referencedTable == null) ? 0 : referencedTable.hashCode());
		result = prime * result + ((referencingPackage == null) ? 0 : referencingPackage.hashCode());
		result = prime * result + ((referencingTable == null) ? 0 : referencingTable.hashCode());
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
		ForeignKey other = (ForeignKey) obj;
		if (fkpairs == null) {
			if (other.fkpairs != null)
				return false;
		} else if (!fkpairs.equals(other.fkpairs))
			return false;
		if (referencedPackage == null) {
			if (other.referencedPackage != null)
				return false;
		} else if (!referencedPackage.equals(other.referencedPackage))
			return false;
		if (referencedTable == null) {
			if (other.referencedTable != null)
				return false;
		} else if (!referencedTable.equals(other.referencedTable))
			return false;
		if (referencingPackage == null) {
			if (other.referencingPackage != null)
				return false;
		} else if (!referencingPackage.equals(other.referencingPackage))
			return false;
		if (referencingTable == null) {
			if (other.referencingTable != null)
				return false;
		} else if (!referencingTable.equals(other.referencingTable))
			return false;
		return true;
	}
}
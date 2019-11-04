/***********************************************************************
 * Module:  FKPairs.java
 * Author:  Duka
 * Purpose: Defines the Class FKPairs
 ***********************************************************************/

package infviewer.tree.model;

/** @pdOid 5472bdc5-90b4-4987-b338-2a9d780956cd */
public class FKPairs {
   /** @pdOid 97e1d50c-b45c-489c-a863-ecf1f8582168 */
   private String referenced;
   /** @pdOid 407df767-1819-47d0-a77e-aa54b8242399 */
   private String referencing;
   
   private String foreignKey;
   private String referencedTable;
   private String referencingTable;
   private String referencedPackage;
   private String referencingPackage;
   
    public FKPairs() { }
   
    public FKPairs(String referenced, String referencing, String foreignKey, String referencedTable,
			String referencingTable, String referencedPackage, String referencingPackage) {
		super();
		this.referenced = referenced;
		this.referencing = referencing;
		this.foreignKey = foreignKey;
		this.referencedTable = referencedTable;
		this.referencingTable = referencingTable;
		this.referencedPackage = referencedPackage;
		this.referencingPackage = referencingPackage;
	}
	
	public String getReferenced() {
		return referenced;
	}
	public void setReferenced(String referenced) {
		this.referenced = referenced;
	}
	public String getReferencing() {
		return referencing;
	}
	public void setReferencing(String referencing) {
		this.referencing = referencing;
	}
	public String getForeignKey() {
		return foreignKey;
	}
	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
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
		int result = 1;
		result = prime * result + ((foreignKey == null) ? 0 : foreignKey.hashCode());
		result = prime * result + ((referenced == null) ? 0 : referenced.hashCode());
		result = prime * result + ((referencedPackage == null) ? 0 : referencedPackage.hashCode());
		result = prime * result + ((referencedTable == null) ? 0 : referencedTable.hashCode());
		result = prime * result + ((referencing == null) ? 0 : referencing.hashCode());
		result = prime * result + ((referencingPackage == null) ? 0 : referencingPackage.hashCode());
		result = prime * result + ((referencingTable == null) ? 0 : referencingTable.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FKPairs other = (FKPairs) obj;
		if (foreignKey == null) {
			if (other.foreignKey != null)
				return false;
		} else if (!foreignKey.equals(other.foreignKey))
			return false;
		if (referenced == null) {
			if (other.referenced != null)
				return false;
		} else if (!referenced.equals(other.referenced))
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
		if (referencing == null) {
			if (other.referencing != null)
				return false;
		} else if (!referencing.equals(other.referencing))
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
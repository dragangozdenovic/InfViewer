/***********************************************************************
 * Module:  Package.java
 * Author:  Jovic
 * Purpose: Defines the Class Package
 ***********************************************************************/

package infviewer.tree.model;

import infviewer.model.Element;

/** @pdOid 9a822d9c-07b1-400a-a25d-18af13ecd948 */
public class Package extends Element {
   /** @pdOid 6d3e29dd-a12d-4f76-9ad8-4961c9839c6f */
   private String packageType;
   
   /** @pdRoleInfo migr=no name=Table assc=paketAgregiraTabele coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition */
   private java.util.List<Table> tables;
   /** @pdRoleInfo migr=no name=Package assc=packageSubpackage coll=java.util.List impl=java.util.ArrayList mult=0..* type=Composition */
   private java.util.List<Package> subpackages;
   
   public Package() { }
   
   public Package(String name, String label, String packageType) {
	   super(name, label);
	   this.packageType = packageType;
   }

/** @pdGenerated default getter */
   public java.util.List<Table> getTables() {
      if (tables == null)
         tables = new java.util.ArrayList<Table>();
      return tables;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTables() {
      if (tables == null)
         tables = new java.util.ArrayList<Table>();
      return tables.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTables */
   public void setTables(java.util.List<Table> newTables) {
      removeAllTables();
      for (java.util.Iterator iter = newTables.iterator(); iter.hasNext();)
         addTables((Table)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTable */
   public void addTables(Table newTable) {
      if (newTable == null)
         return;
      if (this.tables == null)
         this.tables = new java.util.ArrayList<Table>();
      if (!this.tables.contains(newTable))
         this.tables.add(newTable);
   }
   
   /** @pdGenerated default remove
     * @param oldTable */
   public void removeTables(Table oldTable) {
      if (oldTable == null)
         return;
      if (this.tables != null)
         if (this.tables.contains(oldTable))
            this.tables.remove(oldTable);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTables() {
      if (tables != null)
         tables.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Package> getSubpackages() {
      if (subpackages == null)
         subpackages = new java.util.ArrayList<Package>();
      return subpackages;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSubpackages() {
      if (subpackages == null)
         subpackages = new java.util.ArrayList<Package>();
      return subpackages.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSubpackages */
   public void setSubpackages(java.util.List<Package> newSubpackages) {
      removeAllSubpackages();
      for (java.util.Iterator iter = newSubpackages.iterator(); iter.hasNext();)
         addSubpackages((Package)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPackage */
   public void addSubpackages(Package newPackage) {
      if (newPackage == null)
         return;
      if (this.subpackages == null)
         this.subpackages = new java.util.ArrayList<Package>();
      if (!this.subpackages.contains(newPackage))
         this.subpackages.add(newPackage);
   }
   
   /** @pdGenerated default remove
     * @param oldPackage */
   public void removeSubpackages(Package oldPackage) {
      if (oldPackage == null)
         return;
      if (this.subpackages != null)
         if (this.subpackages.contains(oldPackage))
            this.subpackages.remove(oldPackage);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSubpackages() {
      if (subpackages != null)
         subpackages.clear();
   }


	public String getPackageType() {
		return packageType;
	}
	
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((packageType == null) ? 0 : packageType.hashCode());
		result = prime * result + ((subpackages == null) ? 0 : subpackages.hashCode());
		result = prime * result + ((tables == null) ? 0 : tables.hashCode());
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
		Package other = (Package) obj;
		if (packageType == null) {
			if (other.packageType != null)
				return false;
		} else if (!packageType.equals(other.packageType))
			return false;
		if (subpackages == null) {
			if (other.subpackages != null)
				return false;
		} else if (!subpackages.equals(other.subpackages))
			return false;
		if (tables == null) {
			if (other.tables != null)
				return false;
		} else if (!tables.equals(other.tables))
			return false;
		return true;
	}
}
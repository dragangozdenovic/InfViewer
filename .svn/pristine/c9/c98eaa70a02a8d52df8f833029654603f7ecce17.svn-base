/***********************************************************************
 * Module:  Column.java
 * Author:  Jovic
 * Purpose: Defines the Class Column
 ***********************************************************************/

package infviewer.workspace.model;

import infviewer.model.Element;
import infviewer.tree.model.Table;

/** @pdOid b0edbc46-8d5e-4391-8d17-d2c59b6e02fe */
public class Column extends Element {
   /** @pdOid fe35067e-3dc9-4867-9d8b-6c52bb1bcbd8 */
   private String dataType;
   /** @pdOid f2316b06-9bec-4871-a102-5402a94f2dd4 */
   private int precision;
   /** @pdOid 5cd9b326-c5b3-49ca-b89b-c40744e7d752 */
   private int length;
   /** @pdOid 707e2016-31e4-4014-bb62-b8432c011706 */
   private boolean mandatory;
   /** @pdOid ba6b786f-c208-40a6-8678-ad0d1b54260c */
   private boolean primaryKey;

   private String tableOwner;
   private String packageOwner;

    public Column() { }
   
	public Column(String name, String label, String dataType, int precision, int length, boolean mandatory, 
			boolean primaryKey, String tableOwner, String packageOwner) {
		super(name, label);
		this.dataType = dataType;
		this.precision = precision;
		this.length = length;
		this.mandatory = mandatory;
		this.primaryKey = primaryKey;
		this.tableOwner = tableOwner;
		this.packageOwner = packageOwner;
	}

	public String getDataType() {
		return dataType;
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public int getPrecision() {
		return precision;
	}
	
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public boolean isMandatory() {
		return mandatory;
	}
	
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getTableOwner() {
		return tableOwner;
	}

	public void setTableOwner(String tableOwner) {
		this.tableOwner = tableOwner;
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
		result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
		result = prime * result + length;
		result = prime * result + (mandatory ? 1231 : 1237);
		result = prime * result + ((packageOwner == null) ? 0 : packageOwner.hashCode());
		result = prime * result + precision;
		result = prime * result + (primaryKey ? 1231 : 1237);
		result = prime * result + ((tableOwner == null) ? 0 : tableOwner.hashCode());
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
		Column other = (Column) obj;
		if (dataType == null) {
			if (other.dataType != null)
				return false;
		} else if (!dataType.equals(other.dataType))
			return false;
		if (length != other.length)
			return false;
		if (mandatory != other.mandatory)
			return false;
		if (packageOwner == null) {
			if (other.packageOwner != null)
				return false;
		} else if (!packageOwner.equals(other.packageOwner))
			return false;
		if (precision != other.precision)
			return false;
		if (primaryKey != other.primaryKey)
			return false;
		if (tableOwner == null) {
			if (other.tableOwner != null)
				return false;
		} else if (!tableOwner.equals(other.tableOwner))
			return false;
		return true;
	}
}
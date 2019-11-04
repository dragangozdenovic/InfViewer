/***********************************************************************
 * Module:  Element.java
 * Author:  DUCA
 * Purpose: Defines the Class Element
 ***********************************************************************/

package infviewer.model;

/** @pdOid e12636c7-ec2c-49dd-a166-fe241b40238a */
public class Element {
   /** @pdOid ebaa1c51-61d7-4c4c-8340-82cfae9dbcb9 */
   private String name;
   /** @pdOid 210f75d6-c12b-4065-9b63-34f6733b2495 */
   private String label;
   
   public Element() { }
   
	public Element(String name, String label) {
		super();
		this.name = name;
		this.label = label;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Element other = (Element) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
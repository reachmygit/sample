
package com.exam;

import java.io.Serializable;

/**
	* Represents a part or service that can be sold.
	*
	* care should be taken to ensure that this class is immutable since it
	* is sent to other systems for processing that should not be able to
	* change it in any way.
	*
	* <p>Copyright: Copyright (c) 2004</p>
	* <p>Company: Exams are us</p>
	* @author Rama Narayanan
	* @version 1.0
	*/
	public final class Item implements Comparable<Item>,Serializable{
	
		
		private static final long serialVersionUID = 1L;
		private final Integer key;
		private final String name;
		private final float price;
		private final String type;
		
		public Item(Integer key, String name, float price, String type) {
		
			this.key = key;
			this.name = name;
			this.price = price;
			/** Type of the item - service or material*/
			this.type = type;
		}
		
		/** Compares Items based on name. 
		 * @param obj Represents the Item object.
		 * @return int based on 3 conditions
		 * 			0 = both the same 
				   -1 = this Object is less than the Other Object 
					1 = this Object is greater than the Other Object 
      
		*/
		public int compareTo(Item obj) {
	     
	       return this.name.compareTo(obj.name);
	    }
			
		public Integer getKey(){
		
			return key;
		}
		public String getName(){
		
			return name;
		}
		public float getPrice() {
		
			return price;
		}
		public String getType() {
			
			return type;
		}
		
		/**
		 * hashCode() is overriden so Items can be used as keys on hash based Collection
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			result = prime * result + Float.floatToIntBits(price);
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
			Item other = (Item) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
				return false;
			return true;
		}
		
			
	}
	

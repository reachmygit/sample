package com.exam;

import java.io.Serializable;
/**
 * Represents an order and item in the system. Should be immutable so other classes cannot modify it
 *<p>Copyright: Copyright (c) 2004</p>
* <p>Company: Exams are us</p>
* @author Rama Narayanan
* @version 1.0
*/
public final class OrderItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final Item item;
	private final int quantity;
	
	public OrderItem(Item item, int quantity)
	{
		this.item = item;
		this.quantity = quantity;
	}
	
	public Item getItem() {
		
		return item;
	}
	
	public int getQuantity() {
		
		return quantity;
	}
	
	
}

package com.exam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
* Represents an Order that contains a collection of items.
*
* Care should be taken to ensure that this class is immutable since it
* is sent to other systems for processing that should not be able
* to change it in any way.
*
* <p>Copyright: Copyright (c) 2004</p>
* <p>Company: Exams are us</p>
* @author Rama Narayanan
* @version 1.0
*/
public final class Order implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private final OrderItem[] orderItems;
	/** Type of item sold - material or service */
	private static final String ORDER_TYPE = "material";
	public Order(OrderItem[] orderItems)
	{
		this.orderItems = orderItems;
	}
	/**
	 * Returns the total order cost after the tax has been applied. Total cost for service 
	 * and material types are calculate separately and tax is applied only for materials.
	 * @param taxRate Represents the tax rate for the items sold
	 * @return float final cost of the order
	 */
	public float getOrderTotal(float taxRate)
	{
		BigDecimal total = BigDecimal.ZERO ;
		BigDecimal serviceTotal = BigDecimal.ZERO ;
		BigDecimal materialTotal = BigDecimal.ZERO ;
		
		try {
			BigDecimal foodtaxRate = new BigDecimal(String.valueOf((taxRate)));
			for (OrderItem orderItem : orderItems) {

				BigDecimal quantity = new BigDecimal(orderItem.getQuantity());
				BigDecimal foodPrice = new BigDecimal(orderItem.getItem().getPrice());

				if (ORDER_TYPE.equalsIgnoreCase(orderItem.getItem().getType())) {

					materialTotal = foodPrice.multiply(quantity).add(materialTotal);
				} else {

					serviceTotal = foodPrice.multiply(quantity).add(serviceTotal);
				}
			}
			//tax applied only for material item type
			materialTotal = foodtaxRate.multiply(materialTotal).add(materialTotal);
			total = materialTotal.add(serviceTotal);
			total = total.setScale(2, BigDecimal.ROUND_HALF_UP);
		} catch (Exception e) {
			
			//Custom Exception can be created and thrown here
		}
		return total.floatValue();
		
	}
	
	/**
	* Returns a Collection of all items sorted by item name	
	(case-insensitive).
	*
	* @return Collection
	*/
	public Collection<Item> getItems(){
	
		List<Item> listOfItems = new ArrayList<Item>();
		for (OrderItem orderItem : orderItems) {
			listOfItems.add(orderItem.getItem());
		}
		Collections.sort(listOfItems);
		return listOfItems;
	}
	
	
}
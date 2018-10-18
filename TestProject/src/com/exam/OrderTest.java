package com.exam;

import static org.junit.Assert.*;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import org.junit.Test;
/**
 * OrderTest contains test cases for Order class
 * @author Rama
 *
 */
public class OrderTest {

	
	/**
	 * Test to check order total for material item type
	 */
	@Test
	public void testGetOrderTotalForMaterialType() {
				
		OrderItem[] orderItem = {new OrderItem(new Item(1,"ItemA",10.99f,"material"),3),
								new OrderItem(new Item(2,"ItemB",2.76f,"material"),6)};
		
		Order order = new Order(orderItem);
		float result = order.getOrderTotal(0.0625f);
		
		assertEquals(52.63f,result,0.00f);
	
	}
	
	/**
	 * Test to check order total for material item type with 0 tax
	 */
	@Test
	public void testGetOrderTotalForZeroTax() {
				
		OrderItem[] orderItem = {new OrderItem(new Item(1,"ItemA",10.99f,"material"),3),
								new OrderItem(new Item(2,"ItemB",2.76f,"material"),6)};
		
		Order order = new Order(orderItem);
		float result = order.getOrderTotal(0.0f);
		assertEquals(49.53f,result,0.00f);
	}
	
	/**
	 * Test to check order total for material and service item types 
	 */
	@Test
	public void testGetOrderTotalForServiceType() {
				
		OrderItem[] orderItem = {new OrderItem(new Item(1,"ItemA",10.99f,"material"),3),
								new OrderItem(new Item(2,"ItemB",2.76f,"service"),6)};
		
		Order order = new Order(orderItem);
		float result = order.getOrderTotal(0.0625f);
		assertEquals(51.59f,result,0.00f);
	}
	
	/**
	 * Test to check order total for service item type 
	 */
	@Test
	public void testGetOrderTotalForServiceOnlyType() {
				
		OrderItem[] orderItem = {new OrderItem(new Item(1,"ItemA",10.99f,"service"),3),
								new OrderItem(new Item(2,"ItemB",2.76f,"service"),6)};
		
		Order order = new Order(orderItem);
		float result = order.getOrderTotal(0.0625f);
		assertEquals(49.53f,result,0.00f);
	}
	
	/**
	 * Test to get the list of items sorted on item name 
	 */
	@Test
	public void testGetItems() {
		
		OrderItem[] orderItem = {new OrderItem(new Item(1,"Burger",10.99f,"material"),3),
									new OrderItem(new Item(2,"Milk Shake",2.76f,"material"),6),
									new OrderItem(new Item(3,"French fries",2.76f,"material"),2)};
		Order order = new Order(orderItem);
		List<Item> itemList = (ArrayList<Item>) order.getItems();
		
		assertEquals(3,itemList.size());
		assertEquals("Burger",itemList.get(0).getName());
		assertEquals("French fries",itemList.get(1).getName());
		assertEquals("Milk Shake",itemList.get(2).getName());
		
	}
	
	/** 
	 * Test to check if Order class is serializable
	 */
	@Test
	public void testSerialization() {
		
		OrderItem[] orderItem = {new OrderItem(new Item(1,"Burger",10.99f,"material"),3),
				new OrderItem(new Item(2,"Milk Shake",2.76f,"material"),6),
				new OrderItem(new Item(3,"French fries",2.76f,"material"),2)};
		Order order = new Order(orderItem);
		 
	      try {
	         FileOutputStream fileOut =
	         new FileOutputStream("/temp/order.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(order);
	         assertNotNull(out);
	         out.close();
	         fileOut.close();
	         
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	 }
		
		
	
}

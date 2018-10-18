package com.exam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Test;
import junit.framework.*;
/**
 * Test cases for OrderItem class
 * @author Rama
 *
 */
public class OrderItemTest extends TestCase {
	
	OrderItem item = null;
	public void setUp() {
		
		item = new OrderItem(new Item(1,"ABC",8.99F,"Service"),2);
	}
	/**
	 * Test to check the getItem method
	 */
	@Test
	public void testGetItem() {
		
		assertNotNull(item.getItem());
		assertEquals(1,item.getItem().getKey().intValue());
		assertEquals("ABC",item.getItem().getName());
		assertEquals(8.99f,item.getItem().getPrice());
		assertEquals("Service",item.getItem().getType());
	}
	/**
	 * Test to check the getQuantity method
	 */
	@Test
	public void testGetQuantity() {
		assertEquals(2,item.getQuantity());
	}

	/** 
	 * Test to check if OrderItem class is serializable
	 */
	@Test
	public void testSerialization() {
		
		OrderItem order = new OrderItem(new Item(1,"Burger",10.99f,"material"),3);
		 
	      try {
	         FileOutputStream fileOut =
	         new FileOutputStream("/temp/orderItem.ser");
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

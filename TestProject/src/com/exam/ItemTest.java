package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import junit.framework.*;
/**
 * Contains test cases for Item class
 * @author Rama
 *
 */
public class ItemTest extends TestCase  {
	
	Item item = null;
	
	public void setUp() {
		
		item = new Item(1,"Burger",3.99f,"material");
	}
	
	@Test
	public void testGetKey() {

		assertEquals(1,item.getKey().intValue());
	}
	
	@Test
	public void testGetName() {
		
		assertEquals("Burger",item.getName());
	}

	@Test
	public void testGetPrice() {
		
		assertEquals(3.99f,item.getPrice(),0.00f);
	}
	/**
	 * Test to check the overriden equals method
	 */
	@Test
	public void testEquals() {

		Item item1 = new Item(1,"XX",2.22f,"material");
		Item item2 = new Item(1,"XX",2.22f,"material");
		
		assertTrue(item1.equals(item2));
		
	}
	
	/**
	 * Test to check the overriden hashcode method
	 */
	@Test
	public void testHashCode() {
		
		Item item1 = new Item(1,"XX",2.22f,"material");
		Item item2 = new Item(1,"XX",2.22f,"material");
		
		Set<Item> set = new HashSet<Item>();
		set.add(item1);
		set.add(item2);
		
		assertEquals(1,set.size());
		
		
		
	}
	
	


}

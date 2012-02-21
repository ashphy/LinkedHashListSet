package com.github.ashphy.LinkedHashListSet;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test case for {@link LinkedHashListSet}
 * 
 * @author Kazuki Hamasaki <ne.viam.si.abis@gmail.com>
 */
public class LinkedHashListSetTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	private LinkedHashListSet<String> getTestList() {
		LinkedHashListSet<String> list = new LinkedHashListSet<>();
		for (int i = 0; i < 10; i++) {
			list.add("TEST" + i);
		}
		return list;
	} 
	
	@Test
	public void test01() throws Exception {
		LinkedHashListSet<String> listSet = new LinkedHashListSet<>();
		listSet.add("TEST");
		assertEquals(1, listSet.size());
	}
	
	@Test
	public void test02() throws Exception {
		LinkedHashListSet<String> listSet = new LinkedHashListSet<>();
		listSet.add("TEST");
		listSet.add("TEST2");
		assertEquals(2, listSet.size());
	}

	@Test
	public void test03() throws Exception {
		LinkedHashListSet<String> listSet = new LinkedHashListSet<>();
		listSet.add("TEST");
		listSet.add("TEST");
		assertEquals(1, listSet.size());
	}
	
	@Test
	public void test04() throws Exception {
		LinkedHashListSet<String> listSet = new LinkedHashListSet<>();
		assertEquals(0, listSet.size());
	}
	
	@Test
	public void test05() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		assertEquals("TEST5", testListSet.get(5));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test06() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		testListSet.get(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test07() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		testListSet.get(10);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test08() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		testListSet.set(0, null);
	}
	
	@Test
	public void test09() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		testListSet.remove(0);
		assertEquals(9, testListSet.size());
		assertEquals("TEST1", testListSet.get(0));
	}
	
	@Test
	public void test10() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		assertEquals(8, testListSet.indexOf("TEST8"));
	}
	
	@Test
	public void test11() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		assertEquals(8, testListSet.lastIndexOf("TEST8"));
	}
	
	@Test
	public void test12() throws Exception {
		final String TEST = "TEST7";
		LinkedHashListSet<String> testListSet = getTestList();
		assertEquals(testListSet.indexOf(TEST), testListSet.lastIndexOf(TEST));
	}
	
	@Test
	public void test13() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		LinkedHashListSet<String> emptyListSet = new LinkedHashListSet<>();
		assertTrue(emptyListSet.addAll(testListSet));
	}
	
	@Test
	public void test14() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		testListSet.clear();
		assertEquals(0, testListSet.size());
	}
	
	@Test
	public void test15() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		LinkedHashListSet<String> testListSet2 = getTestList();
		testListSet.removeAll(testListSet2);
		assertEquals(0, testListSet.size());
	}
	
	@Test
	public void test16() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		List<String> sub = testListSet.subList(0, 5);
		sub.clear();
		assertEquals(0, sub.size());
		assertEquals(5, testListSet.size());
		assertEquals("TEST5", testListSet.get(0));
		assertEquals("TEST9", testListSet.get(4));
	}
	
	@Test
	public void test17() throws Exception {
		LinkedHashListSet<String> testListSet = getTestList();
		List<String> sub = testListSet.subList(0, 5);
		System.out.println(Arrays.deepToString(sub.toArray()));
		sub.add("TEST10");
		System.out.println(Arrays.deepToString(testListSet.toArray()));
		assertEquals(11, testListSet.size());
		assertEquals("TEST10", testListSet.get(10));
	}
}

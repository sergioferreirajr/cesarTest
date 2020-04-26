package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import main.CesarsTest;

class CesarsTest_Test extends CesarsTest{

	LinkedList<String> linkedList1 = new LinkedList<String>();
	LinkedList<String> linkedList2 = new LinkedList<String>();
	
	/**
	 * Question 1
	 * Testing if the char[] has the correct number of slots... given not spaces at the end
	 */
	@Test
	void testReplaceSpaces_charSize1() {
		char[] resultChar = q1ReplaceSpaces("asas asas asas");
		assertTrue(18 == resultChar.length);
	}
		
	/**
	 * Question 1
	 * Testing if the char[] has the correct number of slots... given the wrong number of spaces at the end
	 */
	@Test
	void testReplaceSpaces_charSize2() {
		char[] resultChar = q1ReplaceSpaces("asas asas asas  ");
		assertTrue(18 == resultChar.length);
	}
	
	/**
	 * Question 1
	 * Testing if the char[] has the correct number of slots... given the correct number of spaces at the end
	 */
	@Test
	void testReplaceSpaces_charSize3() {
		char[] resultChar = q1ReplaceSpaces("asas asas asas    ");
		assertTrue(18 == resultChar.length);
	}
	
	/**
	 * Question 1
	 * Testing if the char[] has the correct number of slots... given the more spaces than needed at the end
	 */
	@Test
	void testReplaceSpaces_charSize4() {
		char[] resultChar = q1ReplaceSpaces("asas asas asas         ");
		assertTrue(18 == resultChar.length);
	}
	
	/**
	 * Question 1
	 * Testing if the char[] has the correct characters replaced
	 */
	@Test
	void testReplaceSpaces_charResult1() {
		char[] resultChar = q1ReplaceSpaces("asas asas asas");
		assertTrue("asas&32asas&32asas".equals(new String(resultChar)));	
	}
	
	/**
	 * Question 1
	 * Testing if the char[] has the correct characters replaced, even if there are 2 spaces between the words
	 */
	@Test
	void testReplaceSpaces_charResult2() {
		char[] resultChar = q1ReplaceSpaces("asas  asas asas");
		assertTrue("asas&32&32asas&32asas".equals(new String(resultChar)));
	}
	
	/**
	 * Question 1
	 * Testing if the char[] has the correct characters replaced, even if starts with a space
	 */
	@Test
	void testReplaceSpaces_charResult3() {
		char[] resultChar = q1ReplaceSpaces(" asas  asas asas");
		assertTrue("&32asas&32&32asas&32asas".equals(new String(resultChar)));
	}
	
	//============================================================================================
	
	/**
	 * Question 2
	 * Testing jumbled word you, yuo = TRUE
	 */
	@Test
	void testJumbledWord_you1() {
		boolean result = q2CheckJumbledWord("you", "yuo");
		assertTrue(result);
	}
	
	/**
	 * Question 2
	 * Testing jumbled word you, you = FALSE
	 */
	@Test
	void testJumbledWord_you2() {
		boolean result = q2CheckJumbledWord("you", "you");
		assertFalse(result);
	}
	
	/**
	 * Question 2
	 * Testing jumbled word probably, porbalby = TRUE
	 */
	@Test
	void testJumbledWord_probably1() {
		boolean result = q2CheckJumbledWord("probably", "porbalby");
		assertTrue(result);
	}
	
	/**
	 * Question 2
	 * Testing jumbled word probably, probably = FALSE
	 */
	@Test
	void testJumbledWord_probably2() {
		boolean result = q2CheckJumbledWord("probably", "probably");
		assertFalse(result);
	}
	
	/**
	 * Question 2
	 * Testing jumbled word despite, desptie = TRUE
	 */
	@Test
	void testJumbledWord_despite() {
		boolean result = q2CheckJumbledWord("despite", "desptie");
		assertTrue(result);
	}
	
	/**
	 * Question 2
	 * Testing jumbled word moon, nmoo = FALSE
	 */
	@Test
	void testJumbledWord_moon() {
		boolean result = q2CheckJumbledWord("moon", "nmoo");
		assertFalse(result);
	}
	
	/**
	 * Question 2
	 * Testing jumbled word misspellings, mpeissngslli = FALSE
	 */
	@Test
	void testJumbledWord_misspellings() {
		boolean result = q2CheckJumbledWord("misspellings", "mpeissngslli");
		assertFalse(result);
	}
	
	//============================================================================================
	
	/**
	 * Question 3
	 * Testing typo word: pale, ple = TRUE
	 */
	@Test
	void testTypoWord_pale() {
		boolean result = q3CheckTypoWord("pale", "ple");
		assertTrue(result);
	}
	
	/**
	 * Question 3
	 * Testing typo word: pales, pale = TRUE
	 */
	@Test
	void testTypoWord_pales() {
		boolean result = q3CheckTypoWord("pales", "pale");
		assertTrue(result);
	}
	
	/**
	 * Question 3
	 * Testing typo word: pale, bale = TRUE
	 */
	@Test
	void testTypoWord_bale() {
		boolean result = q3CheckTypoWord("pale", "bale");
		assertTrue(result);
	}
	
	/**
	 * Question 3
	 * Testing typo word: pale, bake = FALSE
	 */
	@Test
	void testTypoWord_bake() {
		boolean result = q3CheckTypoWord("pale", "bake");
		assertFalse(result);
	}
	
	//============================================================================================
	
	/**
	 * Question 5
	 * Testing Remove Duplicates
	 */
	@Test
	void testRemoveDuplicates_size() {
		
		linkedList1.clear();
		linkedList1.add("A");
		linkedList1.add("B");
		linkedList1.add("A");
		linkedList1.add("C");
		linkedList1.add("D");
		linkedList1.add("A");
		linkedList1.add("E");
		linkedList1.add("B");
		linkedList1.add("F");
		linkedList1.add("C");
		linkedList1.add("A");
		
		LinkedList<String> result = q5RemoveDuplicates(linkedList1);
		assertTrue(6 == result.size());
	}
	
	/**
	 * Question 5
	 * Testing Remove Duplicates
	 */
	@Test
	void testRemoveDuplicates_values1() {
		
		linkedList1.clear();
		linkedList1.add("A");
		linkedList1.add("B");
		linkedList1.add("A");
		linkedList1.add("C");
		linkedList1.add("D");
		linkedList1.add("A");
		linkedList1.add("E");
		linkedList1.add("B");
		linkedList1.add("F");
		linkedList1.add("C");
		linkedList1.add("A");
		
		LinkedList<String> result = q5RemoveDuplicates(linkedList1);
		assertTrue("A".equals(result.get(0)));
		assertTrue("B".equals(result.get(1)));
		assertTrue("C".equals(result.get(2)));
		assertTrue("D".equals(result.get(3)));
		assertTrue("E".equals(result.get(4)));
		assertTrue("F".equals(result.get(5)));
	}
	
	/**
	 * Question 5
	 * Testing Remove Duplicates
	 */
	@Test
	void testRemoveDuplicates_values2() {
		
		linkedList1.clear();
		linkedList1.add("B");
		linkedList1.add("B");
		linkedList1.add("A");
		linkedList1.add("C");
		linkedList1.add("D");
		linkedList1.add("D");
		linkedList1.add("E");
		linkedList1.add("B");
		linkedList1.add("F");
		linkedList1.add("C");
		linkedList1.add("A");
		
		LinkedList<String> result = q5RemoveDuplicates(linkedList1);
		assertTrue("B".equals(result.get(0)));
		assertTrue("A".equals(result.get(1)));
		assertTrue("C".equals(result.get(2)));
		assertTrue("D".equals(result.get(3)));
		assertTrue("E".equals(result.get(4)));
		assertTrue("F".equals(result.get(5)));
	}
	
	//============================================================================================
	
	/**
	 * Question 7
	 * Testing Intersection list
	 */
	@Test
	void testIntersectionList_values1() {
		
		linkedList1.clear();
		linkedList1.add("A");
		linkedList1.add("B");
		linkedList1.add("C");
		linkedList1.add("D");
		linkedList1.add("E");
		linkedList1.add("F");
		linkedList1.add("G");
		linkedList1.add("H");
		linkedList1.add("I");
		linkedList1.add("J");
		
		linkedList2.clear();
		linkedList2.add("1");
		linkedList2.add("2");
		linkedList2.add("3");
		linkedList2.add("G");
		linkedList2.add("H");
		linkedList2.add("I");
		linkedList2.add("J");
		
		Question7Result result = q7CheckIntersection(linkedList1, linkedList2);
		assertTrue(6 == result.getList1IndexIntersection());
		assertTrue(3 == result.getList2IndexIntersection());
	}
	
	/**
	 * Question 7
	 * Testing Intersection list
	 */
	@Test
	void testIntersectionList_values2() {
		
		linkedList1.clear();
		linkedList1.add("A");
		linkedList1.add("B");
		linkedList1.add("C");
		linkedList1.add("D");
		linkedList1.add("E");
		linkedList1.add("F");
		linkedList1.add("G");
		linkedList1.add("H");
		linkedList1.add("I");
		linkedList1.add("J");
		
		linkedList2.clear();
		linkedList2.add("1");
		linkedList2.add("2");
		linkedList2.add("3");
		linkedList2.add("B");
		linkedList2.add("5");
		linkedList2.add("6");
		linkedList2.add("7");
		
		Question7Result result = q7CheckIntersection(linkedList1, linkedList2);
		assertTrue(1 == result.getList1IndexIntersection());
		assertTrue(3 == result.getList2IndexIntersection());
	}
	
	/**
	 * Question 7
	 * Testing Intersection list
	 */
	@Test
	void testIntersectionList_values3() {
		
		linkedList1.clear();
		linkedList1.add("A");
		linkedList1.add("B");
		linkedList1.add("C");
		linkedList1.add("D");
		linkedList1.add("E");
		linkedList1.add("F");
		
		linkedList2.clear();
		linkedList2.add("1");
		linkedList2.add("2");
		linkedList2.add("3");
		linkedList2.add("4");
		linkedList2.add("5");
		linkedList2.add("6");
		linkedList2.add("D");
		linkedList2.add("E");
		linkedList2.add("9");
		linkedList2.add("10");
		
		Question7Result result = q7CheckIntersection(linkedList1, linkedList2);
		assertTrue(3 == result.getList1IndexIntersection());
		assertTrue(6 == result.getList2IndexIntersection());
	}
}

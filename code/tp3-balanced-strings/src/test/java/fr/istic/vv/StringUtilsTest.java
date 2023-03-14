package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

	@Test
	void testIsBalanced1() {
		assertTrue(isBalanced("()"));
	}

	@Test
	void testIsBalanced2() {
		assertTrue(isBalanced("()[]{}"));
	}

	@Test
	void testIsBalanced3() {
		assertTrue(isBalanced("{[][]}({})"));
	}

	@Test
	void testIsBalanced4() {
		assertTrue(isBalanced(""));
	}

	@Test
	void testIsNotBalanced1() {
		assertFalse(isBalanced("(]"));
	}

	@Test
	void testIsNotBalanced2() {
		assertFalse(isBalanced("{(}{}`"));
	}

	@Test
	void testIsNotBalanced3() {
		assertFalse(isBalanced("({)}"));
	}
}
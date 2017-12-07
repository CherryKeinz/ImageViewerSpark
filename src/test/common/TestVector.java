package test.common;

import static org.junit.Assert.*;

import org.junit.Test;

import common.Vector;

public class TestVector {

	@Test
	public void testToString() {
		assertEquals("{1, 2, 3}", Vector.toString(new int[] { 1, 2, 3 }));
	}

	@Test
	public void testFlatten() {
		assertTrue(Vector.areEqual(new int[] { 1, 2, 3, 4, 5, 6 },
				Vector.flatten(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 } })));
	}

	@Test
	public void testFold() {
		int[][] result = Vector.fold(new int[] { 1, 2, 3, 4, 5, 6 }, 2);
		assertTrue(Vector.areEqual(new int[] { 1, 2, 3 }, result[0]));
		assertTrue(Vector.areEqual(new int[] { 4, 5, 6 }, result[1]));
	}

	@Test
	public void testScale() {
		int[] vector = new int[] { 0, 1, 2, 4, 8 };
		Vector.scale(vector, 16);
		assertTrue(Vector.areEqual(new int[] { 0, 2, 4, 8, 16 }, vector));
	}
}

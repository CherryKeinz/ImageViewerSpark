package test.common.slice;

import static org.junit.Assert.*;

import org.junit.Test;

import common.slice.Slice;

public class TestSlice {

	@Test
	public void testCreateFromWholeArray() {
		int[] array = new int[] { 0, 1, 2, 3, 4, 5 };
		Slice slice = Slice.wrap(array);// 相当于：array[:]

		assertEquals(6, slice.length());
		assertEquals(0, slice.get(0));
		assertEquals(1, slice.get(1));
		assertEquals(2, slice.get(2));
		assertEquals(3, slice.get(3));
		assertEquals(4, slice.get(4));
		assertEquals(5, slice.get(5));
	}

	@Test
	public void testCreateFromSubset() {
		int[] array = new int[] { 0, 1, 2, 3, 4, 5 };
		Slice slice = Slice.slice(array, 1, 3);// 相当于：array[1:3]

		assertEquals(3, slice.length());
		assertEquals(1, slice.get(0));
		assertEquals(2, slice.get(1));
		assertEquals(3, slice.get(2));
	}

	@Test
	public void testCreateSinceStartIndex() {
		int[] array = new int[] { 0, 1, 2, 3, 4, 5 };
		Slice slice = Slice.sliceSince(array, 2);// 相当于：array[2:]

		assertEquals(4, slice.length());
		assertEquals(2, slice.get(0));
		assertEquals(3, slice.get(1));
		assertEquals(4, slice.get(2));
		assertEquals(5, slice.get(3));
	}

	@Test
	public void testCreateUntilEndIndex() {
		int[] array = new int[] { 0, 1, 2, 3, 4, 5 };
		Slice slice = Slice.sliceUntil(array, 2);// 相当于：array[:2]

		assertEquals(3, slice.length());
		assertEquals(0, slice.get(0));
		assertEquals(1, slice.get(1));
		assertEquals(2, slice.get(2));
	}
	
	@Test
	public void testCreateFromFirstElements(){
		int[] array = new int[] { 0, 1, 2, 3, 4, 5 };
		Slice slice = Slice.first(array, 2);

		assertEquals(2, slice.length());
		assertEquals(0, slice.get(0));
		assertEquals(1, slice.get(1));
	}
	
	@Test
	public void testCreateFromLastElements(){
		int[] array = new int[] { 0, 1, 2, 3, 4, 5 };
		Slice slice = Slice.last(array, 2);

		assertEquals(2, slice.length());
		assertEquals(4, slice.get(0));
		assertEquals(5, slice.get(1));
	}

	@Test
	public void testSet() {
		int[] array = new int[] { 0, 1, 2, 3, 4 };
		Slice slice = Slice.slice(array, 1, 3);

		assertSame(array, slice.internal());

		array[0] = 10000;
		assertEquals(Slice.wrap(new int[] { 1, 2, 3 }), slice);// slice没有受到array[0]的影响

		array[1] = 10001;
		assertEquals(10001, slice.get(0));

		slice.set(1, 10002);
		assertEquals(10002, slice.get(1));
	}

	@Test
	public void testPlus() {
		Slice original = Slice.wrap(new int[] { 1, 2, 3 });
		original.add(Slice.wrap(new int[] { 4, 5, 6 }));

		assertEquals(5, original.get(0));
		assertEquals(7, original.get(1));
		assertEquals(9, original.get(2));
	}

	@Test
	public void testSubstract() {
		Slice original = Slice.wrap(new int[] { 1, 2, 3 });
		original.substract(Slice.wrap(new int[] { 4, 5, 6 }));

		assertEquals(-3, original.get(0));
		assertEquals(-3, original.get(1));
		assertEquals(-3, original.get(2));
	}

	@Test
	public void testInnerProduct() {
		Slice slice1 = Slice.wrap(new int[] { 1, 2, 3 });
		Slice slice2 = Slice.wrap(new int[] { 4, 5, 6 });

		assertEquals(32, slice1.innerProduct(slice2));
	}

	@Test
	public void testMap() {
		Slice original = Slice.wrap(new int[] { 1, 2, 3 });
		Slice view = Slice.map(original, element -> element * 2);

		assertEquals(2, view.get(0));
		assertEquals(4, view.get(1));
		assertEquals(6, view.get(2));

		original.set(0, 100);
		assertEquals(200, view.get(0));
	}

	@Test
	public void testEquals() {
		int[] array = new int[] { 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 2 };

		assertEquals(Slice.slice(array, 0, 3), Slice.slice(array, 4, 7));
		assertNotEquals(Slice.slice(array, 0, 4), Slice.slice(array, 4, 7));// 长度不等
		assertNotEquals(Slice.slice(array, 0, 4), Slice.slice(array, 8, 11));// 元素不等
	}

	@Test
	public void testToString() {
		int[] array = new int[] { 0, 1, 2, 3, 4 };

		assertEquals("{1, 2, 3}", Slice.slice(array, 1, 3).toString());
	}
}

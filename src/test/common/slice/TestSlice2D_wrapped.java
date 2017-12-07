package test.common.slice;

import static org.junit.Assert.*;
import org.junit.Test;
import common.slice.Slice2D;

public class TestSlice2D_wrapped {
	@Test
	public void testCreate() {
		Slice2D slice2D = Slice2D.wrap(new int[][] { new int[] { 00, 01, 02, 03 }, new int[] { 10, 11, 12, 13 },
				new int[] { 20, 21, 22, 23 } });

		assertEquals(4, slice2D.width());
		assertEquals(3, slice2D.height());
	}

	@Test
	public void testGet() {
		Slice2D slice2D = Slice2D.wrap(new int[][] { new int[] { 00, 01, 02, 03 }, new int[] { 10, 11, 12, 13 },
				new int[] { 20, 21, 22, 23 } });

		assertEquals(00, slice2D.get(0, 0));
		assertEquals(01, slice2D.get(0, 1));
		assertEquals(02, slice2D.get(0, 2));
		assertEquals(03, slice2D.get(0, 3));
		assertEquals(10, slice2D.get(1, 0));
		assertEquals(11, slice2D.get(1, 1));
		assertEquals(12, slice2D.get(1, 2));
		assertEquals(13, slice2D.get(1, 3));
		assertEquals(20, slice2D.get(2, 0));
		assertEquals(21, slice2D.get(2, 1));
		assertEquals(22, slice2D.get(2, 2));
		assertEquals(23, slice2D.get(2, 3));
	}

	@Test
	public void testSet() {
		Slice2D slice2D = Slice2D.wrap(new int[][] { new int[] { 00, 01, 02, 03 }, new int[] { 10, 11, 12, 13 },
				new int[] { 20, 21, 22, 23 } });

		slice2D.set(2, 3, 999);
		assertEquals(01, slice2D.get(0, 1));
		assertEquals(02, slice2D.get(0, 2));
		assertEquals(03, slice2D.get(0, 3));
		assertEquals(10, slice2D.get(1, 0));
		assertEquals(11, slice2D.get(1, 1));
		assertEquals(12, slice2D.get(1, 2));
		assertEquals(13, slice2D.get(1, 3));
		assertEquals(20, slice2D.get(2, 0));
		assertEquals(21, slice2D.get(2, 1));
		assertEquals(22, slice2D.get(2, 2));
		assertEquals(999, slice2D.get(2, 3));// 被set方法修改为999
	}
}

package test.common.slice;

import java.util.Vector;

import org.junit.Ignore;
import org.junit.Test;

import common.slice.Slice;

//统计操作大数组所需时间
//测试用例：产生一个长度为SIZE的数组
//耗时：
//（SIZE=128000000）
//原生int数组（testArray）：243ms
//原生Integer数组（testIntegerArray）：无法在合理时间内完成
//Slice类（testSlice）：258ms
//复制一个现有数组（testCopy）：449ms
//Vector类（testVector）：无法在合理时间内完成
public class TestSimpleSlice_timePerformance {
	// 为了不在测试过程中耗尽JVM内存，该值应小于JVM内存的一半
	private final int SIZE = 128000000;

	@Test
	public void testArray() {
		int[] array = new int[SIZE];
		for (int i = 0; i < SIZE - 1; i++) {
			array[i] = i;
		}
	}

	@Ignore("Too time-consuming. Can't finish within a second")
	@Test
	public void testIngegerArray() {
		Integer[] array = new Integer[SIZE];
		for (int i = 0; i < SIZE - 1; i++) {
			array[i] = i;
		}
	}

	@Test
	public void testSlice() {
		Slice slice = Slice.slice(new int[SIZE], 0, SIZE - 1);
		for (int i = 0; i < SIZE - 1; i++) {
			slice.set(i, i);
		}
	}

	@Test
	public void testArrayCopy() {
		int[] src = new int[SIZE];
		int[] dst = new int[SIZE];

		System.arraycopy(src, 0, dst, 0, SIZE);
	}

	@Ignore("Too time-consuming. Can't finish within a second")
	@Test
	public void testVector() {
		Vector<Integer> v = new Vector<>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			v.addElement(i);
		}
	}
}

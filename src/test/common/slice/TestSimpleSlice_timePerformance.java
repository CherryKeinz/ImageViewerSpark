package test.common.slice;

import java.util.Vector;

import org.junit.Ignore;
import org.junit.Test;

import common.slice.Slice;

//ͳ�Ʋ�������������ʱ��
//��������������һ������ΪSIZE������
//��ʱ��
//��SIZE=128000000��
//ԭ��int���飨testArray����243ms
//ԭ��Integer���飨testIntegerArray�����޷��ں���ʱ�������
//Slice�ࣨtestSlice����258ms
//����һ���������飨testCopy����449ms
//Vector�ࣨtestVector�����޷��ں���ʱ�������
public class TestSimpleSlice_timePerformance {
	// Ϊ�˲��ڲ��Թ����кľ�JVM�ڴ棬��ֵӦС��JVM�ڴ��һ��
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

package common;

public class Vector {
	public static void increment(int[] original, int[] delta) {
		for (int i = 0; i < original.length; i++) {
			original[i] += delta[i];
		}
	}

	public static void decrement(int[] original, int[] delta) {
		for (int i = 0; i < original.length; i++) {
			original[i] -= delta[i];
		}
	}

	public static void delta(int[] original, int value) {
		for (int i = 0; i < original.length; i++) {
			original[i] = value - original[i];
		}
	}

	// 把向量格式化为类似于“{1, 2, 3}”的形式
	public static String toString(int[] vector) {
		StringBuilder result = new StringBuilder();
		result.append("{");
		result.append(vector[0]);

		for (int i = 1; i < vector.length; i++) {
			result.append(", ");
			result.append(vector[i]);
		}

		result.append("}");

		return result.toString();
	}

	// 将二维矩阵压平为一位数组（顺序：行主序）
	public static int[] flatten(int[][] vector2) {
		int countRow = vector2.length;
		int width = vector2[0].length;// 二维数组每一行的宽度
		int[] result = new int[countRow * width];

		for (int row = 0; row < vector2.length; row++) {
			System.arraycopy(vector2[row], 0, result, row * width, width);
		}

		return result;
	}

	// 将一位数组按行折叠为二维数组
	public static int[][] fold(int[] vector1, int countRow) {
		int width = vector1.length / countRow;// 二维数组每一行的宽度

		int result[][] = new int[countRow][];
		for (int row = 0; row < countRow; row++) {
			result[row] = new int[width];
			System.arraycopy(vector1, row * width, result[row], 0, width);
		}

		return result;
	}

	// 把vector内的元素放缩至[0, max]范围
	public static void scale(int[] vector, int max) {
		int maxElement = Integer.MIN_VALUE;
		int minElement = Integer.MAX_VALUE;
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] > maxElement) {
				maxElement = vector[i];
			}
			if (vector[i] < minElement) {
				minElement = vector[i];
			}
		}

		for (int i = 0; i < vector.length; i++) {
			float factor = ((float) vector[i] - (float) minElement) / ((float) maxElement - (float) minElement);
			vector[i] = Math.round(factor * (float) max);
		}
	}

	public static boolean areEqual(int[] vector1, int[] vector2) {
		if (vector1.length != vector2.length) {
			return false;
		}

		for (int i = 0; i < vector1.length; i++) {
			if (vector1[i] != vector2[i]) {
				return false;
			}
		}

		return true;
	}
}

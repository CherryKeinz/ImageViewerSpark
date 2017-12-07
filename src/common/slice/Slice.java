package common.slice;

//数组切片，派生自java原生数组的某个连续子集
//用途：
//1.避免了大量的数据复制：从同一数组派生出来的切片共享数组元素
//2.调用者不需要对下标进行换算：数组切片首元素的下标是0，而不论派生自原数组的哪个子集
//3.提供加减、内积、equals、toString等实用工具
public abstract class Slice {
	// array[:]
	public static Slice wrap(int array[]) {
		return new SimpleSlice(array, 0, array.length - 1);
	}

	// array[startIndex: endIndex]
	public static Slice slice(int array[], int startIndex, int endIndex) {
		return new SimpleSlice(array, startIndex, endIndex);
	}

	// array[startIndex:]
	public static Slice sliceSince(int[] array, int startIndex) {
		return new SimpleSlice(array, startIndex, array.length - 1);
	}

	// array[:endIndex]
	public static Slice sliceUntil(int[] array, int endIndex) {
		return new SimpleSlice(array, 0, endIndex);
	}

	// array的前若干个元素
	public static Slice first(int[] array, int length) {
		return new SimpleSlice(array, 0, length - 1);
	}

	// array的后若干个元素
	public static Slice last(int[] array, int length) {
		return Slice.sliceSince(array, array.length - length);
	}

	public static Slice map(Slice original, MapFunction mapFunction) {
		return new SliceView(original, mapFunction);
	}

	public abstract int[] internal();

	public abstract int length();

	public abstract int get(int index);

	public abstract void set(int index, int value);

	public void add(Slice another) {
		for (int i = 0; i < length(); i++) {
			set(i, get(i) + another.get(i));
		}
	}

	public void substract(Slice another) {
		for (int i = 0; i < length(); i++) {
			set(i, get(i) - another.get(i));
		}
	}

	public int innerProduct(Slice another) {
		int result = 0;
		for (int i = 0; i < length(); i++) {
			result += get(i) * another.get(i);
		}
		return result;
	}
}

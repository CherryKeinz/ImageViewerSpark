package common.slice;

class SimpleSlice extends Slice{
	private int[] internal;
	private int startIndex;// 首个元素在internal中的下标
	private int endIndex;// 末尾元素在internal中的下标

	// array[startIndex:endIndex]
	SimpleSlice(int[] array, int startIndex, int endIndex) {
		this.internal = array;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	@Override
	public int[] internal() {
		return internal;
	}

	@Override
	public int length() {
		return endIndex - startIndex + 1;
	}

	@Override
	public int get(int index) {
		return internal[startIndex + index];
	}

	@Override
	public void set(int index, int value) {
		internal[startIndex + index] = value;
	}
	
	@Override
	public boolean equals(Object anotherObject) {
		if (!(anotherObject instanceof Slice)) {
			return false;
		}
		Slice another = (Slice) anotherObject;

		if (length() != another.length()) {
			return false;
		}

		for (int i = 0; i < length(); i++) {
			if (get(i) != another.get(i)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append("{");
		result.append(get(0));
		for (int i = 1; i < length(); i++) {
			result.append(", " + get(i));
		}
		result.append("}");

		return result.toString();
	}
}

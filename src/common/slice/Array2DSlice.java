package common.slice;

class Array2DSlice extends Slice2D {
	int[][] elements;

	Array2DSlice(int[][] elements) {
		this.elements = elements;
	}

	@Override
	public int width() {
		return elements[0].length;
	}

	@Override
	public int height() {
		return elements.length;
	}

	@Override
	public int get(int row, int column) {
		return elements[row][column];
	}

	@Override
	public void set(int row, int column, int value) {
		elements[row][column] = value;
	}
}

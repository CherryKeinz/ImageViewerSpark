package common.slice;

class FoldedSlice extends Slice2D {
	private Slice slice;
	private int width;

	FoldedSlice(Slice slice, int width) {
		this.slice = slice;
		this.width = width;
	}

	@Override
	public int width() {
		return width;
	}

	@Override
	public int height() {
		return slice.length() / width;
	}

	@Override
	public int get(int row, int column) {
		return slice.get(row * width + column);
	}

	@Override
	public void set(int row, int column, int value) {
		slice.set(row * width + column, value);
	}
}

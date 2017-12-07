package common.slice;

class SliceView extends Slice {
	private Slice original;
	private MapFunction mapFunction;

	SliceView(Slice original, MapFunction mapFunction) {
		this.original = original;
		this.mapFunction = mapFunction;
	}

	@Override
	public int[] internal() {
		return original.internal();
	}

	@Override
	public int length() {
		return original.length();
	}

	@Override
	public int get(int index) {
		return mapFunction.map(original.get(index));
	}

	@Override
	public void set(int index, int value) {
		// 什么都不做，因为设置视图不影响原始数据
	}
}

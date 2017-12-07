package common.slice;

// 二维向量（左上角为第0行、第0列）
public abstract class Slice2D {
	public abstract int width();

	public abstract int height();

	public abstract int get(int row, int column);
	
	public abstract void set(int row, int column, int value);
	
	// 以行主序方式折叠，把一维数组转为二维数组
	// 暂不支持增广（broadcast），故一维数组的长度必须是width的倍数
	public static Slice2D fold(Slice slice, int width) {
		return new FoldedSlice(slice, width);
	}

	// 封装一个二维向量
	// 排列：行主序，即外层数组的每个元素代表一行
	public static Slice2D wrap(int[][] elements) {
		return new Array2DSlice(elements);
	}
}

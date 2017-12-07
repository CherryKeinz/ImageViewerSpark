package viewer.images;

import java.awt.Color;

import common.slice.Slice2D;
import viewer.PixelMap;

//位图：由黑白像素组成的图
public class BitMap implements PixelMap {
	public Slice2D pixels;

	// 排列：行主序，从上到下、从左到右
	// 颜色：1-涂黑；0-留白
	// 例：
	// Slice2D.wrap(new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 0, 1 }
	// })
	// ■□□□
	// ■■□□
	// □■□■
	public BitMap(int[][] pixels){
		this.pixels = Slice2D.wrap(pixels);
	}
	
	public BitMap(Slice2D pixels) {
		this.pixels = pixels;
	}

	@Override
	public Color getColor(int row, int column) {
		return pixels.get(row, column) == 1 ? Color.BLACK : Color.WHITE;
	}

	@Override
	public int getWidth() {
		return pixels.width();
	}

	@Override
	public int getHeight() {
		return pixels.height();
	}
}

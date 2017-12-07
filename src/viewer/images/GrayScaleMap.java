package viewer.images;

import java.awt.Color;

import common.slice.Slice2D;
import viewer.PixelMap;

//灰度图：由不同深度的灰色像素组成的图
public class GrayScaleMap implements PixelMap {
	public Slice2D pixels;

	// 排列：行主序，从上到下、从左到右
	// 颜色：范围[0-255]，0最白，255最黑
	// 例：
	// new int[][] { { 64, 128, 0, 0 }, { 191, 255, 0, 0 }, { 0, 128, 0, 255 } }
	// 浅中白白<br>
	// 深黑白白<br>
	// 白中白黑<br>
	public GrayScaleMap(int[][] pixels) {
		this.pixels = Slice2D.wrap(pixels);
	}

	public GrayScaleMap(Slice2D pixels) {
		this.pixels = pixels;
	}

	@Override
	public Color getColor(int row, int column) {
		int grayScale = 255 - pixels.get(row, column);
		return new Color(grayScale, grayScale, grayScale);
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

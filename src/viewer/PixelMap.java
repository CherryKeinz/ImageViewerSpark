package viewer;

import java.awt.Color;

public interface PixelMap {
	// 返回指定像素的颜色<br>
	// 使用屏幕坐标系，以左上角为第0行（y=0）第0列（x=0）
	Color getColor(int row, int column);

	int getWidth();

	int getHeight();
}

package test.viewer.images;

import javax.swing.JFrame;

import viewer.ImageDisplayerPanel;
import viewer.images.BitMap;

/**
 * 在窗口中显示一张黑白相间的棋盘图像，形如：<br>
 * □■□■……<br>
 * ■□■□……<br>
 * □■□■……<br>
 * ……<br>
 * 可以在运行时刻改变窗口大小，图像大小随之改变<br>
 * 对于较大的图像（例：1600*900），缩放时不会有严重卡顿
 */
public class DemoBitMap_large {
	public static void main(String[] args) {
		final int WINDOW_WIDTH = 1600;
		final int WINDOW_HEIGHT = 900;

		/* 棋盘图像。棋盘格的大小自动适应窗口 */
		// 可尝试其他大小，如1366*768
		final int BOARD_WIDTH = 400;
		final int BOARD_HEIGHT = 200;

		ImageDisplayerPanel imageDisplayer = new ImageDisplayerPanel();
		imageDisplayer.setImage(new BitMap(makeBitMap(BOARD_WIDTH, BOARD_HEIGHT)));

		JFrame frame = new JFrame();
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.add(imageDisplayer);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private static int[][] makeBitMap(int width, int height) {
		int[][] result = new int[height][];
		for (int row = 0; row < result.length; row++) {
			result[row] = new int[width];
			for (int column = 0; column < result[0].length; column++) {
				result[row][column] = (row + column) % 2;
			}
		}

		return result;
	}
}

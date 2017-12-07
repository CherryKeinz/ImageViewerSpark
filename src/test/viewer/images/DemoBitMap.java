package test.viewer.images;

import javax.swing.JFrame;

import viewer.ImageDisplayerPanel;
import viewer.images.BitMap;

/**
 * 在窗口中显示一张4*3位图（由黑白像素构成的图片），形如：<br>
 * ■□□□<br>
 * ■■□□<br>
 * □■□■<br>
 * 可以在运行时刻改变窗口大小，图像大小随之改变
 */
public class DemoBitMap {
	public static void main(String[] args) {
		final int WINDOW_WIDTH = 400;
		final int WINDOW_HEIGHT = 300;

		ImageDisplayerPanel imageDisplayer = new ImageDisplayerPanel();
		imageDisplayer.setImage(new BitMap(new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 0, 1 } }));

		JFrame frame = new JFrame();
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.add(imageDisplayer);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
package test.viewer.images;

import javax.swing.JFrame;

import viewer.ImageDisplayerPanel;
import viewer.images.GrayScaleMap;

/**
 * 在窗口中显示一张4*3灰度图（由不同深度的灰色像素构成的图片），形如：<br>
 * 浅中白白<br>
 * 深黑白白<br>
 * 白中白黑<br>
 * 色谱：<br>
 * 白-纯白 浅-25%灰 中-50%灰 深-75灰 黑-纯黑
 */
public class DemoGrayScaleMap {
	public static void main(String[] args) {
		final int WINDOW_WIDTH = 400;
		final int WINDOW_HEIGHT = 300;

		ImageDisplayerPanel imageDisplayer = new ImageDisplayerPanel();
		imageDisplayer
				.setImage(new GrayScaleMap(new int[][] { { 64, 128, 0, 0 }, { 191, 255, 0, 0 }, { 0, 128, 0, 255 } }));

		JFrame frame = new JFrame();
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.add(imageDisplayer);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
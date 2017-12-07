package test.viewer;

import javax.swing.JFrame;

import viewer.ImageDisplayerFrame;
import viewer.images.BitMap;

public class DemoImageDisplayerFrame {
	public static void main(String[] args) {
		int[][] pixels = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 0, 1 } };

		ImageDisplayerFrame window = new ImageDisplayerFrame(1366, 768);
		window.setImage(new BitMap(pixels));
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

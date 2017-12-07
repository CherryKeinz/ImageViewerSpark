package test.viewer;

import javax.swing.JFrame;

import viewer.ImageDisplayerPanel;
import viewer.images.BitMap;

public class DemoImageDisplayerPanel {
	public static void main(String[] args) {
		int[][] pixels = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 0, 1, 0, 1 } };

		JFrame window = new JFrame();
		ImageDisplayerPanel panel = new ImageDisplayerPanel();
		panel.setImage(new BitMap(pixels));
		window.setSize(1366, 768);
		window.add(panel);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setVisible(true);

	}
}

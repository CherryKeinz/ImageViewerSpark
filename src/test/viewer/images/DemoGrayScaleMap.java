package test.viewer.images;

import javax.swing.JFrame;

import viewer.ImageDisplayerPanel;
import viewer.images.GrayScaleMap;

/**
 * �ڴ�������ʾһ��4*3�Ҷ�ͼ���ɲ�ͬ��ȵĻ�ɫ���ع��ɵ�ͼƬ�������磺<br>
 * ǳ�аװ�<br>
 * ��ڰװ�<br>
 * ���а׺�<br>
 * ɫ�ף�<br>
 * ��-���� ǳ-25%�� ��-50%�� ��-75�� ��-����
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
package test.viewer.images;

import javax.swing.JFrame;

import viewer.ImageDisplayerPanel;
import viewer.images.BitMap;

/**
 * �ڴ�������ʾһ��4*3λͼ���ɺڰ����ع��ɵ�ͼƬ�������磺<br>
 * ��������<br>
 * ��������<br>
 * ��������<br>
 * ����������ʱ�̸ı䴰�ڴ�С��ͼ���С��֮�ı�
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
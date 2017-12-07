package test.viewer.images;

import javax.swing.JFrame;

import viewer.ImageDisplayerPanel;
import viewer.images.BitMap;

/**
 * �ڴ�������ʾһ�źڰ���������ͼ�����磺<br>
 * ������������<br>
 * ������������<br>
 * ������������<br>
 * ����<br>
 * ����������ʱ�̸ı䴰�ڴ�С��ͼ���С��֮�ı�<br>
 * ���ڽϴ��ͼ������1600*900��������ʱ���������ؿ���
 */
public class DemoBitMap_large {
	public static void main(String[] args) {
		final int WINDOW_WIDTH = 1600;
		final int WINDOW_HEIGHT = 900;

		/* ����ͼ�����̸�Ĵ�С�Զ���Ӧ���� */
		// �ɳ���������С����1366*768
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

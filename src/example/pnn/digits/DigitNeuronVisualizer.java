package example.pnn.digits;

import java.awt.GridLayout;

import javax.swing.JFrame;

import common.slice.Slice;
import common.slice.Slice2D;
import pnn.Neuron;
import viewer.ImageDisplayerPanel;
import viewer.images.GrayScaleMap;

//在图形界面窗口中可视化展示识别各个数字的神经元
//以10张图片显示神经元0-9对于各输入的权重。图片中的像素越黑，则该处输入降低属于指定数字的概率；反之提升概率
//各个数字对应的显示位置：
//1 2 3
//4 5 6
//7 8 9
//0
public class DigitNeuronVisualizer extends JFrame {
	private static final long serialVersionUID = 434378073710744157L;

	// 第i个元素存储识别数字i的神经元
	private ImageDisplayerPanel[] imagePanels;
	private int imageWidth;

	public DigitNeuronVisualizer(int windowWidth, int windowHeight, int imageWidth) {
		this.imageWidth = imageWidth;

		setSize(windowWidth, windowHeight);
		setLayout(new GridLayout(0, 3));

		imagePanels = new ImageDisplayerPanel[10];
		for (int digit = 1; digit <= 9; digit++) {
			imagePanels[digit] = new ImageDisplayerPanel();
			add(imagePanels[digit]);
		}
		imagePanels[0] = new ImageDisplayerPanel();
		add(imagePanels[0]);
	}

//	public void visualize(Neuron neuron, int digit) {
//		Slice color = Slice.map(Slice.wrap(neuron.weights.internal()),
//				weight -> 255 - (int) (255. * sigmoid((double) weight)));
//		imagePanels[digit].setImage(new GrayScaleMap(Slice2D.fold(color, imageWidth)));
//	}

	// sigmoid函数，可将(负无穷, 正无穷)映射到(0, 1)
	private static double sigmoid(double value) {
		return 1. / (1. + Math.exp(-0.001 * value));
	}
}

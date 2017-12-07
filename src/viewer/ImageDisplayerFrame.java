package viewer;

import javax.swing.JFrame;

//工具类：创建单独的窗口，在其中居中显示图像
//创建一个独立的JFrame，内含一个{@link ImageDisplayerPanel}用于显示图像
public class ImageDisplayerFrame extends JFrame {
	private static final long serialVersionUID = -2388139515472622647L;

	private ImageDisplayerPanel imagePanel;

	public ImageDisplayerFrame(int width, int height) {
		imagePanel = new ImageDisplayerPanel();

		setSize(width, height);
		add(imagePanel);
		setVisible(true);
	}

	public void setImage(PixelMap image) {
		imagePanel.setImage(image);
	}
}

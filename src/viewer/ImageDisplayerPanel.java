package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

//创建JPanel并居中显示指定图像
public class ImageDisplayerPanel extends JPanel {
	private static final long serialVersionUID = 2360281088047055523L;

	private PixelMap image;

	public ImageDisplayerPanel() {
		image = null;
	}

	//允许运行时设置新图片；但是不保证线程安全
	public void setImage(PixelMap image) {
		this.image = image;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		if (image == null) {
			return;
		}

		for (int row = 0; row < image.getHeight(); row++) {
			for (int column = 0; column < image.getWidth(); column++) {
				paintPixel(g, row, column, image.getColor(row, column));
			}
		}
	}

	// 为了居中显示图像，应该把图像的左上角放在什么地方
	private Point getImageTopLeftLocation() {
		return new Point((getWidth() - getPixelScale().width * image.getWidth()) / 2,
				(getHeight() - getPixelScale().height * image.getHeight()) / 2);
	}

	private Dimension getPixelScale() {
		return new Dimension(getWidth() / image.getWidth(), getHeight() / image.getHeight());
	}

	private void paintPixel(Graphics g, int row, int column, Color color) {
		g.setColor(color);
		g.fillRect(getImageTopLeftLocation().x + getPixelScale().width * column,
				getImageTopLeftLocation().y + getPixelScale().height * row, getPixelScale().width,
				getPixelScale().height);
	}

}

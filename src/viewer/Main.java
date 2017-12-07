package viewer;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) {
		JFrame main = new JFrame();
		main.setSize(1024, 768);

		JLabel label = new JLabel();
		//label.setText("abc");
		BufferedImage image = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, 0xFF000000 );
		image.setRGB(1, 0, 0xFFFFFFFF );
		image.setRGB(0, 1, 0xFF000000 );
		image.setRGB(1, 1, 0xFFFFFFFF );
		label.setIcon(new ImageIcon(image));
		main.add(label);

		main.setVisible(true);
	}
}

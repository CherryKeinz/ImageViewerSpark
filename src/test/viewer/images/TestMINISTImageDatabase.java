package test.viewer.images;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import org.junit.Test;

import common.slice.Slice;
import common.slice.Slice2D;
import viewer.ImageDisplayerFrame;
import viewer.images.GrayScaleMap;
import viewer.images.MNISTImageDatabase;

public class TestMINISTImageDatabase {

	@Test
	public void test() {
		File file = new File(System.getProperty("user.dir") + "/src/test/viewer/images/train-images.idx3-ubyte");
		System.out.println("文件：" + file.getAbsolutePath());
		if (!file.exists()) {
			fail("文件不存在");
		}

		MNISTImageDatabase mnist = null;
		try {
			mnist = MNISTImageDatabase.loadFile(file);
		} catch (FileNotFoundException e) {
			fail("无法打开文件");
		} catch (IOException e) {
			fail("读取文件头失败");
		}

		assertEquals(2051, mnist.getHeader());
		assertEquals(60000, mnist.countImage());
		assertEquals(28, mnist.imageHeight());
		assertEquals(28, mnist.imageWidth());

		ImageDisplayerFrame frame = new ImageDisplayerFrame(200, 200);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Slice2D image = Slice2D.fold(Slice.wrap(new int[mnist.imageHeight() * mnist.imageWidth()]),
				mnist.imageWidth());

		/* 在窗口中显示前10张图片。关闭窗口可直接结束测试 */
		try {
			for (int i = 0; i < 10; i++) {
				// throws IOException
				mnist.readImage(image);

				frame.setImage(new GrayScaleMap(image));

				/* 等待一段时间再读取下一张图片，以便看清读取到的图片 */
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// 当关闭窗口时，执行的动作是JFrame.HIDE_ON_CLOSE
				// 故用isVisible方法判断是否已关闭窗口。如果已关闭，则结束测试
				if (!frame.isVisible()) {
					break;
				}
			}
		} catch (IOException e) {
			fail("读取图像失败：" + e);
		} finally {
			mnist.close();
		}
	}
}

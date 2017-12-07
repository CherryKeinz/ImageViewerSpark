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
		System.out.println("�ļ���" + file.getAbsolutePath());
		if (!file.exists()) {
			fail("�ļ�������");
		}

		MNISTImageDatabase mnist = null;
		try {
			mnist = MNISTImageDatabase.loadFile(file);
		} catch (FileNotFoundException e) {
			fail("�޷����ļ�");
		} catch (IOException e) {
			fail("��ȡ�ļ�ͷʧ��");
		}

		assertEquals(2051, mnist.getHeader());
		assertEquals(60000, mnist.countImage());
		assertEquals(28, mnist.imageHeight());
		assertEquals(28, mnist.imageWidth());

		ImageDisplayerFrame frame = new ImageDisplayerFrame(200, 200);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Slice2D image = Slice2D.fold(Slice.wrap(new int[mnist.imageHeight() * mnist.imageWidth()]),
				mnist.imageWidth());

		/* �ڴ�������ʾǰ10��ͼƬ���رմ��ڿ�ֱ�ӽ������� */
		try {
			for (int i = 0; i < 10; i++) {
				// throws IOException
				mnist.readImage(image);

				frame.setImage(new GrayScaleMap(image));

				/* �ȴ�һ��ʱ���ٶ�ȡ��һ��ͼƬ���Ա㿴���ȡ����ͼƬ */
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// ���رմ���ʱ��ִ�еĶ�����JFrame.HIDE_ON_CLOSE
				// ����isVisible�����ж��Ƿ��ѹرմ��ڡ�����ѹرգ����������
				if (!frame.isVisible()) {
					break;
				}
			}
		} catch (IOException e) {
			fail("��ȡͼ��ʧ�ܣ�" + e);
		} finally {
			mnist.close();
		}
	}
}

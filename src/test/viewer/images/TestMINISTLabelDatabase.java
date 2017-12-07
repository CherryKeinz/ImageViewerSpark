package test.viewer.images;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import viewer.images.MNISTLabelDatabase;

public class TestMINISTLabelDatabase {

	@Test
	public void test() {
		File file = new File(System.getProperty("user.dir") + "/src/test/viewer/images/train-labels.idx1-ubyte");
		System.out.println("�ļ���" + file.getAbsolutePath());
		if (!file.exists()) {
			fail("�ļ�������");
		}

		MNISTLabelDatabase mnist = null;
		try {
			mnist = MNISTLabelDatabase.loadFile(file);
		} catch (FileNotFoundException e) {
			fail("�޷����ļ�");
		} catch (IOException e) {
			fail("��ȡ�ļ�ͷʧ��");
		}

		assertEquals(2049, mnist.getHeader());
		assertEquals(60000, mnist.countLabel());
		
		try {
			assertEquals(5, mnist.readLabel());
			assertEquals(0, mnist.readLabel());
			assertEquals(4, mnist.readLabel());
			assertEquals(1, mnist.readLabel());
			assertEquals(9, mnist.readLabel());
			assertEquals(2, mnist.readLabel());
			assertEquals(1, mnist.readLabel());
			assertEquals(3, mnist.readLabel());
			assertEquals(1, mnist.readLabel());
			assertEquals(4, mnist.readLabel());
		} catch (IOException e) {
			fail("��ȡ��ǩʧ�ܣ�"+e);
		} finally {
			mnist.close();
		}
	}
}

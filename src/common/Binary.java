package common;

import java.io.FileInputStream;
import java.io.IOException;

public class Binary {
	public static int readBigEndianInt(FileInputStream input) throws IOException {
		int result = 0;

		/* ÿ�ζ�ȡ8λ����1�ֽڣ���ƴ��Ϊint������ȡ4�ֽ� */
		for (int i = 0; i < 4; i++) {
			int next8bits = input.read();// throws IOException

			if (next8bits == -1) {
				throw new IOException("û�ж�ȡ�㹻���ֽ���ƴ��int");
			}

			// ����д����result << 8 + next8bits
			// ����ԭ��<<�����ȼ���+�����ȼ���
			result = (result << 8) + next8bits;
		}

		return result;
	}
}

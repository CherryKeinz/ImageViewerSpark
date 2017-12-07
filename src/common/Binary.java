package common;

import java.io.FileInputStream;
import java.io.IOException;

public class Binary {
	public static int readBigEndianInt(FileInputStream input) throws IOException {
		int result = 0;

		/* 每次读取8位（即1字节）并拼接为int；共读取4字节 */
		for (int i = 0; i < 4; i++) {
			int next8bits = input.read();// throws IOException

			if (next8bits == -1) {
				throw new IOException("没有读取足够的字节来拼接int");
			}

			// 错误写法：result << 8 + next8bits
			// 错误原因：<<的优先级比+的优先级低
			result = (result << 8) + next8bits;
		}

		return result;
	}
}

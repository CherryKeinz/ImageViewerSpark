package common;

import java.io.IOException;
import java.io.InputStream;

public class IO {
	public static void closeQuietly(InputStream input) {
		try {
			input.close();
		} catch (IOException e) {
		}
	}
}

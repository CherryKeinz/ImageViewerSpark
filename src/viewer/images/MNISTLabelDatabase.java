package viewer.images;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import common.Binary;
import common.IO;

public class MNISTLabelDatabase {
	private InputStream input;

	private int header;
	private int countLabel;

	public static MNISTLabelDatabase loadFile(File file) throws FileNotFoundException, IOException {
		/* throws FileNotFoundException */
		FileInputStream input = new FileInputStream(file);

		/* throws IOException */
		int header;
		int countImage;
		try {
			header = Binary.readBigEndianInt(input);
			countImage = Binary.readBigEndianInt(input);
		} catch (IOException e) {
			IO.closeQuietly(input);
			throw e;
		}

		MNISTLabelDatabase mnist = new MNISTLabelDatabase(input, header, countImage);
		return mnist;
	}

	private MNISTLabelDatabase(FileInputStream input, int header, int countLabel) {
		this.input = input;
		this.header = header;
		this.countLabel = countLabel;
	}

	public int getHeader() {
		return header;
	}

	public int countLabel() {
		return countLabel;
	}

	public int readLabel() throws IOException {
		int result;
		try {
			result = input.read(); // throws IOException

			if (result == -1) {
				throw new IOException("没有读取到标签");
			}
		} catch (IOException e) {
			IO.closeQuietly(input);
			throw e;
		}

		return result;
	}

	public void close() {
		IO.closeQuietly(input);
	}
}

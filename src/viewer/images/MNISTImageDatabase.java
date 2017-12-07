package viewer.images;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import common.Binary;
import common.IO;
import common.slice.Slice2D;

public class MNISTImageDatabase {
	private InputStream input;

	private int header;
	private int countImage;
	private int countRow;
	private int countColumn;

	public static MNISTImageDatabase loadFile(File file) throws FileNotFoundException, IOException {
		/* throws FileNotFoundException */
		FileInputStream input = new FileInputStream(file);

		/* throws IOException */
		int header;
		int countImage;
		int countRow;
		int countColumn;
		try {
			header = Binary.readBigEndianInt(input);
			countImage = Binary.readBigEndianInt(input);
			countRow = Binary.readBigEndianInt(input);
			countColumn = Binary.readBigEndianInt(input);
		} catch (IOException e) {
			IO.closeQuietly(input);
			throw e;
		}

		MNISTImageDatabase mnist = new MNISTImageDatabase(input, header, countImage, countRow, countColumn);
		return mnist;
	}

	private MNISTImageDatabase(FileInputStream input, int header, int countImage, int countRow, int countColumn) {
		this.input = input;
		this.header = header;
		this.countImage = countImage;
		this.countRow = countRow;
		this.countColumn = countColumn;
	}

	public int getHeader() {
		return header;
	}

	public int countImage() {
		return countImage;
	}

	public int imageHeight() {
		return countRow;
	}

	public int imageWidth() {
		return countColumn;
	}

	// 读取图片，存入数组切片
	public void readImage(Slice2D pixels) throws IOException {
		try {
			for (int row = 0; row < countRow; row++) {
				for (int column = 0; column < countColumn; column++) {
					int pixel = input.read();
					if (pixel == -1) {
						throw new IOException("读取图像失败，没有更多像素");
					}
					pixels.set(row, column, pixel);
				}
			}
		} catch (IOException e) {
			IO.closeQuietly(input);
			throw e;
		}
	}
	public void readImage(Integer[] in) throws IOException {
		try {
			for (int row = 0; row < countRow; row++) {
				for (int column = 0; column < countColumn; column++) {
					int pixel = input.read();
					if (pixel == -1) {
						throw new IOException("读取图像失败，没有更多像素");
					}
					in[row * countColumn + column] = pixel;
				}
			}
		} catch (IOException e) {
			IO.closeQuietly(input);
			throw e;
		}
	}
	public void close() {
		IO.closeQuietly(input);
	}
}

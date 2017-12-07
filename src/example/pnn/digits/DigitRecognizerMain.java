package example.pnn.digits;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import common.slice.Slice;
import common.slice.Slice2D;
import viewer.images.MNISTImageDatabase;
import viewer.images.MNISTLabelDatabase;

/*案例：感知神经网络识别图片上的数字*/
public class DigitRecognizerMain {
//	public static void main(String[] args) throws Exception {
//		String path = "D:\\MyCode\\Eclipse\\ImageViewer\\images/";
//		MNISTImageDatabase trainingImages = openMnistImages(path + "train-images.idx3-ubyte");
//		MNISTLabelDatabase trainingLabels = openMnistLabels(path + "train-labels.idx1-ubyte");
//		MNISTImageDatabase testingImages = openMnistImages(path + "t10k-images.idx3-ubyte");
//		MNISTLabelDatabase testingLabels = openMnistLabels(path + "t10k-labels.idx1-ubyte");
//
//		DigitImageRecognizer recognizer = new DigitImageRecognizer(trainingImages.imageWidth(),
//				trainingImages.imageHeight());
//
//		DigitNeuronVisualizer visualizer = new DigitNeuronVisualizer(600, 800, trainingImages.imageWidth());
//		visualizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		visualizer.setVisible(true);
//
//		/* 训练 */
//		for (int imageIndex = 0; imageIndex < trainingImages.countImage(); imageIndex++) {
//			int[] input = new int[trainingImages.imageWidth() * trainingImages.imageHeight() + 1];
//			input[input.length - 1] = 1;
//
//			int label = trainingLabels.readLabel();
//			Slice2D image = Slice2D.fold(Slice.wrap(input), trainingImages.imageWidth());
//			trainingImages.readImage(image);
//
//			recognizer.train(Slice.wrap(input), label);
//
//			int countTrained = imageIndex + 1;
//			if (countTrained % 100 == 0) {
//				for (int digit = 0; digit <= 9; digit++) {
//					visualizer.visualize(recognizer.neurons[digit], digit);
//				}
//
//				System.out.println("progress: " + countTrained + "/" + trainingImages.countImage());
//			}
//		}
//
//		/* 测试 */
//		int[] countCorrect = new int[10];
//		int[] countError = new int[10];
//		for (int i = 0; i < testingImages.countImage(); i++) {
//			int[] input = new int[testingImages.imageWidth() * testingImages.imageHeight() + 1];
//			input[input.length - 1] = 1;
//
//			int label = testingLabels.readLabel();
//			Slice2D image = Slice2D.fold(Slice.wrap(input), testingImages.imageWidth());
//			testingImages.readImage(image);
//
//			if (recognizer.test(Slice.wrap(input), label)) {
//				countCorrect[label]++;
//			} else {
//				countError[label]++;
//			}
//		}
//
//		System.out.println("数字(正确/错误/总共)");
//		for (int digit = 0; digit <= 9; digit++) {
//			System.out.println(digit + "(" + countCorrect[digit] + "/" + countError[digit] + "/"
//					+ (countCorrect[digit] + countError[digit]) + ")");
//		}
//	}

	public static MNISTImageDatabase openMnistImages(String path) throws IOException {
		File file = new File(path);
		System.out.println("图片：" + file.getAbsolutePath());
		return MNISTImageDatabase.loadFile(file);
	}

	public static MNISTLabelDatabase openMnistLabels(String path) throws IOException {
		File file = new File(path);
		System.out.println("标签：" + file.getAbsolutePath());
		return MNISTLabelDatabase.loadFile(file);
	}
}

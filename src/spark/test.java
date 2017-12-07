package spark;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import common.slice.Slice;
import common.spark.SparkUtil;
import example.pnn.digits.DigitImageRecognizer;
import example.pnn.digits.DigitRecognizerMain;
import scala.Tuple2;
import viewer.images.MNISTImageDatabase;
import viewer.images.MNISTLabelDatabase;

public class test {
	public static void main(String[] args) throws IOException, InterruptedException {
		SparkUtil spark = SparkUtil.getInstance();
		

		String path = "D:\\MyCode\\Eclipse\\ImageViewer\\images/";
		
		//记得openMnistImages改回private
		MNISTImageDatabase trainingImages = DigitRecognizerMain.openMnistImages(path + "train-images.idx3-ubyte");
		MNISTLabelDatabase trainingLabels = DigitRecognizerMain.openMnistLabels(path + "train-labels.idx1-ubyte");
		MNISTImageDatabase testingImages = DigitRecognizerMain.openMnistImages(path + "t10k-images.idx3-ubyte");
		MNISTLabelDatabase testingLabels = DigitRecognizerMain.openMnistLabels(path + "t10k-labels.idx1-ubyte");
		DigitImageRecognizer recognizer = new DigitImageRecognizer(trainingImages.imageWidth(),
				trainingImages.imageHeight());

		/* 训练 *///trainingImages.countImage()
		for (int imageIndex = 0; imageIndex < 5; imageIndex++) {
			Integer[] input = new Integer[trainingImages.imageWidth() * trainingImages.imageHeight() + 1];
			input[input.length - 1] = 1;
			int label = trainingLabels.readLabel();
			trainingImages.readImage(input);
			JavaPairRDD<Integer,Integer> inputRDD = spark.getRDD(input);

			recognizer.train(inputRDD, label);
		}


		System.out.println("train completed!!");
		/* 测试 */
		int[] countCorrect = new int[10];
		int[] countError = new int[10];
		for (int i = 0; i < 5; i++) {
			Integer[] input = new Integer[testingImages.imageWidth() * testingImages.imageHeight() + 1];
			input[input.length - 1] = 1;

			int label = testingLabels.readLabel();
			testingImages.readImage(input);
			JavaPairRDD<Integer,Integer> inputRDD = spark.getRDD(input);
			if (recognizer.test(inputRDD, label)) {
				countCorrect[label]++;
			} else {
				countError[label]++;
			}
		}
		System.out.println("数字(正确/错误/总共)");
		for (int digit = 0; digit <= 9; digit++) {
			System.out.println(digit + "(" + countCorrect[digit] + "/" + countError[digit] + "/"
					+ (countCorrect[digit] + countError[digit]) + ")");
		}
	}
}

package example.pnn.digits;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

import common.slice.Slice;
import pnn.Neuron;

//识别图片上的数字
//输入特征：图片上的全部像素（范围：[0, 255]）、常数项1
public class DigitImageRecognizer {
	// neurons[i]存储识别数字i的神经元
	public Neuron[] neurons;

	public DigitImageRecognizer(int imageWidth, int imageHeight) {
		neurons = new Neuron[10];
		for (int digit = 0; digit <= 9; digit++) {
			neurons[digit] = new Neuron(imageWidth * imageHeight + 1);
		}
	}

	public void train(JavaPairRDD<Integer,Integer> input, int expectedDigit) {
		for (int digit = 0; digit <= 9; digit++) {
			neurons[digit].train(input, digit == expectedDigit ? 1 : 0);
		}
	}

	public boolean test(JavaPairRDD<Integer,Integer> input, int expectedDigit) {
		int maxConfidence = Integer.MIN_VALUE;
		int mostPossibleDigit = -1;
		for (int digit = 0; digit <= 9; digit++) {
			int confidence = neurons[digit].input(input).confidence;
			if (confidence > maxConfidence) {
				maxConfidence = confidence;
				mostPossibleDigit = digit;
			}
		}

		return mostPossibleDigit == expectedDigit;
	}
}

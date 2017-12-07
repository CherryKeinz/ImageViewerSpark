package pnn;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

import common.slice.Slice;
import common.spark.SparkUtil;
import scala.Tuple2;

//参考：https://www.bilibili.com/video/av9838961/#page=7
public class Neuron {
	//public Slice weights;
	public JavaPairRDD<Integer,Integer> weightsRDD;
	
	public Neuron(int inputVectorSize) {
		SparkUtil spark = SparkUtil.getInstance();
		Integer[] weight = new Integer[inputVectorSize];
		for(int i = 0;i < weight.length; i++) {
			weight[i] = 0;
		}
		weightsRDD = spark.getRDD(weight);
		//weights = Slice.wrap(new int[inputVectorSize]);
	}

	public Guess input(JavaPairRDD<Integer,Integer> inputVector) {
		int output = innerProduct(inputVector);
		return new Guess(output > 0 ? 1 : 0, output);
	}

	private int innerProduct(JavaPairRDD<Integer,Integer> inputVector) {
//		List<Tuple2<Integer, Integer>> re = weightsRDD.collect();
//		for(Tuple2<Integer, Integer> r:re) {
//			System.out.println(r);
//		}

		return weightsRDD.union(inputVector)
				.reduceByKey((x, y) -> x * y).values().
				reduce((x, y) -> x + y);
	}

	public void train(JavaPairRDD<Integer,Integer>  inputVector, int expectdLabel) {
		int actualLabel = input(inputVector).label;
			
		if (expectdLabel == 1 && actualLabel == 0) {
			//weights.add(inputVector);
			weightsRDD = weightsRDD.union(inputVector).reduceByKey((x, y) -> x + y);
		} else if (expectdLabel == 0 && actualLabel == 1) {
			//weights.substract(inputVector);
			weightsRDD = weightsRDD.union(inputVector).reduceByKey((x, y) -> x + y);
		}
	}
}

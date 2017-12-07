package common.spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkUtil {
	private static SparkUtil instance = null;  
	private static JavaSparkContext sc = null;
    private SparkUtil (){}  
    public static SparkUtil getInstance() {  
    	if(instance == null) {
        	SparkConf conf = new SparkConf();
        	sc = new JavaSparkContext("spark://10.103.246.6:7077", "test ImageViewer", conf);    	
        	sc.addJar("file://D:/MyCode/Eclipse/ImageViewerSpark/imageViewer.jar");
        	instance = new SparkUtil();
    	}
    	return instance;  
    }    
    
    public JavaPairRDD<Integer,Integer> getRDD(Integer[] input){
    	List<Tuple2<Integer,Integer>> list = new ArrayList<Tuple2<Integer,Integer>>();
    	for(int i = 0 ; i < input.length ;i ++) {
    		list.add(new Tuple2<Integer,Integer>(i,input[i])); 
    	}
    	return sc.parallelizePairs(list);
    }
}

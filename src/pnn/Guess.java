package pnn;

//数据对象，用于存储神经元的输出
public class Guess {
	// 取值：0-不属于指定类别；1-属于指定类别
	public int label;

	// 当取正/负值时，绝对值越大，则属于/不属于指定类别的确定程度越高
	public int confidence;

	public Guess(int label, int confidence) {
		this.label = label;
		this.confidence = confidence;
	}

	@Override
	public String toString() {
		return label + "(" + confidence + ")";
	}
}

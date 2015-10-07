package TP2;

public class DaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TP22 test = new TP22();
		
		test.testContructor(-1,22,12);
		test.testContructor(23,22,12);
		test.testContructor(3,-5,12);
		test.testContructor(3,51,12);
		test.testContructor(3,22,-7);
		test.testContructor(3,22,152);
		test.testContructor(5,22,47);
		
	}

}

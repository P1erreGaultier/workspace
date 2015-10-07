package TP1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pile p = new Pile();
		/*p.pop();*/
		p.push(1);
		p.push(2);
		p.push(3);
		p.push(4);
		p.push(5);
		p.push(6);
		p.push(7);
		p.push(8);
		p.push(9);
		p.push(10);
	
		Temperature T = new Temperature();
		
		System.out.println(T.CtoF(-300.25));
		
		System.out.println(T.FtoC(14));
	}

}

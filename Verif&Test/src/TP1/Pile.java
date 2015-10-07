package TP1;

import java.util.ArrayList;

public class Pile {

	private ArrayList<Integer> A;  

	public Pile() {
		A = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getA() {
		return A;
	}

	public void setA(ArrayList<Integer> a) {
		A = a;
	}
	
	
	public boolean push (int i){
		assert this.getA().size()<10 : "La pile est pleine";
		this.getA().add(i);
		return true;		
	}
	
	public int pop(){
		assert this.getA().size()>0 : "La pile est vide";
		int i = (int) this.getA().get(this.getA().size()-1);
		this.getA().remove(this.getA().size()-1);
		return i;

	}

	
	
}

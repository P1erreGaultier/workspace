package com.poney;

import java.util.ArrayList;
import java.util.Random;

public class Poney {

	private String name;
	private int i1;
	private int i2;
	Random r = new Random();
	private ArrayList<Integer> StockageDegueu;
	public int cpt = 0;
	
	public Poney(String n){
		this.name = n;
		StockageDegueu = new ArrayList<Integer>();
	}
	
	public void play(){
		i1 = r.nextInt(5) + 1;
        i2 = r.nextInt(5) + 1;
        StockageDegueu.add(i1);
        StockageDegueu.add(i2);

        cpt++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getI1() {
		return i1;
	}

	public void setI1(int i1) {
		this.i1 = i1;
	}

	public int getI2() {
		return i2;
	}

	public void setI2(int i2) {
		this.i2 = i2;
	}

	@Override
	public String toString() {
		return "Poney [name=" + name + ", i1=" + i1 + ", i2=" + i2 + ", cpt=" + cpt + "]";
	}

	public ArrayList<Integer> getStockageDegueu() {
		return StockageDegueu;
	}

	public void setStockageDegueu(ArrayList<Integer> stockageDegueu) {
		StockageDegueu = stockageDegueu;
	}
	
	
}

package TP1;

public class Temperature {

	public double  CtoF(double celsius){
		
		double res = celsius*9/5 + 32;
		assert celsius > -273.15 : "Le parametre est inferieur au zero absolu";
		if (celsius == 0){
			assert res == 32.0 : "bonne conversion de zero";
		}
		return res;
	}

	public double  FtoC(double fahr){
		
		double res = (fahr- 32)*5/9;
		assert fahr > -459.67 : "Le parametre est inferieur au zero absolu";
		if (fahr == 0){
			assert res == 32.0 : "bonne conversion de zero";
		}
		return res;
	}
}
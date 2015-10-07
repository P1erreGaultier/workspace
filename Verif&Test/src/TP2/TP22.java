package TP2;

import org.junit.Test;



public class TP22{

	 @Test(expected=TimerException.class)
	  public void testContructor(int ring , int hour, int min)
	  {
			try {
				Timer T = new Timer(ring,hour,min);
			} catch (TimerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}    
	  }


}

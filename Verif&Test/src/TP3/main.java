package TP3;

import static org.mockito.Mockito.*; 	

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Timer doublure = mock(Timer.class);
		try {
			doublure = new Timer(3, 12, 30);
		} catch (TimerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package TP3;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*; 	

@RunWith(MockitoJUnitRunner.class)
public class test1 {

	GregorianCalendar doublure = mock(GregorianCalendar.class);
	
	@Test
	public void test11() {
		Timer T = null;
		try {
			T = new Timer(3, 12, 30);
	    } catch (TimerException var3) {
	        System.out.println(var3);
	    } 
		when(doublure.get(1)).thenReturn(9);
		when(doublure.get(2)).thenReturn(23);
		T.setActive(true,doublure);
		assertFalse(T.isRinging());
	}

	@Test
	public void test12() {
		Timer T = null;
		try {
			T = new Timer(3, 12, 30);
	    } catch (TimerException var3) {
	        System.out.println(var3);
	    } 
		when(doublure.get(1)).thenReturn(15);
		when(doublure.get(2)).thenReturn(6);
		T.setActive(true,doublure);
		assertFalse(T.isRinging());
	}

	
}

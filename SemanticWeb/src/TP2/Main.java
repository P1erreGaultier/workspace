package TP2;

import java.io.IOException;

import org.apache.jena.query.Query;
import org.apache.jena.query.ResultSet;

public class Main {

	/**
	 * @param args
	 * @throws  
	 */
	public static void main(String[] args) {
		SparQLQuery SPQR = new SparQLQuery();
		SPQR.readData("dataset.rdf");
		/*SPQR.getModel().write(System.out,"Turtle");*/
		ResultSet R1=null;
		Query Req1=null;
		try {
			Req1 = SPQR.readQuery("rq1.sparql");
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		R1 =SPQR.doQuery(Req1);
		SPQR.res(R1);
	}

}

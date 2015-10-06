package TP2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class SparQLQuery {

	private Model model ;
	

	public SparQLQuery() {
		this.model = ModelFactory.createDefaultModel();
	}

	

	
	public org.apache.jena.query.Query readQuery(String fichier) throws IOException{
		String ligne = "a";
		String res = "";
		BufferedReader input;
		
			input = new BufferedReader(new FileReader(fichier));
			while ((ligne = input.readLine()) != null) {
				res = res + ligne + "\n";
			} 
			input.close();
			
			return QueryFactory.create(res);
	}

	
	public void readData(String input){
	       InputStream in = FileManager.get().open( input );
	        if (in == null) {
	            throw new IllegalArgumentException( "File: " + input + " not found");
	        }
	        this.model.read(in, "");
	}

	public ResultSet doQuery(org.apache.jena.query.Query Q){

		ResultSet results=null;
		        try {
		        	QueryExecution qexec= QueryExecutionFactory.create(Q, model);
		        	results = qexec.execSelect() ;
		        } catch(Exception e) {
		            System.err.println(e.getMessage());
		        }

		return results;
	}

    public void res(ResultSet results) {
        QuerySolution soln = null;

        for ( ; results.hasNext() ; ) {
            soln = results.nextSolution() ;
            System.out.println(soln.toString());
        }
    }

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}


}

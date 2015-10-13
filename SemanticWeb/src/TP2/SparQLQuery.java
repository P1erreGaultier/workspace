package TP2;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.core.DatasetImpl;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.apache.jena.util.FileManager;

public class SparQLQuery {

	private Dataset dataset;
	
	/*
	 *Constructor
	 */
	public SparQLQuery() {
		this.dataset = new DatasetImpl(ModelFactory.createDefaultModel());
	}
	
	/* Metode qui lie une fichier contenant une requete sparql et qui renvoie une String */
	public String readQuery(String fichier){
        List<String> lines = null;
        String query = "";
        try {
        	/* a changer en fonction du pc*/
            lines = Files.readAllLines(Paths.get("C:\\Users\\Pierre\\workspace\\SemanticWeb\\src\\",fichier), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String l: lines) {
        	
            query = query + " " + l;
        }
			return query;
	}

	/* methode qui lit un fichier rdf, et qui construit le graphe par default correspondant */
	public void readDataDefaultGraph(String input){
	       InputStream in = FileManager.get().open( input );
	        if (in == null) {
	            throw new IllegalArgumentException( "File: " + input + " not found");
	        }
	        this.dataset.getDefaultModel().read(in, null);
	}
	
	/* methode qui lit un fichier rdf, et qui construit le graphe nommé correspondant */
	public void readDataNamedGraph(String uri,String input){
	       InputStream in = FileManager.get().open( input );
	        if (in == null) {
	            throw new IllegalArgumentException( "File: " + input + " not found");
	        }
	        this.dataset.addNamedModel(uri, ModelFactory.createDefaultModel().read(in, null));
	}

	/* methode qui execute une requete sparql de type select sur le dataset de cette classe */
	public ResultSet doQuerySelect(String sQ){
		Query Q = null;
		ResultSet results=null;
		/*on crée la requette a partir du fichier */
		Q = QueryFactory.create(this.readQuery(sQ));
		/*Execution*/
		try {
		     QueryExecution qexec= QueryExecutionFactory.create(Q, this.dataset);
		     results = qexec.execSelect() ;
		} catch(Exception e) {
		    System.err.println(e.getMessage());
		}
		return results;
	}

	/* methode qui execute une requete sparql de type update sur le dataset de cette classe */
    public void doQueryUpdate(String sQ) {
    	UpdateRequest Q = null;
    	/*on crée la requette a partir du fichier */
		Q = UpdateFactory.create(this.readQuery(sQ));
		/*Execution*/
        try {
            UpdateProcessor qexec = UpdateExecutionFactory.create(Q, this.dataset);
            qexec.execute();
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
	/* methode qui active l'inference, soit sur le graphe par default, soit sur le graphe nommé en parametre */
    public void enableRDFS(String uri) {
        InfModel new_model = null;
        if(uri == null) {
            new_model = ModelFactory.createRDFSModel(this.dataset.getDefaultModel());
            this.dataset.setDefaultModel(new_model);
        } else { 
            new_model = ModelFactory.createRDFSModel(this.dataset.getNamedModel(uri));
            this.dataset.replaceNamedModel(uri, new_model);
        }
    }    
    
    /* methode qui affiche les resultat d'une requette dans le resultset passé en parametre*/
    public void afficherRes(ResultSet results) {
        QuerySolution soln = null;
        for ( ; results.hasNext() ; ) {
            soln = results.nextSolution() ;
            System.out.println(soln.toString());
        }
    }

    
    
}
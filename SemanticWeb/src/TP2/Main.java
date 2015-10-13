package TP2;


import org.apache.jena.query.ResultSet;

public class Main {

	/**
	 * @param args
	 * @throws  
	 */
	public static void main(String[] args) {
		
		SparQLQuery SPQR = new SparQLQuery();
        ResultSet res = null;

        // on charge le graphe par défaut à partir d'un modèle RDF/XML
        SPQR.readDataDefaultGraph("peinture.rdfs");
        
        /* Requete 1 */
        System.out.println(" Requete 1 ");
		res = SPQR.doQuerySelect("requete1.rq");
        SPQR.afficherRes(res);
        
        /* Requete 2 */
        System.out.println(" Requete 2 ");
		res = SPQR.doQuerySelect("requete2.rq");
        SPQR.afficherRes(res);
        
        /* Requete 3*/
        System.out.println(" Requete 3 ");
		SPQR.doQueryUpdate("requete3.rq");

        /* Requete 4-1 */        
        System.out.println(" Requete 4-1 ");
		res = SPQR.doQuerySelect("requete4-1.rq");
        SPQR.afficherRes(res);

        /* Requete 4-2 */
        System.out.println(" Requete 4-2 ");
		res = SPQR.doQuerySelect("requete4-2.rq");
        SPQR.afficherRes(res);
        
        
        /* Question 5 */
        SPQR.enableRDFS(null);
        
        /* Question 6 */
        
        /* Requete 6-1 */        
        System.out.println(" Requete 6-1 ");
		res = SPQR.doQuerySelect("requete4-1.rq");
        SPQR.afficherRes(res);
        
        /* Requete 6-2 */
        System.out.println(" Requete 6-2 ");
		res = SPQR.doQuerySelect("requete4-2.rq");
        SPQR.afficherRes(res);
        
	}

}

package datastore;

import java.io.IOException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;


import javax.servlet.http.*;

@SuppressWarnings("serial")
public class DatastoreInsert extends HttpServlet {

        public void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws IOException {

                DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

                for(int i = 0; i < 100; i++) {
                        String id = "cheval" + i + "@cheval.org";
                        Entity cheval = new Entity("Cheval", id);

                        cheval.setProperty("Nom", "Du Marie D'agneau");
                        cheval.setProperty("Prenom", "Archibald The " + i);
                        datastore.put(cheval);

                }

                resp.setContentType("text/plain");

                resp.getWriter().println("Insertion effectuée avec succès");
        }
}
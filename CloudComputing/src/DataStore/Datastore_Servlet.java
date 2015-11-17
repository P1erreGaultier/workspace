package DataStore;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;


@SuppressWarnings("serial")
public class Datastore_Servlet extends HttpServlet {

        public void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws IOException {

                DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

                resp.setContentType("text/plain");

                resp.getWriter().println("Hello world !");

                /*for(int i = 0; i < 100; i++) {
                        Key key = KeyFactory.createKey("Cheval", "cheval" + i +"@cheval.org");
                        try {
                                Entity cheval = datastore.get(key);
                                resp.getWriter().println(cheval.toString());
                        } catch (EntityNotFoundException e) {
                                e.printStackTrace();
                        }
                }*/
                Filter nameFilter =
                         new FilterPredicate("Nom",
                                                        FilterOperator.EQUAL, "Du Marie D'agneau");
                Filter prenomFilter =
                                new FilterPredicate("Prenom",
                                                        FilterOperator.EQUAL, "Archibald The 93");

                Filter preciseFilter =
                                  CompositeFilterOperator.and(nameFilter, prenomFilter);


                // Use class Query to assemble a query
                Query q = new Query("Cheval").setFilter(preciseFilter);

                // Use PreparedQuery interface to retrieve results
                PreparedQuery pq = datastore.prepare(q);

                for (Entity cheval : pq.asIterable()) {
                        resp.getWriter().println(cheval.toString());
                }
        }
}